<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" href="/smoking/resources/css/prdouct/cart.css">
	<script src="resources/js/product/cart/cart.js"></script>
	<script src="resources/js/product/cart/cartAjax.js"></script>
	<script src="resources/js/common/kakaoPay/kakaoPay.js"></script>
	<script src="resources/js/common/kakaoPay/kakaoPayAjax.js"></script>
	<!-- jQuery library -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body onload="init()">
<jsp:include page="../common/header.jsp" />
	<section class="cart">
        <div class="cart__information">
            <ul>
                <li>장바구니 상품은 최대 30일간 저장됩니다.</li>
                <li>가격, 옵션 등 정보가 변경된 경우 주문이 불가할 수 있습니다.</li>
                <li>오늘출발 상품은 판매자 설정 시점에 따라 오늘출발 여부가 변경될 수 있으니 주문 시 꼭 다시 확인해 주시기 바랍니다.</li>
            </ul>
        </div>
        <table class="cart__list">
            
                <thead>
                    <tr>
                        <td></td>
                        <td colspan="2">상품정보</td>
                        <td>옵션</td>
                        <td>상품금액</td>
                        <td>배송비</td>
                    </tr>
                </thead>
                <tbody>
                   <c:forEach var="p" items="${product}">
                    <tr class="cart__list__detail">
                        <td style="width: 2%;">
                            <input type="checkbox" id="myCheckbox${p.productNo}" value="${p.productNo}" onclick="check('${p.productNo}')">
                        </td>
                        <td style="width: 13%;">
                        <c:forEach var="i" items="${firstImage}">
	                	<c:choose>
	                		<c:when test="${i.productNo eq p.productNo}">
	                			<img src="${i.productChangName}" class="video-sumnail"></img>
	                		</c:when>
	                		<c:otherwise>
	                		</c:otherwise>
	                	</c:choose>
	                    </c:forEach>
                        </td>
                        <td style="width: 27%;"><a href="main.me">NO SMOKING</a><span class="cart__list__smartstore"> 스마트스토어</span>
                            <p>상품명 : ${p.productName}</p>
                            <span class=" price">단가 : <input value="${p.productPrice}" id="sumPrice" class="cartCount1"></span>
                        </td>
                        
                        
                        <td class="cart__list__option" style="width: 27%;">
                        <c:forEach var="l" items="${list}">
                            
                            <c:choose>
	                		<c:when test="${l.productNo eq p.productNo}">
	                			<p>상품 주문 수량: <input value="${l.cartCount}" id="count" class="cartCount">개</p>
                            	<button class="cart__list__optionbtn" onclick="location.href='cartUpdate.pr?pNo=${p.productNo}'">주문조건 추가/변경</button>
	                		</c:when>
	                		<c:otherwise>
	                		</c:otherwise>
	                	</c:choose>
                        </c:forEach>
                        </td>
                        
                        
                        <td style="width: 15%;">
                            <input value="${p.productPrice}" class="sumPrice" id="price${p.productNo}">
                            <br>
                            <button class="cart__list__orderbtn" onclick="soloOrder('${p.productNo}')">주문하기</button>
                        </td>
                        <td style="width: 15%;">무료</td>
                    </tr>
                    </c:forEach>
                </tbody>
                <tfoot>
                    <tr>
                        <td colspan="3">
                            <button class="cart__list__optionbtn" onclick="deleteCart()">선택상품 삭제</button>
                            <button class="cart__list__optionbtn">선택상품 찜</button>
                        </td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                </tfoot>
            
        </table>
        <div class="cart__mainbtns">
            <button class="cart__bigorderbtn left" onclick="location.href='productList.pr'">쇼핑 계속하기</button>
            <button class="cart__bigorderbtn right" onclick="teamOrder()">주문하기</button>
        </div>
    </section>
	
</body>
</html>