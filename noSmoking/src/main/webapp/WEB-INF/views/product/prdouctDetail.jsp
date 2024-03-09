<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" href="/smoking/resources/css/prdouct/prdouctDetail.css">
	<script src="/smoking/resources/js/common/main.js"></script>
	<script src="resources/js/product/productDetail/productDetail.js"></script>
	<script src="resources/js/product/productDetail/productDetailajax.js"></script>
	<script src="resources/js/common/kakaoPay/kakaoPay.js"></script>
	<script src="resources/js/common/kakaoPay/kakaoPayAjax.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
<jsp:include page="../common/header.jsp" />

	<div class="product-No">
	
	    <div class="product-No1">
	        <span class="slideshow-container">
	            <div class="Slidesbackground">
	            <c:forEach var="i" items="${pImg}">
                    <div class="mySlides fade">
                        <img src="${i.productChangName}" class="slideshow-image">
                    </div>
                </c:forEach>
	            </div>
	        </span>
	    </div>
	
	
        <div style="display: block;">
        <c:forEach var="p" items="${list}">
            <div class="product-No2">
                <div class="product-name">
                    <div class="teul">
                        <span>${p.productName}</span>
                    </div>
                    <div class="teul">
                        <span>${p.productPrice}</span>
                    </div>
                </div>
                <div class="product-heart">
                    <input type="checkbox" class="heart-checkbox" id="heartCheckbox">
                    <label for="heartCheckbox"></label>
                </div>
            </div>

            <div class="product-No3">
                <div class="product-price">
                    <span class="qqq">택배배송</span>
                </div>
                <div class="product-heart"></div>
            </div>

            <div class="product-No2">
                <div class="product-price">
                    <div class="teul-tt">
                    	<button onclick="productMin('${p.productPrice}')">-</button>
                        <input type="number" class="number-count" id="number-count" value="1">
                        <button onclick="productPlus('${p.productPrice}')">+</button>
                    </div>
                </div>
            </div>

            <div class="product-No2">
                <span class="eee">총 상품 금액</span>
                <div class="product-price">
                    <input type="text" id="price-count" class="price-count" value="${p.productPrice}">
                </div>
            </div>

            <div class="product-No4">
	            <c:choose>
	            	<c:when test="${empty loginUser}">
	            		<button class="product-btn" onclick="clance()">장바구니</button>
	            		<button class="product-btn1" onclick="clance()">구매</button>
	            	</c:when>
	            	<c:otherwise>
	            		<button class="product-btn" onclick="cart('${loginUser.userNo}', '${p.productNo}')">장바구니</button>
	            		<button class="product-btn1" onclick="detailOrder('${p.productNo}', '${p.productPrice}', '${p.productName}')">구매</button>
	            	</c:otherwise>
	            </c:choose>
            </div>

            <div class="product-last">
                <div class="product-name">
                    <div class="teul">
                        <span style="font-size: 23px;">상품설명</span>
                    </div>
                    <div>
                        <span style="font-size: 16px; margin-left: 10px;">${p.productContent}</span>
                    </div>
                </div>
            </div>
            </c:forEach>
        </div>
    </div>

    <div class="product-good">
        <div class="promotion22">
            <span>이런 상품은 어떠신가요??</span>
        </div>
    </div>

    <div class="product-Noplus">
        <div class="product-plus">
        <c:forEach var="L" items="${proList}">
	        <a onclick="location.href='productDetailView.pr?pNo=${L.productNo}'">
	            <div class="theme">
	                <div class="sumnali">
	                
	                	<c:forEach var="s" items="${firstImage}">
		                	<c:choose>
		                		<c:when test="${s.productNo eq L.productNo}">
		                			<img src="${s.productChangName}" alt="" class="sumnali-img">
		                		</c:when>
		                		<c:otherwise>
		                		</c:otherwise>
		                	</c:choose>
		                </c:forEach>
	                </div>
	                <div class="sumnali-title">
	                   	 ${L.productName}
	                </div>
	            </div>
	         </a>
		</c:forEach>
        </div>
    </div>
</body>
</html>