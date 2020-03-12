var apiclient = (function () {
    var appUrl = 'http://localhost:8080/personas/';
    return {
        getPersonas : function (callback) {
            jQuery.ajax({
                url: appUrl,
                success: function (result) {
                    callback(result);
                },
                async: true
            });
        },

        postPersona: function (persona){
            var putRequest=$.ajax({
                url:  "/personas",
                type: 'PUT',
                data: persona,
                contentType: "application/json"
            });

            putRequest.then(
                function(){
                    app.update(author);
                    if(name){
                        app.getPlan(name, author);
                    }
                },

                function(){
                    console.info("ERROR ON setBluePrint")
                }

            );
        },
    };
})();