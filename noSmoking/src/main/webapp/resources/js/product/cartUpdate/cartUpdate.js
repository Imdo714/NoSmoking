var count = 1;

productPlus2 = (price) => {
    count = count + 1;
    document.querySelector("#number-count").value = count;

    sum = document.querySelector("#number-count").value; // 카운터

    sumPlus = price * sum;
    document.querySelector("#price-count").value = sumPlus;
}

productMin2 = (price) => {
    count = count - 1;
    document.querySelector("#number-count").value = count;

    plus = document.querySelector("#price-count").value;

    result = plus - price;

    document.querySelector("#price-count").value = result;
}

cartUpdateCount = (productNo) => {
    count = document.querySelector("#number-count").value;

    data = {
        count : count,
        productNo : productNo
    }

    cartUpdateAjaxController.cartUpdateCount(data,cartUpResult);
}

cartUpResult = (result2) => {
    console.log(result2);

    if(result2.model.message == "성공"){
        alert('주문 변경이 완료되었습니다:D');
        location.href='shopeCart.pr';
    } 
    if(result2.model.message == "실패") {
        alert('주문 변경 실패');
        location.href='shopeCart.pr';
    }
}