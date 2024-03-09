const cartUpdateAjaxController = {
    cartUpdateCount : (data, callback) =>{
        $.ajax({
            url: "cartUpdateCount.pr",
            type: "post",
            data,
            success: (result2) => {
                callback(result2)
            },
            error: (err) => {
                console.log(err)
            }
        })
    },

}