<c:if test="${fn:length(info.photo.tags.tag) > 0}">
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
</c:if>