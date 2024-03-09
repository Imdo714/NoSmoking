<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/smoking/resources/css/video/videoDetail.css">
</head>
<body>
<jsp:include page="../common/header.jsp" />

	<c:forEach var="p" items="${list}">
		<div class="detail-center">
			<iframe width="800" height="500" src="${p.videoUrl}" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>
		</div>
   
	
	    <div class="detail-center">
	        <div class="text-detail">
	            ${p.videoContent}
	        </div>
	    </div>
    </c:forEach>

    <div class="detail-center">
        <button class="detail-btn" onclick="location.href='video.vi'">돌아가기</button>
    </div>
</body>
</html>