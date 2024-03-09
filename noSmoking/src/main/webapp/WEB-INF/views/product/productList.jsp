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
	<link rel="stylesheet" href="/smoking/resources/css/prdouct/productList.css">
	<script src="resources/js/product/insertProduct/product.js"></script>
	<script src="resources/js/product/insertProduct/productAjax.js"></script>
	<!-- jQuery library -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>

<jsp:include page="../common/header.jsp" />
	<div>
        <div class="video-center">
            <div class="video-No">
                <img src="./resources/img/main/편의점.png" class="market-img">
                <div class="pont-se">금연 상품</div>
            </div>
        </div>
    </div>

    <div>
        <div class="video-center">
            <div class="insert-btn">
	            <c:choose>
	            	<c:when test="${empty loginUser}">
	            		<button type="button" onclick="clance()" class="cart-btn">
			       			내 장 바구니 
		                </button>
		                
		                <button onclick="clance()" class="btn btn-primary">
		                                         금연 상품 등록
		                </button>
	            	</c:when>
	            	<c:otherwise>
	            		<button type="button" onclick="location.href='shopeCart.pr'" class="cart-btn">
			       			내 장 바구니 
		                </button>
		                
		                <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
		                                         금연 상품 등록
		                </button>
	            	</c:otherwise>
	            </c:choose>
            </div>
        </div>
    </div>

   <div class="video-center">
        <div class="video-theme">
			<c:forEach var="p" items="${list}">
			<a onclick="location.href='productDetailView.pr?pNo=${p.productNo}'">
				<div class="get">
	                <div class="video-teul">
	                	<c:forEach var="i" items="${firstImage}">
	                	<c:choose>
	                		<c:when test="${i.productNo eq p.productNo}">
	                			<img src="${i.productChangName}" class="video-sumnail"></img>
	                		</c:when>
	                		<c:otherwise>
	                		</c:otherwise>
	                	</c:choose>
	                    </c:forEach>
	                </div>
	                <div class="viedo-title">
	                    	${p.productName}
	                </div>
	                <div class="viedo-sub">
	                    	가격 : ${p.productPrice}
	                </div>
	            </div>
	         </a>
	            </c:forEach>
        </div>
    </div>
    

    <div class="video-center1">
        <c:choose>
       		<c:when test="${ pi.currentPage eq 1 }">
           		<button class="num-btn"> &lt;</button>
           	</c:when>
           	<c:otherwise>
           		<button class="num-btn"><a href="productList.pr?cpage=${pi.currentPage - 1}">&lt;</a></button>
           	</c:otherwise>
		</c:choose>

		<c:forEach var="d" begin="${pi.startPage}" end="${ pi.endPage }" >
       		<button class="num-btn"><a href="productList.pr?cpage=${d}" id="text">${d}</a></button>
        </c:forEach>
 
        
        <c:choose>
    		<c:when test="${ pi.currentPage eq pi.maxPage }">
        		<button class="num-btn"> &gt; </button>
        	</c:when>
        	<c:otherwise>
        		<button class="num-btn"><a href="productList.pr?cpage=${pi.currentPage + 1}">&gt;</a></button>
        	</c:otherwise>
		</c:choose>
    </div>





  <!-- Modal -->
  <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header22">
            <div class="modal-header22"></div>
          <h1 class="modal-title22" id="exampleModalLabel">상품 등록</h1>
          <div class="close">
            <div class="modal-header33">
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
          </div>
        </div>
        <div class="modal-body">
            <div class="video-center">
                <div class="filebox">
                <form action="insertProduct.pr" method="post" enctype="multipart/form-data">
                    <div class="btn-upload">
                        <img id="file-img1" style="width: 76px; height: 74px;" onclick="clickImg(1)">
                        <img id="file-img2" style="width: 76px; height: 74px;" onclick="clickImg(2)">
                        <img id="file-img3" style="width: 76px; height: 74px;" onclick="clickImg(3)">
                        <img id="file-img4" style="width: 76px; height: 74px;" onclick="clickImg(4)">
                    </div>
                
                    <input type="file" name="upfile" id="fileImgFile1" onchange="loadImg(this,1)" required>
                    <input type="file" name="upfile" id="fileImgFile2" onchange="loadImg(this,2)">
                    <input type="file" name="upfile" id="fileImgFile3" onchange="loadImg(this,3)">
                    <input type="file" name="upfile" id="fileImgFile4" onchange="loadImg(this,4)">
                </div>
            </div>
            

            <div class="input-container">
                <div>상품이름 : </div>
                <textarea name="productName" placeholder="내용을 입력해 주세요."></textarea>
            </div>

            <div class="input-container">
                <div>상품가격 : </div>
                <textarea name="productPrice" placeholder="내용을 입력해 주세요."></textarea>
            </div>

            <div class="input-container">
                <div>상품설명 : </div>
                <textarea name="productContent" placeholder="내용을 입력해 주세요."></textarea>
            </div>
        </div>
        <div class="modal-footer">
          <button type="reset" class="btn btn-secondary" data-bs-dismiss="modal">취소</button>
          <button type="submit" class="btn btn-primary">등록</button>
          </form>
        </div>
      </div>
    </div>
  </div>
</body>
</html>