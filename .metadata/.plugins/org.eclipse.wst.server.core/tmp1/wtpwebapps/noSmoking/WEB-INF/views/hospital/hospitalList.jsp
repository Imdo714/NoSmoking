<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" href="/smoking/resources/css/hospital/hospitalList.css">
	<script src="resources/js/hospital/hospitalList/hospital.js"></script>
	<script src="resources/js/hospital/hospitalList/hospitalAjax.js"></script>
	<!-- jQuery library -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
<jsp:include page="../common/header.jsp" />
	<div>
        <div class="hospital-center">
            <div class="hospital-No">
                <img src="./resources/img/main/보건소.png" class="market-img">
                <div class="pont-se">전국 보건소 찾기</div>
            </div>
        </div>

        <div class="hospital-center">
            <div class="search-div">
                <div class="search-title">
                    <input type="checkbox" id="myCheckbox" onclick="checkOne(this)" name="hospital" value="기관명">
                    <div class="check-div">기관명</div>
                </div>
                
                <div class="search-title">
                    <input type="checkbox" id="myCheckbox" onclick="checkOne(this)" name="hospital" value="지역">
                    <div class="check-div">지역</div>
                </div>

                <div class="search-title">
                    <input type="checkbox" id="myCheckbox" onclick="checkOne(this)" name="hospital" value="주소">
                    <div class="check-div">주소</div>
                </div>

                <div class="search-title">
                    <input type="checkbox" id="myCheckbox" onclick="checkOne(this)" name="hospital" value="전화번호">
                    <div class="check-div">전화번호</div>
                </div>

                <div class="search-title2">
                    <input type="text" class="search-input" id="search">
                    <button class="search-btn" onclick="search()">검색</button>
                </div>
            </div>
        </div>

		<div class="hospital-center">
			<table class="table">
				<thead>
					<tr>
						<th class="table-title" scope="col">기관명</th>
						<th class="table-title" scope="col">지역</th>
						<th class="table-title" scope="col">주소</th>
						<th class="table-title" scope="col">전화번호</th>
					</tr>
				</thead>
				<tbody id="hospitalTable">
					<c:forEach var="h" items="${list}">
						<tr onclick="send(`${h.hospitalNo}`)">
							<th class="inpo-th" scope="row">${h.hospitalName}</th>
							<td class="inpo-td">
								<div class="table-addres">${h.hospitalCity}</div>
							</td>
							<td class="inpo-td">
								<div class="table-addres">${h.hospitalAddress}</div>
							</td>
							<td class="inpo-td">
								<div class="table-addres">${h.hospitalPhone}</div>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

		<div class="hospital-center">
            <c:choose>
       		<c:when test="${ pi.currentPage eq 1 }">
           		<button class="num-btn"> &lt;</button>
           	</c:when>
           	<c:otherwise>
           		<button class="num-btn"><a href="searchHospital.ho?cpage=${pi.currentPage - 1}">&lt;</a></button>
           	</c:otherwise>
		</c:choose>

		<c:forEach var="d" begin="${pi.startPage}" end="${ pi.endPage }" >
       		<button class="num-btn"><a href="searchHospital.ho?cpage=${d}" id="text">${d}</a></button>
        </c:forEach>
 
        
        <c:choose>
    		<c:when test="${ pi.currentPage eq pi.maxPage }">
        		<button class="num-btn"> &gt; </button>
        	</c:when>
        	<c:otherwise>
        		<button class="num-btn"><a href="searchHospital.ho?cpage=${pi.currentPage + 1}">&gt;</a></button>
        	</c:otherwise>
		</c:choose>
        </div>
    </div>
</body>
</html>