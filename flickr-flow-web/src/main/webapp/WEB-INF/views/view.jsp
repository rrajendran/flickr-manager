<%@ page session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="includes.jsp"%>
<script src="<c:url value="/static/scripts/view.js" />"></script>
</head>
<body>
	<div id="container">
		<section style="float:left">
			<div class="home box" style="background-color: yellow;">
				
			</div>
			<div class="profile box" style="background-color: #6196da;">
				<span> <%@ include file="profileInfo.jsp"%>
				</span>
			</div>
			<c:if test="${info.photo.location != null}">
				<div class="location box" style="background-color: #d41243;">
					<span> <%@ include file="location.jsp"%>
					</span>
				</div>
			</c:if> <c:if test="${fn:length(info.photo.tags.tag) > 0}">
				<div class="tags box" style="background-color: #8ec127;">
					<span> <%@ include file="tags.jsp"%>
					</span>
				</div>
			</c:if> 
			<c:if
			test="${fn:length(exifWrapper.photo.exif) gt 0}">
			<div class="exif box" style="background-color: #00aedb;">
				<span class="exifclass"> 
				<%@ include file="exif.jsp"%>
				</span>
			</div>
		</c:if>
		<div class="comments box" style="background-color: #a200ff;">
			<span
				style="top: 55px; font-family: sans-serif; text-transform: none; width: 500px; height: 600px; overflow: auto; background-color: #a200ff; color: white">
				<%@ include file="comments.jsp"%>
			</span>
		</div>
		<c:set var="favColor" value="gray" /> <c:set var="favText"
			value="Add to favourites" /> <c:set var="favId"
			value="addFavourites" /> <c:if test="${info.photo.isfavorite}">
			<c:set var="favId" value="removeFavourites" />
			<c:set var="favColor" value="red" />
			<c:set var="favText" value="Remove from favourites" />
		</c:if>
		<div id="<c:out value="${favId}"/>" name="${info.photo.id}"
			class="favourite box"
			style="background-color: <c:out value="${favColor}"/>">
			<span style="background-color: <c:out value="${favColor}"/>"><c:out
					value="${favText}" /></span>
		</div>
		<div class="views box" style="background-color: #d41243;">
			<span style="background-color: #d41243; color: white">
				<div style="font-size: 20px">Total views</div>
				<div style="font-size: 30px">${info.photo.views }</div>
			</span>
		</div>
		<c:if test="${info.photo.usage.candownload}">
			<div class="download box" style="background-color: #f47835;">
				<span style="background-color: #f47835; color: white"> </span>
			</div>

		</c:if>
	</section>
		<!-- <section style="float:left">
		<div class="prev navbox" style="background-color: #8ec127;" />
	</section> -->
		<section style="float:left;width:1024px"> 
			<a href="<c:url value="/explore/view/${date}/${nextPage}"/>">
				<img id="flickrImage" src="<c:out value="http://farm${info.photo.farm}.staticflickr.com/${info.photo.server}/${info.photo.id}_${info.photo.secret}_b.jpg" />" />
			</a>
			
		<div>
			<h2>${info.photo.title._content}</h2>
		</div>
		<div>${info.photo.description._content}</div>
		</section>
		<section style="float:right" id="navBar">
			<div class="prev" ></div>
			<div class="next"></div>
		</section>
		<!-- <section style="float:left">
		<div class="next navbox" style="background-color: #8ec127;" />
	</section> -->
	</div>
</body>
</html>