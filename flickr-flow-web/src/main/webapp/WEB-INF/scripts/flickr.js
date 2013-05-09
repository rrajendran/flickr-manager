$(document).ready(function(){
	$.ajax({
		url: "http://www.flickr.com/services/rest/?api_key=7fe95ac49ce9fc0757bc1937d14fc3e4&nojsoncallback=1&method=flickr.interestingness.getList&format=json&",
		type: "GET",
		dataType: "json",
		success : function(msg){
			$.each(msg.photos.photo,function(){
				var imgSize = "_b";
				var fullImageSize = "_q";
				var suffix = ".jpg";
				var flickrUrl = "http://farm" + this.farm + ".staticflickr.com/" + this.server 
				+"/" + this.id +"_" + this.secret;
				var imgLink = "<a  title='" + this.title +"' href='exif?id=" + this.id +"'>" +
				"<img id='" + this.id +"' src='" + flickrUrl + fullImageSize + suffix  + "'/>" +
				"</a>";
				
				$("#flickr").append(imgLink);
			});
		}
	});
	

});