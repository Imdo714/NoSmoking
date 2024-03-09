<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" href="/smoking/resources/css/hospital/hospitalDetail.css">
	<!-- jQuery library -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=db2c0475e64a6abacffa41a2a70743de&libraries=services"></script>
	<script src="resources/js/hospital/hospitalMap/map.js"></script>
	<script src="resources/js/hospital/hospitalDetail/hospitalDetail.js"></script>
	<script src="resources/js/hospital/hospitalDetail/hospitalDetailAjax.js"></script>
</head>
<body onload="map(`${result.hospitalAddress}`,`${result.hospitalName}`)">
<jsp:include page="../common/header.jsp" />
	<div class="map-teul">
        <div class="map-size">
        	<div id="map" class="map-img"></div>
        	
        </div>
    </div>
    <div class="map-teul">
        <table class="table-map">
            <thead>
                <tr>
                    <th class="table-title2" scope="col">기관명</th>
                    <th class="table-title2" scope="col">${result.hospitalName}</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <th class="inpo-th" scope="row">주소</th>
                    <td class="inpo-td">
                        <div class="table-addres">
                            ${result.hospitalAddress}
                        </div>
                    </td>
                </tr>
                <tr>
                    <th class="inpo-th" scope="row">전화번호</th>
                    <td class="inpo-td">
                        <div class="table-addres">
                           ${result.hospitalPhone}
                        </div>
                    </td>
                </tr>
            </tbody>
        </table>
    </div>
	
    <div class="map-teul">
        <button onclick="location.href='searchHospital.ho'" class="back-btn">뒤로 </button>
    </div>

    <div class="map-teul">
        <div class="Reply-teulNo">
            <div class="Reply">댓글</div>
        </div>
    </div>

    <div class="map-teul">
        <div class="Reply-teulNo">
            <textarea class="Reply-input"></textarea>
            <c:choose>
	            <c:when test="${empty loginUser}">
	            	<button class="Reply-btn" onclick="clance()">등록</button>
	            </c:when>
	            <c:otherwise>
	            	<button class="Reply-btn" onclick="insertReply(`${result.hospitalNo}`, `${loginUser.userNo}`)">등록</button>
	            </c:otherwise>
            </c:choose>
        </div>
    </div>

    <div class="map-teul">
        <table class="table-map2">
            <tbody id="ReplyContent">
            <c:forEach var="p" items="${list2}">
                <tr>
                    <th class="Reply-th" scope="row">임도현</th>
                    <td class="Reply-td" id="Reply-text${p.replyNo}">
                        <div class="Reply-text" >
                          ${p.replyContent}
                        </div>
                        <div class="Reply-text-btn">
                        <c:choose>
                        	<c:when test="${p.userNo eq loginUser.userNo}">
                        		<button onclick="updateReply(`${p.replyContent}`, `${p.replyNo}`, `${result.hospitalNo}`, `${loginUser.userNo}`)">수정</button>
                            	<button onclick="deleteReply(`${p.replyNo}`, `${result.hospitalNo}`, `${loginUser.userNo}`)">삭제</button>
                        	</c:when>
                        	<c:otherwise>
                        	</c:otherwise>
                        </c:choose>
                        </div>
                    </td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    
    <div class="map-teul" id="Reply-btn">
        <c:choose>
            <c:when test="${empty list2}">
            	
            </c:when>
            <c:otherwise>
            	<c:choose>
       		<c:when test="${ pi.currentPage eq 1 }">
           		<button class="num-btn"> &lt;</button>
           	</c:when>
           	<c:otherwise>
           		<button class="num-btn"><a href="hospitalDetail.ho?hNo=${result.hospitalNo}&cpage=${pi.currentPage - 1}">&lt;</a></button>
           	</c:otherwise>
		</c:choose>

		<c:forEach var="d" begin="${pi.startPage}" end="${ pi.endPage }" >
       		<button class="num-btn"><a href="hospitalDetail.ho?hNo=${result.hospitalNo}&cpage=${d}" id="text">${d}</a></button>
        </c:forEach>
        
        <c:choose>
    		<c:when test="${ pi.currentPage eq pi.maxPage }">
        		<button class="num-btn"> &gt; </button>
        	</c:when>
        	<c:otherwise>
        		<button class="num-btn"><a href="hospitalDetail.ho?hNo=${result.hospitalNo}&cpage=${pi.currentPage + 1}">&gt;</a></button>
        	</c:otherwise>
		</c:choose>
            </c:otherwise>
        </c:choose>
    </div>
        	
    
</body>
</html>