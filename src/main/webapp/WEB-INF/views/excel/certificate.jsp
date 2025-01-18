<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Buttons Example</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        .button-container {
            display: flex;
            flex-wrap: wrap;
            gap: 15px;
            justify-content: center;
            max-width: 600px;
        }

        .button-container button {
            background-color: #4CAF50; /* Green background */
            border: none;
            color: white; /* White text */
            padding: 10px 20px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            margin: 4px 2px;
            cursor: pointer;
            border-radius: 8px; /* Rounded corners */
            transition: background-color 0.3s ease, transform 0.2s ease;
        }

        .button-container button:hover {
            background-color: #45a049; /* Darker green on hover */
            transform: scale(1.1); /* Slight zoom-in effect */
        }

        .button-container button:active {
            background-color: #3e8e41; /* Even darker green on click */
            transform: scale(1);
        }
    </style>
</head>
<body>
    <div class="button-container">
        <button onclick="fnGoCertificate()">증명서 발급</button>
        <button>Button 2</button>
        <button>Button 3</button>
        <button>Button 4</button>
        <button>Button 5</button>
        <button>Button 6</button>
        <button>Button 7</button>
        <button>Button 8</button>
        <button>Button 9</button>
        <button>Button 10</button>
    </div>
</body>

<script>
    function fnGoCertificate(){
        location.href = "/cert/certificate.do";
    }
</script>

</html>
