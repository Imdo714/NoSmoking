<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" href="/smoking/resources/css/member/writer.css">
	<script src="resources/js/member/writer/writer.js"></script>
	<script src="resources/js/member/writer/writerAjax.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>

<jsp:include page="../common/header.jsp" />
	 <div class="qwer">
        <div class="writer-center">
            <div class="writer-title">
                <strong>금연 신청서</strong>
            </div>
        </div>
    </div>
	
	<c:choose>
		<c:when test="${empty loginUser}">
			<div class="qwer">
		        <div class="writer-center2">
		            <div class="aaaaa">
		                <div class="writer-name">
		                    신청인 : 
		                </div>
		
		                <div class="writer-pho">
		                    성명 : 
		                </div>
		
		                <div class="writer-pho1">
		                    전화번호 :
		                </div>
		            </div>
		        </div>
		    </div>
		</c:when>
		<c:otherwise>
			<div class="qwer">
		        <div class="writer-center2">
		            <div class="aaaaa">
		                <div class="writer-name">
		                    신청인 : <br> ${loginUser.userName}
		                </div>
		
		                <div class="writer-pho">
		                    성명 : ${loginUser.userName}
		                </div>
		
		                <div class="writer-pho1">
		                    전화번호 :  ${loginUser.phone}
		                </div>
		            </div>
		        </div>
		    </div>
		</c:otherwise>
	</c:choose>
	
    

    <div class="qwer">
        <div class="writer-center2">
            <div class="aaaaa">
                <div class="writer-name">
                    신청시<br> 유의사항
                </div>

                <div class="writer-sea">
                    1. 도중에 언제든 금연을 포기 할 수 있다.<br>
                    2. 금연 신청서를 작성하는 순간 편의점에서 담배를 구입하지 못합니다.<br>
                    3. 금연 신청을 하게 되면 No Smoking에서 금연을할 수 있도록 지원을 할 것입니다.
                </div>

            </div>
        </div>
    </div>

    <div class="qwer">
        <div class="writer-center2">
            <div class="wr-text">
                국민건강증진법 제34조제5항, 같은 법 시행령 제34조제2항 및 
                가튼 법 시행규칙 제22조의2제1항에 따라 교육 또는 금연지원 서비스를 신청합니다.
                <br><br><br>
                <input id="checkbox" type="checkbox" required>[필수] 서비스 이용 약관, 개인정보 처리 동의
            </div>
        </div>
    </div>

    <div class="qwer">
        <div class="writer-center3">
            <button class="cel-btn1" onclick="location.href='main.me'">취소하기</button>
            <c:choose>
            	<c:when test="${empty loginUser}">
            		<button class="cel-btn" onclick="clance()">신청하기</button>
            	</c:when>
            	<c:otherwise>
            		<button class="cel-btn" onclick="application()">신청하기</button>
            	</c:otherwise>
            </c:choose>
        </div>
    </div>
</body>
</html>