$(function() {

var startDate = new Date();
var year = startDate.getFullYear();
var mount = startDate.getMonth();
var day = startDate.getDay();

startDate =  new Date(year-18, mount, day);

$('#birthdate').datepicker({
		numberOfMonths : 1,
		changeMonth: true,
        changeYear: true,
        showButtonPanel: true,
        defaultDate: startDate,
		firstDay : 1,
		dateFormat : 'dd-mm-yy',
		
	});

$('#licensedate').datepicker({
	numberOfMonths : 1,
	maxDate: '0',
	changeMonth: true,
    changeYear: true,
    showButtonPanel: true,
	firstDay : 1,
	dateFormat : 'dd-mm-yy',
	onSelect : function(dateStr) {
		datepicker();
	}
});

});