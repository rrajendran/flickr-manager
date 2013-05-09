<%@ page session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="includes.jsp"%>
<script src="<c:url value="/static/scripts/view.js" />"></script>
</head>
<body>
	<%@ include file="menu.jsp"%>
	<div id="wrapper">
		<c:choose>
			<c:when test="${info != null}">
				<div id="flickrImg" style="width: 640px">
					<img
						src="<c:out value="http://farm${info.photo.farm}.staticflickr.com/${info.photo.server}/${info.photo.id}_${info.photo.secret}_z.jpg" />" />
					<div>
						<h2>${info.photo.title._content}</h2>
					</div>
					<div>${info.photo.description._content}</div>
					<div id="comments" style="display: block">
						<div>
							<b>Comments and faves</b> <a id="addComment" href="#addComment">Add
								comment</a>
						</div>
						<div id="commentContainer">
							<c:forEach items="${comments.comments.comment}" var="comment"
								varStatus="status">
								<div class="comment" id="comment_${comment.id}">
									<div id="author-${comment.author}">
										<table>
											<tr>
												<td style="width: 40px"><img src="${comment.buddyIcon}"
													class="buddyicon" /></td>
												<td valign="top">
													<div>
														<a
															href="<c:url value="/getPublicPhotos?user_id=${comment.author}"/>">${comment.authorname}</a>
														<c:if test="${principal.principal == comment.author}">
												| <a id="deleteComment_${comment.id}" class="deleteComment"
																href="#${comment.id}">delete</a>
												| <a id="editComment_${comment.id}" class="editComment"
																href="#${comment.id}">edit</a>
														</c:if>

													</div>
												</td>
											</tr>
											<tr>
												<td colspan="2">
													<div id="comment-content-${comment.id}">${comment._content}</div>
												</td>
											</tr>
										</table>
									</div>
								</div>
							</c:forEach>
						</div>
						<div id="dialog-form" title="Add comment" style="display: none">
							<form>
								<input type="hidden" id="photoId" name="photoId"
									value="${info.photo.id}" />
								<textarea style="width: 100%; height: 146px" name="userComment"
									id="userComment" class="text ui-widget-content ui-corner-all"
									id="userComment"></textarea>
							</form>
						</div>
					</div>
				</div>
				<div style="clear: right">
					<div style="margin-right: 10px; float: right; clear: right">
						<table>
							<tr>
								<td><img class="buddyicon"
									src="${person.person.buddyIcon }" /></td>
								<td valign="top">
									<div>
										<a
											href="<c:url value="/getPublicPhotos?user_id=${person.person.nsid}"/>">
											${info.photo.owner.username} </a>
									</div>
									<div>
										<c:if test="${person.person.contact == true}">
											${info.photo.owner.username} is your contact
										</c:if>
									</div>
								</td>
							</tr>
							<tr>
								<td colspan="2">
									<div>This photo was taken on ${info.photo.dates.taken} in
										${info.photo.location.country._content}</div>
								</td>
							</tr>
							<c:if test="${fn:length(info.photo.tags.tag) > 0}">
								<tr>
									<td colspan="2">

										<div>
											<h2>Tags</h2>
											<p>
												<c:forEach items="${info.photo.tags.tag}" var="tag"
													varStatus="status">
													<label> <a
														href="<c:url value="/search?tags=${tag._content}"/>">${tag._content}</a></label>,
												</c:forEach>
											</p>
										</div>

									</td>
								</tr>
							</c:if>
							<c:if test="${info.photo.location != null}">
								<tr>
									<td colspan="2">
										<div id="photoLocation" class="popDiv">

											<h2>Location</h2>
											<a
												href="<c:url value='/search?place_id=${info.photo.location.country.place_id}'/>">${info.photo.location.country._content}</a>,
											<a
												href="<c:url value='/search?place_id=${info.photo.location.region.place_id}'/>">${info.photo.location.region._content}</a>
										</div>
									</td>
								</tr>
							</c:if>
							<tr>
								<td colspan="2">
									<div style="width: 420px; height: 400px; overflow: auto;">
										<h2>Exif Info</h2>
										<table>
											<c:forEach items="${exifWrapper.photo.exif}" var="exif"
												varStatus="status">
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
								</td>
							</tr>
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