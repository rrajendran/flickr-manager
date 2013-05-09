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
		<div id="flickrGallery">
			<c:forEach items="${galleriesModel.galleries.gallery}" var="gallery"
				varStatus="status">
				<div class="photo-border" id="gallery-${gallery.id}" title="${gallery.title._content}">
					<a href="<c:url value="/viewGallery/${gallery.id}" />"> <img
						title="${photo.title}"
						src="<c:out value="http://farm${gallery.primary_photo_farm}.staticflickr.com/${gallery.primary_photo_server}/${gallery.primary_photo_id}_${gallery.primary_photo_secret}_s.jpg" />" />
					</a>
				</div>
			</c:forEach>
		</div>


		<div style="float:right;">
			<div class="border-bottom">
				<table>
					<tr>
						<td valign="top">
							<img src="${person.buddyIcon}" />
							<c:if test="${person.ispro ne 0}">
								<label class="pro">pro</label>
							</c:if>
						</td>
						<td valign="top">
							<div>
								<div class="font-weight:bold">${title}</div>
								<div>${person.location._content}</div>
							</div>
						</td>
					</tr>
				</table>
			</div>
			<div  class="border-bottom">
				<label style="margin-left:10px;" title="Total photos uploaded " class="count">${person.photos.count._content}</label> 
			</div>
			<div class="border-bottom">
				${person.description._content}
			</div>
			<div class="border-bottom">
				 <a href="${person.photosurl._content}" target="_blank">View of flickr</a>
			</div class="border-bottom">
		</div>

	</div>
</body>
</html>