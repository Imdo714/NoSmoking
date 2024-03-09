insertReply = (hospitalNo, userNo) => {
    const comment = document.querySelector('.Reply-input').value;

    console.log(comment);
    console.log(userNo);

    if(comment == ""){
        alert('댓글을 작성하십시오');
    }else{
        data = {
            comment : comment,
            hNo : hospitalNo,
            userNo2 : userNo,
        }
    
        ReplyAjaxController.reply(data,succ);
    
        let str = "";
        document.querySelector('.Reply-input').value = str;
    }

    
}

succ = (result) => {
    console.log(result);
    let list = result.model.list;
    let pi = result.model.pi;
    let loginUser = result.model.userNo;

    console.log(loginUser);

    let str = "";
    for (let te of list) {
        if(loginUser === te.userNo){
            str += `<tr>`
                    +`<th class="Reply-th" scope="row">`+ te.userName + `</th>`
                    +`<td class="Reply-td" id="Reply-text`+ te.replyNo +`">`
                        +`<div class="Reply-text">`
                        + te.replyContent
                        +`</div>`
                        +`<div class="Reply-text-btn">`
                            +`<button onclick="updateReply('${te.replyContent}', ${te.replyNo}, ${result.model.hNo}, ${loginUser})">수정</button>`
                            +`<button onclick="deleteReply(`+ te.replyNo +`, `+ result.model.hNo +`,`+ loginUser +`)">삭제</button>`
                        +`</div>`
                    +`</td>`
                +`</tr>`;
        } else {
            str += `<tr>`
                    +`<th class="Reply-th" scope="row">`+ te.userName + `</th>`
                    +`<td class="Reply-td" id="Reply-text`+ te.replyNo +`">`
                        +`<div class="Reply-text">`
                        + te.replyContent
                        +`</div>`
                        +`<div class="Reply-text-btn">`
                        +`</div>`
                    +`</td>`
                +`</tr>`;
        }
            
        
        
    }
    document.querySelector("#ReplyContent").innerHTML = str;

}

clance = () => {
    alert('로그인 이후 사용이 가능합니다');

    let str = "";
        document.querySelector('.Reply-input').value = str;
}

deleteReply = (replyNo, hospitalNo, userNo) => {
    console.log(replyNo);

    data = {
        replyNo : replyNo,
        hNo : hospitalNo,
        userNo2 : userNo,
    }

    ReplyAjaxController.replyDelete(data,resDelte);
}

resDelte = (result) => {
    console.log(result);

    if(result.model.message == "성공"){
        let list = result.model.list;
        let loginUser = result.model.userNo;

        let str = "";
        for (let te of list) {
            if(loginUser === te.userNo){
                str += `<tr>`
                        +`<th class="Reply-th" scope="row">`+ te.userName + `</th>`
                        +`<td class="Reply-td" id="Reply-text${te.replyNo}">`
                            +`<div class="Reply-text">`
                            + te.replyContent
                            +`</div>`
                            +`<div class="Reply-text-btn">`
                                +`<button onclick="updateReply('${te.replyContent}', ${te.replyNo}, ${result.model.hNo}, ${loginUser})">수정</button>`
                                +`<button onclick="deleteReply(`+ te.replyNo +`, `+ result.model.hNo +`,`+ loginUser +`)">삭제</button>`
                            +`</div>`
                        +`</td>`
                    +`</tr>`;
            } else {
                str += `<tr>`
                        +`<th class="Reply-th" scope="row">`+ te.userName + `</th>`
                        +`<td class="Reply-td" id="Reply-text${te.replyNo}">`
                            +`<div class="Reply-text">`
                            + te.replyContent
                            +`</div>`
                            +`<div class="Reply-text-btn">`
                            +`</div>`
                        +`</td>`
                    +`</tr>`;
            }
            
        }
        document.querySelector("#ReplyContent").innerHTML = str;
    } 
}

updateReply = (replyContent, replyNo, hNo, userNo) => {
    console.log(replyContent);

    let str = "";
    str += `<div class="Reply-Uptext">`
            + `<textarea class="updateReply">` + replyContent + `</textarea>`
            + `<div class="Reply-Uptext-btn">`
            + `<button style="margin-right: 10px;" onclick="updateSuccess(` + replyNo + `, ` + hNo + `,` + userNo + `)">확인</button>`
            + `<button onclick="deleteReply(`+ replyNo +`, `+ hNo +`,`+ userNo +`)">삭제2</button>`
            + `</div>`;

    document.querySelector(`#Reply-text${replyNo}`).innerHTML = str;
}

updateSuccess = (replyNo, hNo, userNo) => {
    const upComment = document.querySelector('.updateReply').value;
    console.log(upComment);
    console.log(replyNo);
    console.log(hNo);
    console.log(userNo);
    
    data = {
        content : upComment,
        replyNo : replyNo,
        hNo : hNo,
        userNo2 : userNo,
    }

    ReplyAjaxController.replyUpdate(data,sendUpdate);
}

sendUpdate = (result) => {
    console.log(result);
    
    let list = result.model.list;
    let loginUser = result.model.userNo;

    if(result.model.message == "성공"){
        let str = "";
        for (let te of list) {
            if(loginUser === te.userNo){
                str += `<tr>`
                        +`<th class="Reply-th" scope="row">`+ te.userName + `</th>`
                        +`<td class="Reply-td" id="Reply-text${te.replyNo}">`
                            +`<div class="Reply-text">`
                            + te.replyContent
                            +`</div>`
                            +`<div class="Reply-text-btn">`
                                +`<button onclick="updateReply('${te.replyContent}', ${te.replyNo}, ${result.model.hNo}, ${loginUser})">수정</button>`
                                +`<button onclick="deleteReply(`+ te.replyNo +`, `+ result.model.hNo +`,`+ loginUser +`)">삭제</button>`
                            +`</div>`
                        +`</td>`
                    +`</tr>`;
            } else {
                str += `<tr>`
                        +`<th class="Reply-th" scope="row">`+ te.userName + `</th>`
                        +`<td class="Reply-td" id="Reply-text${te.replyNo}">`
                            +`<div class="Reply-text">`
                            + te.replyContent
                            +`</div>`
                            +`<div class="Reply-text-btn">`
                            +`</div>`
                        +`</td>`
                    +`</tr>`;
            }
            
        }
        document.querySelector("#ReplyContent").innerHTML = str;
    }
    
}




