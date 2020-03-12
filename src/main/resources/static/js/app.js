var rest = apiclient;
var app = (function () {
    var save = function (name, tdoc, ndocument, email, phone) {
        var person = {
            name: name,
            tdoc: tdoc,
            ndocument: ndocument,
            email: email,
            phone: phone
        };
        rest.getPersonas()
    };
    return {
        save:save
    };
})();