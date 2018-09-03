function getCarsInfos(id) {
	$.ajax({
		url : "./carsajax",
		data : {
			action : "getCarsInfos",
			id : id
		}
	}).done(function(data) {
		if (data != undefined && data.car != undefined && data.rentalPrice != undefined) {
			$("#rentalPriceShow").text(data.rentalPrice);
			$("#rentalPrice").val(data.rentalPrice);
		} else {
			console.log("No Data Found");
		}
	});
}

function getUtilityCarsInfos(id) {
	$.ajax({
		url : "./utilitycarssajax",
		data : {
			action : "getUtilityCarsInfos",
			id : id
		}
	}).done(function(data) {
		if (data != undefined && data.car != undefined && data.rentalPrice != undefined) {
			$("#rentalPriceShow").text(data.rentalPrice);
			$("#rentalPrice").val(data.rentalPrice);
		} else {
			console.log("No Data Found");
		}
	});
}

function getMotorBikesInfos(id) {
	$.ajax({
		url : "./motorbikesajax",
		data : {
			action : "getMotorBikesInfos",
			id : id
		}
	}).done(function(data) {
		if (data != undefined && data.car != undefined && data.rentalPrice != undefined) {
			$("#rentalPriceShow").text(data.rentalPrice);
			$("#rentalPrice").val(data.rentalPrice);
		} else {
			console.log("No Data Found");
		}
	});
}



$(function() {
	if (document.getElementsByName("choiceCheck") != undefined && document.getElementsByName("choiceCheck").length != 0) {
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

	}
});


$(document).ready(function() {

	if (document.getElementsByName("choiceCheck") != undefined && document.getElementsByName("choiceCheck").length != 0) {

		if (document.getElementById("carTable") != undefined && document.getElementById("carTable").length != 0) {
			var $firstElement = $("#carTable > tbody > tr").first();
			var id = $firstElement.find('input[name=choiceCheck]').data('id');
			$firstElement.addClass('selectColor');
			getCarsInfos(id);
		} else if (document.getElementById("utilityCarTable") != undefined && document.getElementById("utilityCarTable").length != 0) {
			var $firstElement = $("#utilityCarTable > tbody > tr").first();
			var id = $firstElement.find('input[name=choiceCheck]').data('id');
			$firstElement.addClass('selectColor');
			getUtilityCarsInfos(id);

		} else if (document.getElementById("motorBikeTable") != undefined && document.getElementById("motorBikeTable").length != 0) {
		
		var $firstElement = $("#motorBikeTable > tbody > tr").first();
		var id = $firstElement.find('input[name=choiceCheck]').data('id');
		$firstElement.addClass('selectColor');
		getMotorBikesInfos(id);
		}
	}


	if (document.getElementById("notFoundTableRow")) {
		$("#rentalPriceShow").parent().parent().remove();
		$(":submit").prop("disabled", true);
		$(":submit").removeClass("btn-primary");
		$(":submit").addClass("btn-secondary");
		$("#returnBTN").removeClass("btn-secondary");
		$("#returnBTN").addClass("btn-primary");

	}

});