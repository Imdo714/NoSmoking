<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
	<link rel="stylesheet" href="/smoking/resources/css/member/insertMember.css">
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script src="resources/js/member/insertMember/insertMemberAjax.js"></script>
    <script src="resources/js/member/insertMember/insertMember.js"></script>
</head>
<body>
<div class="outer">
        <div class="join-main" >
            <div class="join-header">
                <a href="main.me"><img src="./resources/img/main/금연프로젝트.png"></a>
            </div>
            <br><br><br>
     			
                <div class="join-middle">
                    <div class="form-floating mb-3">
                        <p class="join-font">아이디</p>
                        <input type="text" class="form-control id userid" name="userId" value="" id="inputId" placeholder="name@example.com">
                        <div id="checkResult" style="font-size:0.7em; display:none;"></div>
                    </div> 
                    <div class="join-password-part">
                        <div class="form-floating mb-3 join-half">
                            <p class="join-font">비밀번호</p>
                            <input type="password" class="form-control id " name="userPwd" value="" id="inputPass">
                            <div id="checkResult2" style="font-size:0.7em; color:red;">*비밀번호는 영문 숫자 특수기호 조합 8자리 이상 </div>
                            <div id="checkResult3" style="font-size:0.7em; color:red;">*비밀번호 확인 </div>
                        </div> 
                        <div class="form-floating mb-3 join-half">
                            <p class="join-font">비밀번호 확인</p>
                            <input type="password" class="form-control id " value="" id="inputCheckPass">
                        </div>
                    </div>
                    
                    <br>
                    <div class="join-password-part">
                        <div class="form-floating mb-3 join-half">
                            <p class="join-font">이름</p>
                            <input type="text" class="form-control id" name="userName" value="" id="inputName" placeholder="name@example.com">
                        </div> 
                        <div class="form-floating mb-3 join-half">
                            <p class="join-font">성별</p>
                            <select type="text" class="form-control id" name="gender" value="" id="inputSex" placeholder="name@example.com">
                                <option value="남자">남</option>
                                <option value="여자">여</option>
                            </select>
                        </div> 
                    </div>

               
                    <div class="join-password-part">
                        <div class="form-floating mb-3 join-half">
                            <p class="join-font">생년월일</p>
                            <input type="date" class="form-control id" name="age" value="" id="inputBirth" placeholder="name@example.com" style="width: 200%;">
                        </div> 
                    </div>
                    
                    <p class="join-font">주소</p>
                    <div class="join-password-part">
                        <input type="text" style="padding: 10px; width: 100%;" class="address-input" id="sample4_jibunAddress" name="address" placeholder="주소">
                        <input type="button" style="width: 100px; height: 47px;" onclick="sample6_execDaumPostcode()" value="검색">
                    </div><br>
                    
                    <p class="join-font">휴대폰 번호</p>
                        <div class="join-password-part">
                            <div class="form-floating mb-3 join-phone">
                                <input type="text" name="phone" value="" class="form-control id" id="inputPhone" placeholder="name@example.com">
                            </div> 
                            <button type="button"  class="btn btn-primary" onclick="" id="phone-certified-btn">인증요청</button>
                        </div>
                    <div class="d-grid gap-2 join-btn-div" >
                        <button class="btn btn-primary" id="join-btn" type="submit" onclick="check()">회원가입</button>
                    </div>
                </div>
            
        </div>
    </div>

      <button type="button" style="display: none;" class="btn btn-primary" id="authBtn" data-bs-toggle="modal" data-bs-target="#exampleModal2">
        Launch demo modal
      </button>
      <!-- Modal -->
      <div class="modal fade" id="exampleModal2" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered">
          <div class="modal-content">
            <div class="modal-header" align="center">
              <h1 class="modal-title fs-5" id="exampleModalLabel">인증번호</h1>
              <button type="button" class="btn-close" id="auth-modal-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <div class="join-password-part">
                    <div class="form-floating mb-3 join-phone">
                        <input type="number"class="form-control id" id="floatingInput2" placeholder="name@example.com">
                    </div> 
                    <button type="button" onclick="checkPhoneAuth()" class="btn btn-primary" >확인</button>
                </div>
                <div id="checkTime"></div>
            </div>
          </div>
        </div>
      </div>

      
</body>
</html>