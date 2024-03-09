const cartAjaxController = {
    deleteCart : (realData, callback) =>{
        $.ajax({
            url: "cartDelete.pr",
            type: "post",
            data : {
                realData
            },
            success: (result) => {
                callback(result)
            },
            error: (err) => {
                console.log(err)
            }
        })
    },


}