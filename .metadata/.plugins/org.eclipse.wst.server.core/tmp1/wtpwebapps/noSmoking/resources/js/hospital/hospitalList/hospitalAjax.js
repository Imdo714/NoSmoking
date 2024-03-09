const hospitalAjaxController = {
    search : (data, callback) =>{
        $.ajax({
            url: "search.ho",
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

    searchCity : (data, callback) =>{
        $.ajax({
            url: "searchCity.ho",
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

    searchAddres : (data, callback) =>{
        $.ajax({
            url: "searchAddres.ho",
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

    searchPhone : (data, callback) =>{
        $.ajax({
            url: "searchPhone.ho",
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