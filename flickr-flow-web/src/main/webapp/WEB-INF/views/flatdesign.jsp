<!DOCTYPE html>
<html>
<head>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<meta charset="utf-8" />
<title>Flat Nav</title>

<link rel="stylesheet" type="text/css"
	href="<c:url value="/static/scripts/flatdesign.css" />" media="all">
<link href='http://fonts.googleapis.com/css?family=Dosis'
	rel='stylesheet' type='text/css'>

</head>
<body>
	<nav class="menu">
			<ul>
				<li><a href="#"> <span>Home</span>
				</a></li>
				<li><a href="#"> <span>About</span>
				</a></li>
				<li><a href="#"> <span>Portfolio</span>
				</a></li>
				<li><a href="#"> <span>Contact</span>
				</a></li>
				<li><a  href="#"> <span>Explore</span>
				</a></li>
			</ul>
	</nav>
	
</body>
</html>