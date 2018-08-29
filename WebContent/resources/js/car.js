function buildLines(cars){
	$tbody = $('#carTable tbody');
	$tbody.empty();
	for(var count=0;count<cars.length;count++){
		var car=cars[count];
		$tr=$('<tr>');
		$plateNumber=$('<td>');
		$brand=$('<td>');
		$model=$('<td>');
		$horsePower=$('<td>');
		$color=$('<td>');
		$reservationPrice=$('<td>');
		$kilometerPrice=$('<td>');
		
		$plateNumber.html(car.plateNumber);
		$brand.html(car.brand);
		$model.html(car.model);
		$horsePower.html(car.horsePower);
		$color.html(car.color);
		$reservationPrice.html(car.reservationPrice);
		$kilometerPrice.html(car.kilometerPrice);
		
		$tr.append($plateNumber);
		$tr.append($brand);
		$tr.append($model);
		$tr.append($horsePower);
		$tr.append($color);
		$tr.append($reservationPrice);
		$tr.append($kilometerPrice);
		$tbody.append($tr);
	}
}

function buildEmptyLine(){
	$tbody = $('#carTable tbody');
	$tbody.empty();
	$tbody.append($("<tr><th colspan='100%'>No data found</th></tr>"))
}



$( document ).ready(function() {
	$.ajax({
		url:"../CarServlet",
		data:{
			 action:"getCars"
		 }
	})
	.done(function(data) {
		if(data!=undefined && data.cars!=undefined && data.cars.length>0 ){
			buildLines(data.cars);
		}
		else{
			buildEmptyLine();
		}
  })
})