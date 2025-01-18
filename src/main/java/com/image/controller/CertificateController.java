package com.image.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/cert")
@Controller
public class CertificateController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CertificateController.class);

    @GetMapping("/certificate.do")
    public String certificate(Model model){
        LOGGER.debug("certificate 페이지 호출");
        System.out.println("증명서 컨트롤러 입장");
        return "excel/certificate";
    }
}
