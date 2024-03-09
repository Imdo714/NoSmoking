const minAjaxController = {
    productRefesh : (callback) =>{
        $.ajax({
            url: "productRefesh.pr",
            type: "post",
            success: (result) => {
                callback(result)
            },
            error: (err) => {
                console.log(err)
            }
        })
    },

    noSmokingCount : (callback) =>{
        $.ajax({
            url: "noSmokingcount.me",
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