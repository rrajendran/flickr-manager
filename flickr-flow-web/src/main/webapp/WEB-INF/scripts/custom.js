$(document).ready(function() {
	$("#lightboxSet, #pageNav").buttonset();
	
	$("#lightboxOn").click(function(){
		$(".lightbox").each(function(){
			var lightBoxUrl = $("#lightboxUrl-" + $(this).attr("id")).val();
			$(this).attr("rel","lightbox[flickr]").attr("href",lightBoxUrl);
		});
	});
	
	$("#lightboxOff").click(function(){
		$(".lightbox").each(function(){
			var viewUrl = $("#viewUrl-" + $(this).attr("id")).val();
			$(this).removeAttr("rel").attr("href",viewUrl);
		});
	});
	
	
	
	$( "img[title]" ).tooltip();
	
	$("#flickrGallery").css({
		height : $(window).height(),
		width: "100%"
	});

	$("#sidebar").css({
		height : ($(window).height() - 40)
	});

	$("#tabbedMenu > ul > li").click(function(event) {
		$(".active").removeClass("active");
		$(this).addClass("active");
		var menu = $(this).attr("id");

		var left = $("#tabbedMenu").offset().left + 200;
		var top = ($("#tabbedMenu").offset().top) + 22;
		var divCss = {
			position : "absolute",
			top : top,
			left : event.pageX
		};
		if (menu == "infoMenu") {
			$("#photoLocation, #photoTags, #exifInfo").hide();
			$("#photoInfo").css(divCss).toggle();
		} else if (menu == "locationMenu") {
			$("#photoInfo, #photoTags, #exifInfo").hide();
			$("#photoLocation").css(divCss).toggle();
		} else if (menu == "tagsMenu") {
			$("#photoLocation, #photoInfo, #exifInfo").hide();
			$("#photoTags").css(divCss).toggle();
		} else if (menu == "exifMenu") {
			$("#photoLocation, #photoTags, #photoInfo").hide();
			$("#exifInfo").css(divCss).toggle();
		}
	});

});