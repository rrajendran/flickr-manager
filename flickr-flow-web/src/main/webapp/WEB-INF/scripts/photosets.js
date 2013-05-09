$(document).ready(function() {
	$(".photo-border").find("img").hover(function(event){
		$("#set-info-" +$(this).attr("id")).css({
			top : event.pageY,
			left: event.pageX
		}).toggle();
	});
});