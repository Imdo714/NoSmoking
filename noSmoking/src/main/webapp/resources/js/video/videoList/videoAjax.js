const videoAjaxController = {
    updateVideo : (data, callback) =>{
        $.ajax({
            url: "videoUp.vi",
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

    selectVideoList : (callback) =>{
        $.ajax({
            url: "videoAllList.vi",
            type: "post",
            success: (result) => {
                callback(result)
            },
            error: (err) => {
                console.log(err)
            }
        })
    },


}