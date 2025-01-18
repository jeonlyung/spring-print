package com.image.controller;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

@RequestMapping("/convert")
@Controller
public class ConvertController {

    @GetMapping("/excelToImage")
    public ResponseEntity<byte[]> convertExcelToImage() {
        // ResponseEntity<byte[]> 이미지 데이터 같은 이진 데이터를 반환시키기 위한 타입

        String excelFilePath = ""; // 엑셀 파일 경로
        // String outputImagePath = ""; // 출력 이미지 파일 경로

        try (FileInputStream fis = new FileInputStream(excelFilePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            // 엑셀 파일의 첫 번째 시트 Get
            Sheet sheet = workbook.getSheetAt(0);

            int imageWidth = 800;
            int imageHeight = 600;
            BufferedImage image = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_ARGB);
            // 그래픽 객체 생성
            Graphics2D graphics = image.createGraphics();
            graphics.setColor(Color.WHITE);
            graphics.fillRect(0, 0, imageWidth, imageHeight);
            graphics.setFont(new Font("Arial", Font.PLAIN, 12));
            graphics.setColor(Color.BLACK);

            int rowHeight = 20;
            int startX = 10;
            int startY = 20;
            for (Row row : sheet) {
                int currentX = startX;
                for (Cell cell : row) {
                    String cellValue = getCellValueAsString(cell);
                    graphics.drawString(cellValue, currentX, startY);
                    currentX += 100;
                }
                startY += rowHeight;
            }

            // 그래픽 객체 자원 해제
            graphics.dispose();
            
            // ByteArrayOutputStream을 사용하여 BufferedImage를 byte[]로 변환
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            // BufferedImage를 바이트 스트림에 쓰기
            ImageIO.write(image, "png", baos);  
            baos.flush();
            // 바이트 배열로 변환
            byte[] imageBytes = baos.toByteArray();  
            baos.close();

            return ResponseEntity.ok()
                                 .contentType(org.springframework.http.MediaType.IMAGE_PNG)
                                 .body(imageBytes);

        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    private String getCellValueAsString(Cell cell) {
        if (cell == null) return "";
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                return String.valueOf(cell.getNumericCellValue());
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case FORMULA:
                return cell.getCellFormula();
            default:
                return "";
        }
    }
}
