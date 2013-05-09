<%@ page session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../includes.jsp"%>
</head>
<body>
	<div id="wrapper">
		<form action="<c:url value="/connect/flickr" />" method="POST">
			<p>You haven't created any connections with Twitter yet. Click
				the button to create a connection between your account and your
				Twitter profile. (You'll be redirected to Twitter where you'll be
				asked to authorize the connection.)</p>
			<p>
				<input type="submit" value="Sign with flickr"/>
			</p>
		</form>

	</div>
</body>
</html>