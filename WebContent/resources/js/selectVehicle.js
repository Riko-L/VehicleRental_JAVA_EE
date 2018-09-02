function getCarsInfos(id) {
	$.ajax({
		url : "./carsajax",
		data : {
			action : "getCarsInfos",
			id : id
		}
	}).done(function(data) {
		if (data != undefined && data.car != undefined && data.rentalPrice != undefined) {
			console.log("RentalPrice : " + data.rentalPrice);
			$("#rentalPriceShow").text(data.rentalPrice);
			$("#rentalPrice").val(data.rentalPrice);
		} else {
			console.log("No Data Found");
		}
	});
}


$(function() {

	$("#carTable > tbody > tr").on("mouseenter mouseleave", function(event) {

		if (event.type === 'mouseenter') {
			$(this).addClass('hoverColor');
			$(this).css("cursor", "pointer");

		} else if (event.type === 'mouseleave') {
			$(this).removeClass('hoverColor');
			$(this).css("cursor", "default");
		}

	});

	
	$("#carTable > tbody > tr").on("click", function() {
		var id = $(this).find('input[name=choiceCheck]').data('id');
		$(this).parent().find('tr').removeClass('selectColor');
		$(this).find('input[name=choiceCheck]').prop("checked", true);
		$(this).addClass('selectColor');
		getCarsInfos(id);

	});
});


$( document ).ready(function() {
	
		if( document.getElementById("carTable")){
		var id = $("#carTable > tbody > tr").first().find('input[name=choiceCheck]').data('id');
		getCarsInfos(id);
		}
		if(document.getElementById("notFoundTableRow")){
			$("#rentalPriceShow").parent().parent().remove();
		}
	
});
