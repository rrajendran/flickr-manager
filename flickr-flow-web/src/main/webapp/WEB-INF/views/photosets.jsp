<%@ page session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="includes.jsp"%>
<script src="<c:url value="/static/scripts/photosets.js" />"></script>
</head>
<body>
	<%@ include file="menu.jsp"%>
	<div id="wrapper">
		<%@ include file="pagination.jsp"%>

		<div style="float: right; width: 150px">
			<div style="float: left;">
				<img src="${person.buddyIcon}" />
			</div>
			<div style="float: right;">
				<b>${title}</b> <i>${person.location._content}</i>
			</div>
		</div>
		<div id="photosets" class="photosets">
			<c:forEach items="${photosetsmodel.photosets.photoset }"
				var="photoset" varStatus="status">
				<div class="photoset-wrap">
					<div id="photo-border_${photoset.id}" class="photo-border">
						<a href="<c:url value="/photosets/sets/${photoset.id}" />"> <img id="${photoset.id}"
							src="<c:out value="${photoset.imageUrl}" />" />
						</a>
					</div>
					<div id="set-info-${photoset.id}" class="photosetInfo" style="display:none;position:absolute">
						<div
							style="word-wrap: break-word; clear: right; clear: left; font-weight: bold; font-size: 12px;margin:10px">${photoset.title._content}</div>
						<div style="clear: right; clear: left; margin:10px">${photoset.photos} photos</div>
						<div style="clear: right; clear: left; margin:10px">${photoset.description._content}</div>
						<div style="clear: right; clear: left; margin:10px">Total ${photoset.count_views} views</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>