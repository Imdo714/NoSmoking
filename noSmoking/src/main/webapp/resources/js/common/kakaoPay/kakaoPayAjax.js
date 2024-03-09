const kakaoAjaxController = {
    kakaoMoney : (data, callback) =>{
        $.ajax({
            url: "kakao.pr",
            type: "post",
            data,
            success: (result) => {
                callback(result)
            },
            error: (err) => {
                console.log(err)
            }
        })
    },

    kakaoTeamMoney : (realData, sum, callback) =>{
        $.ajax({
            url: "teamKakao.pr",
            type: "post",
            data : {
                realData,
                sum,
            },
            success: (result2) => {
                callback(result2)
            },
            error: (err) => {
                console.log(err)
            }
        })
    },


}