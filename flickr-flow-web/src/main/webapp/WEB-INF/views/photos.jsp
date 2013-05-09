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
		<div style="float: left;">
			<%@ include file="pagination.jsp"%>
			<%@ include file="lightbox.jsp"%>

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
		</div>

		<c:if test="${person}">
			<div style="float: left; width: 18%">
				<div class="border-bottom">
					<table>
						<tr>
							<td valign="top"><img src="${person.buddyIcon}" /> <c:if
									test="${person.ispro ne 0}">
									<label class="pro">pro</label>
								</c:if></td>
							<td valign="top">
								<div>
									<div class="font-weight:bold">${title}</div>
									<div>${person.location._content}</div>
								</div>
							</td>
						</tr>
					</table>
				</div>
				<div class="border-bottom">
					<label style="margin-left: 10px;" title="Total photos uploaded "
						class="count">${person.photos.count._content}</label>
				</div>
				<div class="border-bottom">${person.description._content}</div>
				<div class="border-bottom">
					<a href="${person.photosurl._content}" target="_blank">View of
						flickr</a>
				</div class="border-bottom">
			</div>
		</c:if>
	</div>
</body>
</html>