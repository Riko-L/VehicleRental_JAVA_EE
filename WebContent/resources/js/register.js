$(function() {

$('#birthdate').datepicker({
		numberOfMonths : 1,
		firstDay : 1,
		dateFormat : 'dd-mm-yy',
		onSelect : function(dateStr) {
			datepicked();
		}
	});

$('#licensedate').datepicker({
	numberOfMonths : 1,
	firstDay : 1,
	dateFormat : 'dd-mm-yy',
	onSelect : function(dateStr) {
		datepicked();
	}
});

});