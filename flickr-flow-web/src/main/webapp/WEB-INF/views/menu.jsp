<%@ include file="taglibs.jsp"%>
<div id='cssmenu'>
	<ul>
		<li class='has-sub'>
			<a href='<c:url value="/getPublicPhotos?user_id=${principal.principal}" />'><span>My Flow</span></a>
			<ul>
				<li><a href='<c:url value="/profile/${principal.principal}" />'><span>Profile</span></a></li>
				<li><a href='<c:url value="/photosets/sets?nsid=${principal.principal}" />'><span>Sets</span></a></li>
				<li><a href='<c:url value="/galleries/${principal.principal}" />'><span>Galleries</span></a></li>
				<li><a href='<c:url value="j_spring_security_logout" />'><span>Logout</span></a></li>
				<%-- <li><a href='<c:url value="/tags?nsid=${principal.principal}" />'><span>Tags</span></a></li> --%>
			</ul>
		</li>
		<li class='active has-sub'><a href='<c:url value="/explore" />'><span>Explore</span></a>
			<ul>
				<li><a href='<c:url value="/recentPhotos" />'><span>Recent</span></a></li>
				<li><a href='<c:url value="/search?has_geo=1" />'><span>Geotagged</span></a></li>
			</ul>
		</li>
		
		<%-- <li class='last'><a href='<c:url value="/settings" />'><span>Settings</span></a></li> --%>
	</ul>
	<div id="search">
		<form:form method="post" action="search" id="frmPopulateBabyNames"
			commandName="formSearch">
			<form:input path="text" type="text" title="Enter your search" />
			<input type="submit" value="Go" />
		</form:form>
	</div>
</div>