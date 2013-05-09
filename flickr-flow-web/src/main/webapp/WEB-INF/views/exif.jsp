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
		<c:choose>
			<c:when test="${info != null}">
				<div id="flickrImg">
					<img
						src="<c:out value="http://farm${info.photo.farm}.staticflickr.com/${info.photo.server}/${info.photo.id}_${info.photo.secret}_z.jpg" />" />
				</div>
				<div id="exifInfo">
					<table class="exifTable">
						<c:forEach items="${exifWrapper.photo.exif}" var="exif" varStatus="status">
							<c:choose>
								<c:when test="${exif.label == 'Lens Model' }">
									<tr>
										<td><c:out value=" ${exif.label}" /></td>
										<td><a
											href="<c:url value='/search?text=${exif.raw._content}'/>">${exif.raw._content}</a>
										</td>
									</tr>
								</c:when>
								<c:when test="${exif.label == 'Model' }">
									<tr>
										<td><c:out value=" ${exif.label}" /></td>
										<td><a
											href="<c:url value='/search?camera=${exif.raw._content}'/>">${exif.raw._content}</a>
										</td>
									</tr>
								</c:when>
								<c:otherwise>
									<tr>
										<td><c:out value=" ${exif.label}" /></td>
										<td><c:out value=" ${exif.raw._content}" /></td>
									</tr>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</table>
				</div>
	</div>

	</c:when>

	<c:otherwise>
      			No Permissions to read
      		</c:otherwise>
	</c:choose>
	</div>
</body>
</html>