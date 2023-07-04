function eliminar(id) {
	swal({
		title: "¿Estás seguro de elminar?",
		text: "Una vez eliminado, ¡No podrás recuperar lo hecho!",
		icon: "warning",
		buttons: true,
		dangerMode: true,
	})
		.then((OK) => {
			if (OK) {
				$.ajax({
					url: "/eliminar/"+id,
					success: function(res) {
						console.log(res);
					}
				});
				swal("Poof! Los datos han sido eliminados", {
					icon: "success",
				}).then((ok)=>{
					if(ok){
						location.href="/listar";
					}
				});
			} else {
				swal("Está a salvo, no se ha eliminado");
			}
		});
}