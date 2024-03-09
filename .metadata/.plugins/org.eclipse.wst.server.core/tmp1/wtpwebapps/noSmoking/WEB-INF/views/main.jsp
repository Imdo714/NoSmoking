<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" href="/smoking/resources/css/common/main.css">
	<!-- jQuery library -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="/smoking/resources/js/common/main.js"></script>
	<script src="/smoking/resources/js/common/mainAjax.js"></script>
</head>
<body onload="productRefesh(), noSmoking()">

	<jsp:include page="common/header.jsp" />
	<div class="smoking">
        
        <span class="slideshow-container">
            <div class="Slidesbackground">
               <div class="mySlides fade">
               <img src="./resources/img/main/광고.jpg" class="slideshow-image">
               </div>
               <div class="mySlides fade">
                   <img src="./resources/img/main/광고1.jpg" class="slideshow-image">
               </div>
               <div class="mySlides fade">
                   <img src="./resources/img/main/광고2.jpeg" class="slideshow-image">
               </div>
               <div class="mySlides fade">
                   <img src="./resources/img/main/광고3.jpeg" class="slideshow-image">
               </div> 
           </div>
        </span>

        <br><br><br>

        <div class="aaa">
            <div class="promotion22">
                <span>금연 서비스</span>
            </div>
        </div>

        <div class="aaa">
            <div class="promotion-div">
                <div class="theme">
	                <a href="searchHospital.ho">
	                    <div class="sumnali">
	                        <img src="./resources/img/main/보건소.png" alt="" class="sumnali-img">
	                    </div>
	                    <div class="sumnali-title">
	                                                금연 할꺼면 <br> 보건소 찾으러 가자
	                    </div>
	                </a>
                </div>

                <div class="theme">
	                <a href="productList.pr">
	                    <div class="sumnali">
	                        <img src="./resources/img/main/영상시청.png" alt="" class="sumnali-img">
	                    </div>
	                    <div class="sumnali-title">
	                        	영상으로도<br> 흡연을 예방할 수 있어
	                    </div>
                    </a>
                </div>

                <div class="theme">
	                <a href="writer.me">
	                    <div class="sumnali">
	                        <img src="./resources/img/main/free-icon-contract-5987273.png" alt="" class="sumnali-img">
	                    </div>
	                    <div class="sumnali-title">
	                       	 금연 신청을<br> 해야 금연에 성공을<br>할 수 있어
	                    </div>	
                    </a>
                </div>
            </div>
        </div><br><br>
        
        <div class="boss-view-img">
            <div class="video">
                <div class="promotion22">
                    <img src="./resources/img/main/편의점.png" class="market-img">
                    <span>금연 상품</span>
                </div>

                <div class="no1" >
                    <div id="smoke" class="smoke">
                        <img src="/NoSmoking/img/광고2.jpeg" alt="" class="img-1">
                    </div>
                </div>
            
                <div class="bbb">
                    <div id="title-text" class="title-text">
                        <h2 class="text-pom22">안녕하세요</h2>
                    </div>
                </div>
            </div>
        </div>

        <div class="boss-view-img">
            <div class="challenge">
                <div class="challenge-theme" id="smoking">
                    <div class="challenge-title">
                        올해 금연 도전자
                    </div>
                    <div class="challenge-title">
                        50 명
                    </div>
                </div>

                <div class="challenge-theme">
                    <div class="challenge-title">
                        올해 금연 성공자
                    </div>
                    <div class="challenge-title">
                        5 명
                    </div>
                </div>
            </div>
        </div>

    </div>



</body>
</html>