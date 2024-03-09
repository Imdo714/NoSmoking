var count = 1;

productPlus = (price) => {
    count = count + 1;
    document.querySelector("#number-count").value = count;

    sum = document.querySelector("#number-count").value; // 카운터

    sumPlus = price * sum;
    document.querySelector("#price-count").value = sumPlus;
}

productMin = (price) => {
    count = count - 1;
    document.querySelector("#number-count").value = count;

    plus = document.querySelector("#price-count").value;

    result = plus - price;

    document.querySelector("#price-count").value = result;
}

cart = (userNo, productNo) => {
    count = document.querySelector("#number-count").value;

    console.log(userNo)
    console.log(productNo)
    console.log(count)

    data ={
        userNo : userNo,
        productNo : productNo,
        count : count,
    }

    console.log(data)

    productDetailAjaxController.cart(data,cartResult);
}

cartResult = (resultFo) => {
    console.log(resultFo)

    if(resultFo.model.message == "성공"){
        alert('장바구니에 담았습니다.');
        location.href = 'shopeCart.pr';
    } 
    if(resultFo.model.message == "실패") {
        alert('장바구니에 상품이있습니다.');
        location.href = 'shopeCart.pr';
    }
}


clance = () => {
    alert('로그인 이후 사용이 가능합니다');
}


