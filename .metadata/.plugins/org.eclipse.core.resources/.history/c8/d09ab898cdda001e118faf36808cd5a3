<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" href="/smoking/resources/css/common/header.css">
	<!-- jQuery library -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="resources/js/member/insertMember/insertMemberAjax.js"></script>
    <script src="resources/js/member/insertMember/insertMember.js"></script>
</head>
<body>
	<div class="teul">
        <div class="head-Line">
            <a href="main.me"><img src="./resources/img/main/금연프로젝트.png" class="Logo"></a>

            <div class="head-title">
                <a href="searchHospital.ho">보건소 찾기</a>
            </div>
            <div class="head-title">
                <a href="video.vi">자료실</a>
            </div>
            <div class="head-title">
                <a href="productList.pr">금연 상품</a>
            </div>
            <div class="head-title">
                <a href="writer.me">금연 신청하기</a>
            </div>
			
			<c:choose>
				<c:when test="${empty loginUser}">
					<div class="head-user-title">
		                <a href="login.me"><img src="./resources/img/main/user.png" class="head-user"></a>
	            	</div>
				</c:when>
				<c:otherwise>
					<div class="head-user-title">
	                	<img src="./resources/img/main/로그아웃.png" onclick="logout()" class="head-user">
	            	</div>
				</c:otherwise>
			</c:choose>
            
        </div>
        <div class="head-foot"></div>
    </div>
</body>
</html>