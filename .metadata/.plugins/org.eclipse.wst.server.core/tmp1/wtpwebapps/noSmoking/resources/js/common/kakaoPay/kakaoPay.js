soloOrder = (productNo) => {
    console.log(productNo);
    const price = document.getElementById(`price${productNo}`).value;
    
    console.log(price)

    data = {
        productNo : productNo,
        price : price,
    }

    console.log(data);

    kakaoAjaxController.kakaoMoney(data,drawKaKaoPay);
}

detailOrder = (productNo, productPrice, productName) => {

    if (confirm(`${productName}` + "을 구매하시겠습니까??") == true){ 
        console.log(productNo);
    
        console.log(productPrice)

        data = {
            productNo : productNo,
            price : productPrice,
        }

        console.log(data);

        kakaoAjaxController.kakaoMoney(data,drawKaKaoPay);
    }else{   //취소

        return false;
    }

    
}

drawKaKaoPay = (result) => {
    console.log(result);

    var box = result.next_redirect_pc_url;
    // window.open(box);
    location.href = box;
}


teamOrder = () => {
    const oder = document.querySelectorAll('[id^="myCheckbox"]');
    // const price = document.getElementById(`price${productNo}`).value;
    let data = [];

    oder.forEach((checkbox) => {
        if (checkbox.checked) {
            const productId = checkbox.value;
            data.push(productId);
        }
    });

    console.log(data)

    let sum = 0;

    for (let i = 0; i < data.length; i++) {
        const productId = data[i];
        // const price = document.getElementById(`price${productId}`).value;
        const price = parseFloat(document.getElementById(`price${productId}`).value);
        console.log('금액' + price);
        if (!isNaN(price)) {
            sum += price;
        }
    }
    console.log('총 합계: ' + sum);

    if(data.length === 0){
        alert('구매하실 상품을 선택하십시오');
        location.href = 'shopeCart.pr';
    } else {
        const realData=  JSON.stringify(data)
       
        kakaoAjaxController.kakaoTeamMoney(realData, sum, oderKaKaoPay);
    }

    
    
}


oderKaKaoPay = (result2) => {
    console.log('결과' + result2);

    const box2 = result2.next_redirect_pc_url;
    location.href = box2;
}