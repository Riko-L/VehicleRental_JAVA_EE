$(function() {
    function datepicked() {
        var fromDate = $('#dateStart').datepicker('getDate');
        var toDate = $('#dateEnd').datepicker('getDate');
        if (fromDate && toDate) {
            var difference_msec = toDate.getTime() - fromDate.getTime();
            var difference_days = difference_msec / 86400000;
            $("#dayNumber").val(Math.ceil(difference_days));
        }
    }
    $('#dateStart').datepicker({
        numberOfMonths: 2,
        firstDay: 1,
        dateFormat: 'dd-mm-yy',
        minDate: '0',
        maxDate: '+2Y',
        onSelect: function(dateStr) {
            var d1 = $(this).datepicker("getDate");
            d1.setDate(d1.getDate() + 0); // change to + 1 if necessary
            var d2 = $(this).datepicker("getDate");
            d2.setDate(d2.getDate() + 30); // change to + 29 if necessary
            $("#dateEnd").datepicker("setDate", null);
            $("#dateEnd").datepicker("option", "minDate", d1);
            $("#dateEnd").datepicker("option", "maxDate", d2);
            datepicked();
        }
    });
    $('#dateEnd').datepicker({
        numberOfMonths: 2,
        firstDay: 1,
        dateFormat: 'dd-mm-yy',
        minDate: '0',
        maxDate: '+2Y',
        onSelect: function(dateStr) {
            datepicked();
        }
    });
});