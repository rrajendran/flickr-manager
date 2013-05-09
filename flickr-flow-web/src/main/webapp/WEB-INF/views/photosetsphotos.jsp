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
		<%@ include file="pagination.jsp"%>
		<%@ include file="lightbox.jsp"%>

		<div style="float: right; width: 150px">
			<div style="float: left;">
				<img src="${person.buddyIcon}" />
			</div>
			<div style="float: right;">
				<b>${title}</b>
				<i>${person.location._content}</i>
			</div>
		</div>
		<div id="flickrGallery">
			
			<c:forEach items="${photosetmodel.photoset.photo}" var="photo"
				varStatus="status">
				<input type="hidden" id="lightboxUrl-${photo.id}"
						value="<c:url value="http://farm${photo.farm}.staticflickr.com/${photo.server}/${photo.id}_${photo.secret}_b.jpg" />" />
					<input type="hidden" id="viewUrl-${photo.id}"
						value="<c:url value="/view?id=${photo.id}" />" />
					<a title="${photo.title}" class="lightbox" id="${photo.id}"
					href="/view?id=${photo.id}"> <img title="${photo.title}"
					src="<c:out value="http://farm${photo.farm}.staticflickr.com/${photo.server}/${photo.id}_${photo.secret}_q.jpg" />" />
				</a>
			</c:forEach>
		</div>
	</div>
</body>
</html>