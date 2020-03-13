var apiclient = (function () {
	var appUrl = 'http://localhost:8080/personas';
	return {
		postPersona: function (persona){
			var putRequest=$.ajax({
				url:  appUrl,
				type: 'POST',
				data: persona,
				contentType: "application/json"
			});
			putRequest.then(
				function(){
					console.info(("OK"));
					alert("Se ha completado el registro satisfactoriamente");
				},
				function(){
					console.info("ERROR ON post persona");
					alert("No fue posible realizar el registro");
				}
			);
		},
	};
})();