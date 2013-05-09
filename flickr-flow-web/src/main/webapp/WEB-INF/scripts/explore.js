$(document).ready(function() {
	$("#datepicker").datepicker({
		minDate : "-10Y",
		maxDate : "-1D",
		dateFormat: "yy-mm-dd",
		onSelect: function(dateText, inst){
			window.location.href = "/explore/" + dateText;
		}
	});
});