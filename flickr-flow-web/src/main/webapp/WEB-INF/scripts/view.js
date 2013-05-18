$(document).ready(
		function() {
			var pageNumber = 1;
			$(".home").bind("click",function(){
				window.location = "/explore" ;
			});
			console.log(($("#flickrImage")));
			$("#navBar").css({
				"left": $("img").width()
			}).show();
			$("#addComment").click(function() {

				var comment = $("#userComment").val();
				var photoId = $("#photoId").val();
				var commentUrl = "/addComments/" + photoId
						+ "/" + encodeURIComponent(comment);
				alert(commentUrl);
				if (comment != "") {
					$.ajax({
						url : commentUrl,
						type : "GET",
						dataType : "json",
						success : function(msg) {
							alert(msg.comment.id);
						}
					});
				}
				$(this).dialog("close");
			
			});

			$(".editComment").click(function() {
				var commentId = $(this).attr("href").substring(1);
				alert(commentId);
				var c = $("#comment-content-" + commentId).html();
				console.log(c);
				$("#userComment").val(c);
				$("#dialog-form").dialog("open");
			});

			$(".deleteComment").click(function() {
				var commentId = $(this).attr("href").substring(1);
				var commentUrl = "/deleteComments/" + commentId;
				$.ajax({
					url : commentUrl,
					type : "GET",
					dataType : "json",
					success : function(msg) {
						var response = msg.stat;
						if (response != "ok") {
							alert("Error adding comments.. Try again");
						} else {
							alert("removing");
							$("$comment_" + commentId).remove();
						}
					}
				});
			});

			$(".favourite").click(
					function() {
						var photoId = $(this).attr("name");
						var id = $(this).attr("id");
						console.log("id :" + id);
						var favUrl = "/view/addToFavourite/" + photoId;
						if (id == "removeFavourites")
							favUrl = "/view/removeFromFavourite/" + photoId;
						var backgroundColor = {
							"background-color" : id == "addFavourites" ? "red"
									: "gray"
						};
						console.log(backgroundColor);

						console.log(favUrl);
						$.ajax({
							url : favUrl,
							type : "GET",
							dataType : "json",
							success : function(msg) {
								console.log("response : " + msg)
								if (msg && id == "addFavourites") {
									console.log("add to favourties")
									$(".favourite, .favourite span").css(
											backgroundColor).attr("id",
											"removeFavourites");
									$(".favourite  span").text(
											"Remove from favourites");
								} else if (msg && id == "removeFavourites") {
									console.log("removed from favourties");
									$(".favourite, .favourite span").css(
											backgroundColor).attr("id",
											"addFavourites");
									$(".favourite  span").text(
											"Add to favourites");
								}
							}
						});
					});

			var uniqueID = (function() {
				var id = 1; // This is the private persistent value
				// The outer function returns a nested function that has access
				// to the persistent value. It is this nested function we're
				// storing
				// in the variable uniqueID above.
				return function() {
					if(id <=500)
						return id++;
					else{
						id = 1;
						return id;
					}
				}; // Return and increment
			})();

			$("img").bind(
					"click",
					function() {
						console.log("unique number" + uniqueID);
						$.ajax({
							type : "GET",
							url : "http://ycpi-api.flickr.com/services/rest/",
							data : {
								method : "flickr.interestingness.getList",
								api_key : "8a13dee6ee18863a0112f99206b78b69",
								format : "json",
								per_page : "1",
								page : uniqueID,
								nojsoncallback : "1",
								per_page : 1
							},
							success : function(response) {
								var photo = response.photos.photo[0];
								console.log("photo = " + photo);
								var imageUrl = "http://farm" + photo.farm
										+ ".staticflickr.com/" + photo.server
										+ "/" + photo.id + "_" + photo.secret;

								var largeImage = imageUrl + "_b.jpg";
								console.log("Image url : " + largeImage);
								$("img").attr("src", largeImage);
							}
						});
					});
		});