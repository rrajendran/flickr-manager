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