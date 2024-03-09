let checkedValue = "";

checkOne = (element) => {
    const checkboxes = document.getElementsByName("hospital");
    const checkboxValue = element.value;

    checkboxes.forEach((cb) => {
        cb.checked = false;
    });

    element.checked = true;

    checkedValue = checkboxValue;
    console.log(checkedValue);
}

search = () => {
    console.log(checkedValue);

    const comment = document.getElementById("search").value;
    console.log(comment);

    if(checkedValue == '기관명'){
        data = {
            comment : comment,
        }
    
        hospitalAjaxController.search(data, searchResult);
    } else if(checkedValue == '지역'){
        data = {
            comment : comment,
        }
    
        hospitalAjaxController.searchCity(data, searchResult);
    } else if(checkedValue == '주소'){
        data = {
            comment : comment,
        }
    
        hospitalAjaxController.searchAddres(data, searchResult);
    } else {
        data = {
            comment : comment,
        }
    
        hospitalAjaxController.searchPhone(data, searchResult);
    }

    let str = "";
    document.getElementById("search").value = str;
}

searchResult = (result) => {
    console.log(result);
    let list = result.model.list;

    let str = "";
    for (let te of list) {
        str += `<tr onclick="send(`+ te.hospitalNo +`)">`
                    +`<th class="inpo-th" scope="row">`+ te.hospitalName +`</th>`
                    +`<td class="inpo-td">`
                        +`<div class="table-addres">`
                            + te.hospitalCity +`</div>`
                    +`</td>`
                    +`<td class="inpo-td">`
                        +`<div class="table-addres">`+ te.hospitalAddress +`</div>`
                    +`</td>`
                    +`<td class="inpo-td">`
                        +`<div class="table-addres">`+ te.hospitalPhone+`</div>`
                    +`</td>`
                +`</tr>`;
    }
    document.querySelector("#hospitalTable").innerHTML = str;
    
}

var currentPage = 1;

send = (hospitalNo) => {
    const hNo = hospitalNo;
    console.log(hNo);

    location.href = 'hospitalDetail.ho?hNo='+hNo+'&cpage='+currentPage+'';
}