logout = () => {
    if (confirm("정말 로그아웃하시겠습니까??") == true){ 

        location.href = "logout.me";
    }else{  
        return false;
    }
}


sample6_execDaumPostcode = () =>{
    new daum.Postcode({
        oncomplete: function(data) { 
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var roadAddr = data.roadAddress; // 도로명 주소 변수
            var extraRoadAddr = ''; // 참고 항목 변수

            // 법정동명이 있을 경우 추가한다. (법정리는 제외)
            // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
            if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                extraRoadAddr += data.bname;
            }
            // 건물명이 있고, 공동주택일 경우 추가한다.
            if(data.buildingName !== '' && data.apartment === 'Y'){
               extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
            }
            // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
            if(extraRoadAddr !== ''){
                extraRoadAddr = ' (' + extraRoadAddr + ')';
            }

            // 주소 정보를 해당 필드에 넣는다.
            document.getElementById("sample4_jibunAddress").value = data.jibunAddress;
        }
    }).open();
}

check = () => {
    const result = passwordCheck();

    const userId = document.querySelector("#inputId").value;
    const userPwd = document.querySelector("#inputPass").value;
    const userName = document.querySelector("#inputName").value;
    const gender = document.querySelector("select[name=gender] :checked").value;
    const age = document.querySelector("#inputBirth").value;
    const address = document.querySelector("#sample4_jibunAddress").value;
    const phone = document.querySelector("#inputPhone").value;

    data = {
        userId : userId,
        userPwd : userPwd,
        userName : userName,
        gender : gender,
        age : age,
        address : address,
        phone : phone,
    }

    if(result === "ok"){
        if (data.userId !== '' && data.userPwd !== '' && data.userName !== '' && data.gender !== '' && data.age !== '' && data.address !== '' && data.phone !== '') {
            memberAjaxController.insertM(data,insertResult);
        } else {
            alert("빈 공백을 채우세요");
        }
    } else if (result === "fail1") {
        alert("비밀번호 형식에 맞추어 작성해주세요");
    } else {
        alert("비밀번호와 비밀번호 확인이 일치하지 않습니다.");
    } 
}

insertResult = (result) => {
    if(result.model.message == "성공"){
        alert('성공적으로 회원가입이 완료되었습니다.');
        location.href = 'main.me';
    } else if(result.model.message == "안돼"){
        alert('이미 있는 아이디입니다.');
    } else {
        alert('회원가입 실패');
        location.href = 'error.me';
    }
}

passwordCheck = () => {
    const inputPwd = document.querySelector("#inputPass").value;
    const checkInputPwd = document.querySelector("#inputCheckPass").value;

    let reg = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,15}$/;

    if (!reg.test(inputPwd)) {
        return "fail1";
    }

    if (inputPwd !== checkInputPwd) {
        return "fail12";
    }

    return "ok";
}