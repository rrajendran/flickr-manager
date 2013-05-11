<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="taglibs.jsp"%>
<%@ include file="includes.jsp"%>
</head>
<body>
	<div id="wrapper">
		<form action="signin/flickr" method="POST">
			<div class="signinwith">
				<img  src="<c:url value='/static/scripts/images/flickr.png' />" width="50px" height="50px;">
			</div>
			<div style="float:left;clear:right;">
				<input
					style="padding: 20px;background-color:#ff0084;font-size:14px	"
					type="submit" value="Sign with flickr" />
			</div>

			</p>
		</form>

	</div>
</body>
</html>