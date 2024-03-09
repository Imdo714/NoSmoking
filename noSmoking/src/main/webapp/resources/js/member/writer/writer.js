application = () => {
    const checkbox = document.querySelector('#checkbox');

    if(!checkbox.checked){
        alert("서비스 이용 약관, 개인정보 처리 동의를 해주세요")
    } else {
        

        writerAjaxController.upWriter(suResult);
    }
}

suResult = (result) => {
    //console.log(result);

    if(result.model.message == "성공"){
        alert('금연신청을 축하드립니다.');
        location.href = 'main.me';
    } else {
        alert('이미 금연 중입니다.');
        location.href = 'writer.me';
    }
}

clance = () => {
    alert('로그인 이후 사용이 가능합니다');
}