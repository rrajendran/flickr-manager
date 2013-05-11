<%@ page session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="includes.jsp"%>
<script src="<c:url value="/static/scripts/explore.js" />"></script>
</head>
<body>
	<%@ include file="menu.jsp"%>
	<section>
	<div id="wrapper">
		<div style="float: left; clear: left">
			<span class="title">${title}</span><input size="10" type="text" id="datepicker" value="${date}" />
		</div>
		<div class="menu" id="pageNav" style="float: left">
			<c:if test="${prevPage != 0}">
				<input title="Previous" type="radio" id="prev" name="radio">
				<label for="prev"> <a
					href="<c:url value="/explore/${date}/${prevPage}/${perPage}"/>">Prev</a>
				</label>
			</c:if>
			<c:if test="${nextPage != null}">
				<input title="Next" type="radio" id="next" name="radio"
					checked="checked">
				<label for="next"> <a
					href="<c:url value="/explore/${date}/${nextPage}/${perPage}"/>">Next</a>
				</label>
			</c:if>
		</div>
		<%@ include file="lightbox.jsp"%>
	</div>
	</section>
	<section>
	<div id="flickrGallery">
		<c:forEach items="${photos.photos.photo}" var="photo"
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
	</section>

</body>
</html>