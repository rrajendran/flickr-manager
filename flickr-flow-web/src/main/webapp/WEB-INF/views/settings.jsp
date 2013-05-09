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
		<div id="settingsDiv">
			<form:form id="formSettings" commandName="settings" method="POST" action="saveSettings">
				<table>
					<tr>
						<td>Flickr Id</td>
						<td>
							<form:input path="flickrId"/>
						</td>
					</tr>
					<tr>
						<td>Download path</td>
						<td>
							<form:input type="file" path="downloadPath"/>
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="submit" value="Save">
						</td>
					</tr>
				</table>
			</form:form>
		</div>
	</div>
</body>
</html>