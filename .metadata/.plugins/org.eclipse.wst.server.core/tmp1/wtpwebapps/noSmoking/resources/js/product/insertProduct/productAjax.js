const productAjaxController = {
    productList : (callback) =>{
        $.ajax({
            url: "productList1.pr",
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