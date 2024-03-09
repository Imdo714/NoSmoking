<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" href="/smoking/resources/css/common/errorPage.css">
</head>
<body>


	<div align="center" class="error-up">
        <img src="https://d31wz4d3hgve8q.cloudfront.net/static/img/img_404.png" class="error-img">
    </div>

    <div align="center">
        <h1>${errorMsg}</h1>
        <h3>침착하게 처음부터 확인 해보자</h3>
        <button onclick="location.href='/smoking'"  class="error-btn">홈으로 가기</button>
    </div>
    <br><br>
    
    
</body>
</html>