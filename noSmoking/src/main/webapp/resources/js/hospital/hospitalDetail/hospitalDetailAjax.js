const ReplyAjaxController = {
    reply : (data, callback) =>{
        $.ajax({
            url: "hospitalReply.ho",
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

    replyload : (data, callback) =>{
        $.ajax({
            url: "hospitalReplyLoad.ho",
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

    replyDelete : (data, callback) =>{
        $.ajax({
            url: "replyDelete.ho",
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

    replyUpdate : (data, callback) =>{
        $.ajax({
            url: "replyUpdate.ho",
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
}
