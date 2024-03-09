<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css" rel="stylesheet">
	<link rel="stylesheet" href="/smoking/resources/css/video/videoList.css">
	<script src="resources/js/video/videoList/video.js"></script>
	<script src="resources/js/video/videoList/videoAjax.js"></script>
	<!-- jQuery library -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
<jsp:include page="../common/header.jsp" />
	<div>
        <div class="video-center">
            <div class="video-No">
                <img src="./resources/img/main/영상시청.png" class="market-img">
                <div class="pont-se">자료실</div>
            </div>
        </div>
    </div>

    <div>
        <div class="video-center">
            <div class="insert-btn">
                <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
                    자료실 영상 등록
                </button>
            </div>
        </div>
    </div>

    <div class="video-center">
        <table class="video_table">
            <thead>
                <tr>
                    <th style="text-align: center;">번호</th>
                    <th style="text-align: center;">제목</th>
                    <th>글쓴이</th>
                </tr>
            </thead>
            <tbody id="table-video">
            <c:forEach var="p" items="${list}">
                <tr onclick="location.href='detailVideo.vi?vNo=${p.videoNo}'">
                    <td class="center" style="text-align: center;">${p.videoNo}</td>
                    <td class="left" style="text-align: center;">${p.videoContent}</td>
                    <td class="center">${p.userName}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

    <div class="video-center" id="video_btn">
        <c:choose>
       		<c:when test="${ pi.currentPage eq 1 }">
           		<button class="num-btn"> &lt;</button>
           	</c:when>
           	<c:otherwise>
           		<button class="num-btn"><a href="video.vi?cpage=${pi.currentPage - 1}">&lt;</a></button>
           	</c:otherwise>
		</c:choose>

		<c:forEach var="d" begin="${pi.startPage}" end="${ pi.endPage }" >
       		<button class="num-btn"><a href="video.vi?cpage=${d}" id="text">${d}</a></button>
        </c:forEach>
 
        
        <c:choose>
    		<c:when test="${ pi.currentPage eq pi.maxPage }">
        		<button class="num-btn"> &gt; </button>
        	</c:when>
        	<c:otherwise>
        		<button class="num-btn"><a href="video.vi?cpage=${pi.currentPage + 1}">&gt;</a></button>
        	</c:otherwise>
		</c:choose>
    </div>





  <!-- Modal -->
  <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header22">
            <div class="modal-header22"></div>
          <h1 class="modal-title22" id="exampleModalLabel">자료실 영상등록</h1>
          <div class="close">
            <div class="modal-header33">
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
          </div>
        </div>
        <div class="modal-body">
            <div class="video-center">
               <input type="text" id="link" class="form-control" style="margin-bottom: 20px;" name="studyLink" required placeholder="동영상 주소 입력.">
            </div>
            

            <div class="input-container">
                <div>내용 </div>
                <textarea placeholder="내용을 입력해 주세요." id="videoText"></textarea>
            </div>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">취소</button>
          <button type="button" class="btn btn-primary" onclick="videoUpdate()">등록</button>
        </div>
      </div>
    </div>
  </div>
</body>
</html>