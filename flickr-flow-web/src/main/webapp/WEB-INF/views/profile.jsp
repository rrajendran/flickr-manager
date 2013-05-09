<%@ page session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="includes.jsp"%>
</head>
<body>
	<%@ include file="menu.jsp"%>
	<div id="wrapper">
		<div id="profile">
			<div id="buddyicon">
				<img src="${personModel.person.buddyIcon}" />
			</div>
			<div id="profileName">${personModel.person.realname._content}</div>
			<div id="location">${personModel.person.location._content}</div>
		</div>
		<div
			style=" margin-top: 10px; clear: left; float: left">
			<div class="photo-border" style="width: 83px; height: 72px; margin: 0px">
				<c:forEach items="${photoStream.photos.photo}" var="photo"
					varStatus="status">
					
					 <img
						width="25" height="25"
						title="Total ${photoStream.photos.total} photos in the stream"
						src="<c:out value="http://farm${photo.farm}.staticflickr.com/${photo.server}/${photo.id}_${photo.secret}_s.jpg" />" />
				</c:forEach>
				<a href="<c:url value="/getPublicPhotos?user_id=${personModel.person.id}" />">
					Photostream
				</a>
				
			</div>
		</div>

		<div
			style=" margin-top: 10px; margin-left: 10px; float: left"
			title="Total photosets ${photoSets.photosets.total}">
			<div class="photo-border" style="width: 83px; height: 72px; margin: 0px">
				<c:forEach items="${photoSets.photosets.photoset }" var="photoset"
					varStatus="status">
					<a href="<c:url value="/photosets/sets/${photoset.id}" />"> <img
						width="25" height="25" id="${photoset.id}"
						src="<c:out value="${photoset.imageUrl}" />" />
					</a>
				</c:forEach>
				<a href="<c:url value="/photosets/sets?nsid=${personModel.person.id}" />">
					Photosets
				</a>
			</div>
		</div>
		<div
			style=" margin-top: 10px; margin-left: 10px; float: left"
			title="Total galleries ${galleries.galleries.total}">
			<div class="photo-border" style="width: 83px; height: 72px; margin: 0px">
				<c:forEach items="${galleries.galleries.gallery}" var="gallery"
					varStatus="status">
					<a href="<c:url value="/viewGallery/${gallery.id}" />"> <img width="25" height="25"
							title="${photo.title}"
							src="<c:out value="http://farm${gallery.primary_photo_farm}.staticflickr.com/${gallery.primary_photo_server}/${gallery.primary_photo_id}_${gallery.primary_photo_secret}_s.jpg" />" />
						</a>
				</c:forEach>
				<a href="<c:url value="/galleries/${personModel.person.id}" />">
					Galleries
				</a>
			</div>
		</div>
	</div>
</body>
</html>