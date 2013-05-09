<div class="pagination">
	<div id="previous" class="prev">
		<a href="<c:url value="${request.requestUrl}?${request.queryString}&page=${previousPage}" />"> Previous </a>
	</div>
	<div id="next" class="next">
		<a href="<c:url value="${request.requestUrl}?${request.queryParameters}&page=${nextPage}" />"> Next </a>
	</div>
</div>