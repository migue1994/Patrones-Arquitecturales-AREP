var apiclient = (function () {
	var appUrl = 'http://ec2-3-88-130-241.compute-1.amazonaws.com:8080/personas';
	return {
		postPersona: function (persona){
			var postRequest=$.ajax({
				url:  appUrl,
				type: 'POST',
				data: persona,
				contentType: "application/json"
			});
			postRequest.then(
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