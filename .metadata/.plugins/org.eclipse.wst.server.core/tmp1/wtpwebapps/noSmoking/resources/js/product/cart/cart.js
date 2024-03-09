init = () => {
    const countElements = document.querySelectorAll("#count");
    const sumPriceElements = document.querySelectorAll(".sumPrice"); 

    // console.log(countElements);
    // console.log(sumPriceElements);

    // 초기화
    let totalSum = 0;

    // 각 행에 대한 처리
    countElements.forEach((countElement, index) => {
        // 현재 행의 count 가져오기
        const cat = parseInt(countElement.value);
        // console.log(cat);

        // 현재 행의 price 가져오기
        const price = parseFloat(sumPriceElements[index].value);
        // console.log(price);

        // 현재 행의 합계 계산
        const sum = cat * price;

        // 합계를 해당 행의 sumPrice에 할당
        sumPriceElements[index].value = sum;

        // 총합에 현재 행의 합계 더하기
        totalSum += sum;
    });

    // console.log("Total Sum:", totalSum);
}

check = (productId) => {
    const checkbox = document.getElementById(`myCheckbox${productId}`);
    const checkboxValue = checkbox.value;
    console.log(checkboxValue);

    if (checkbox.checked) {
        console.log('Checkbox가 체크되었습니다.');
    } else {
        console.log('Checkbox가 체크되지 않았습니다.');
    }
}

deleteCart = () =>{
    const checkboxes = document.querySelectorAll('[id^="myCheckbox"]'); 
    //[id^="myCheckbox"]는 "myCheckbox"로 시작하는 모든 id를 선택
    // const productNos = [];
    let data = [];

    checkboxes.forEach((checkbox) => {
        if (checkbox.checked) {
            const productId = checkbox.value;
            data.push(productId);
        }
    });

    console.log("선택된 상품 번호들:", data);

    // data.push(productNos);

    const realData=  JSON.stringify(data)

    console.log(realData);
    console.log(typeof(realData) )

    cartAjaxController.deleteCart(realData,resultDel);
}

resultDel = (result) =>{
    console.log(result);

    if(result.model.message == "성공"){
        alert('선택하신 상품이 삭제되었습니다.');
        location.href = 'shopeCart.pr';
    } else {
        alert('실패!');
        location.href = 'shopeCart.pr';
    }
}