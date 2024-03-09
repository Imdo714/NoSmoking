const writerAjaxController = {
    upWriter : (callback) =>{
        $.ajax({
            url: "writerInsert.me",
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