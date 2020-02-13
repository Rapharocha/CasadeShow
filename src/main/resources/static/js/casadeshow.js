$('#confirmacaoExclusaoModal').on('show.bs.modal', function(event){
	var button = $(event.relatedTarget);
	
	var codigoCadastro = button.data('codigo');
	
	var modal = $(this);
	var form = modal.find('form');
	var action = form.data("url-base");
	if(!action.endsWith('/')) {
		action+='/';
	}
	form.attr('action', action+codigoCadastro)
	
	
});
//
//
//$(document).ready(function(){
//  $("#enviarevento").submit(function(){
//	  
//	  var form = new FormData(this);
//	  
////	  var formData1 = JSON.parse($("#enviarevento").serializeArray());
//	  var formData2 = JSON.stringify(jQuery('#enviarevento').serializeArray()); // store json string
//	  var formData3 = JSON.parse(JSON.stringify(jQuery('#enviarevento').serializeArray()))
//			  
////	  console.log(formData1);
//	  console.log(formData2);
//	  console.log(formData3);
//	  
//	  $.ajax({
//	        url : "/eventos",
//	        type: "POST",
//	        data : form,
//			contentType: false,
//			cache: false,
//			processData:false
//	    }).done(function(response){ //
//	    	console.log(response)
//	        $("#server-results").html(response);
//	    });
//    alert(form);
//  });
//});