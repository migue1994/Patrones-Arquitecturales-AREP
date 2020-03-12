var mock = apiclient;

var app = (function () {
    var save = function (nombre,tdocument, ndocument, correo, telefono) {
        var persona = {
            name:nombre,
            ndocumento:ndocument,
            tdoc : tdocument,
            email:correo,
            phone:telefono
        }
        mock.postPersona(JSON.stringify(persona));
        cleanInputs();

    };

    var cleanInputs = function () {
        $("#nombre").val("");
        $("#email").val("");
        $("#tdoc").val("");
        $("#ndoc").val("");
        $("#phone").val("");
    }

    return {
        save: save
    };

})();