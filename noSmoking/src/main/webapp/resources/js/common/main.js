var slideIndex = 0;

function showSlides() {
    var i;
    var slides = document.getElementsByClassName("mySlides");
   
    for (i = 0; i < slides.length; i++) {
        slides[i].style.display = "none";
    }
    slideIndex++;
    if (slideIndex > slides.length) {
        slideIndex = 1
    }
    slides[slideIndex - 1].style.display = "block";

    setTimeout(showSlides, 2000); // 2초마다 이미지가 체인지
}

// 페이지 로드 시 슬라이드쇼 시작
document.addEventListener("DOMContentLoaded", function () {
    showSlides();
});


productRefesh = () => {

    minAjaxController.productRefesh(productList);
}

productList = (result) => {
    console.log(result);
    console.log(result.model.list);
    console.log(result.model.pi);
    console.log(result.model.firstImage);


    let str1 = "";
    for (let p of result.model.firstImage) {
        str1 += `<a onclick="location.href='productDetailView.pr?pNo=${p.productNo}'">`
                + `<img src="${p.productChangName}" alt="" class="img-1">`
                + `</a>`
                
    }
    document.querySelector("#smoke").innerHTML = str1;     

    let str2 = "";
    for (let r of result.model.list) {
        str2 += `<a onclick="location.href='productDetailView.pr?pNo=${r.productNo}'">`
                + `<h2 class="text-pom22">${r.productName}</h2>`
                + `</a>`
    }
    document.querySelector("#title-text").innerHTML = str2;

}


noSmoking = () => {
    minAjaxController.noSmokingCount(countSuc);
}

countSuc = (result) => {
    console.log(result);

    let str = "";
    
    str += `<div class="challenge-title">올해 금연 도전자</div>`
            +`<div class="challenge-title">`+ result.model.co +`</div>`
                
    
    document.querySelector("#smoking").innerHTML = str;     
}