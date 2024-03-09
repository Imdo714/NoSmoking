const memberAjaxController = {
    logout : (data, callback) =>{
        $.ajax({
            url: "",
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

    insertM : (data, callback) =>{
        $.ajax({
            url: "insert.me",
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