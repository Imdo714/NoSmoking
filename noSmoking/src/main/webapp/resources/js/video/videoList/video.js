videoUpdate = () => {
    const videoAddress = document.getElementById("link").value;
    
    const title = document.getElementById("videoText").value;
    
    data = {
        title : title,
        videoAddress : videoAddress,
    }
    console.log(data);
    videoAjaxController.updateVideo(data, superResult);
}

superResult = (result) => {
    console.log(result);
    
    if(result.model.message == "성공"){
        alert('자료실 업로드 완료');
        location.href = 'video.vi';
    } else {
        alert('실패!');
        location.href = 'video.vi';
    }
}

videoList = () => {
    videoAjaxController.selectVideoList(resultList);
}

resultList = (result) => {
    let list = result.model.list;
    let list2 = result.model.pi;

    let str = "";
    for (let te of list) {
        str += `<tr onclick="location.href='detailVideo.vi?vNo=`+ te.videoNo +`'">`
                +`<td class="center">` + te.videoNo +`</td>`
                +`<td class="left">` + te.videoContent + `</td>`
                +`<td class="center">` + te.userNo + `</td>`
            +`</tr>`;
    }
    document.querySelector("#table-video").innerHTML = str;

}
