$(document).ready(function() {

	$("#dialog-form").dialog({
		resizable : false,
		 autoOpen: false,
		height : 300,
		width : 350,
		modal : true,
		buttons : {
			"Comment" : function(form) {
				var comment = $("#userComment").val();
				var photoId = $("#photoId").val();
				var commentUrl = "/addComments/" + photoId + "/" + comment;
				alert(commentUrl);
				if(comment != ""){
					$.ajax({
						url: commentUrl,
						type: "GET",
						dataType: "json",
						success : function(msg){
							alert(msg.comment.id);
						}
					});
				}
				$(this).dialog("close");
			},
			Cancel : function() {
				$(this).dialog("close");
			}
		}
	});

	$("#addComment").click(function() {
		$("#dialog-form").dialog("open");
	});
	
	$(".editComment").click(function(){
		var commentId = $(this).attr("href").substring(1);
		alert(commentId);
		var c = $("#comment-content-" + commentId).html();
		console.log(c);
		$("#userComment").val(c);
		$("#dialog-form").dialog("open");
	});
	
	$(".deleteComment").click(function(){
		var commentId = $(this).attr("href").substring(1);
		var commentUrl = "/deleteComments/" + commentId;
		$.ajax({
			url: commentUrl,
			type: "GET",
			dataType: "json",
			success : function(msg){
				var response = msg.stat;
				if(response != "ok"){
					alert("Error adding comments.. Try again");
				}else{
					alert("removing");
					$("$comment_" + commentId).remove();
				}
			}
		});
	});
	
	$(".favourite").click(function(){
		var photoId = $(this).attr("name");
		var id = $(this).attr("id");
		console.log("id :" + id);
		var favUrl = "/view/addToFavourite/" + photoId;
		if(id == "removeFavourites")
			favUrl = "/view/removeFromFavourite/" + photoId;
		var backgroundColor = {"background-color": id=="addFavourites"? "red" : "gray"};
		console.log(backgroundColor);
		
		console.log(favUrl);
		$.ajax({
			url: favUrl,
			type: "GET",
			dataType: "json",
			success : function(msg){
				console.log("response : " +  msg)
				if(msg && id == "addFavourites"){
					console.log("add to favourties")
					$(".favourite, .favourite span").css(backgroundColor).attr("id","removeFavourites");
					$(".favourite  span").text("Remove from favourites");
				}else if(msg && id== "removeFavourites"){
					console.log("removed from favourties");
					$(".favourite, .favourite span").css(backgroundColor).attr("id","addFavourites");
					$(".favourite  span").text("Add to favourites");
				}
			}
		});
	});
});