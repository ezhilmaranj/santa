$(function() {
	$(".tray").dblclick(function() {
		$("#fields").append($(this));
		$(this).remove();
	});
});


function report(){
	alert($("tbody").html());
	alert("Hai...");
}

function validateMandateField(mandateField){
	var val = $("#"+mandateField+"").val();
	alert(val);
	return false;
}