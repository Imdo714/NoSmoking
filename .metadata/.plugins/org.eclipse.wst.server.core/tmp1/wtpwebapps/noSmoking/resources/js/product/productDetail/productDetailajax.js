const productDetailAjaxController = {
    cart : (data, callback) =>{
        $.ajax({
            url: "cart.pr",
            type: "post",
            data,
            success: (resultFo) => {
                callback(resultFo)
            },
            error: (err) => {
                console.log(err)
            }
        })
    },

}