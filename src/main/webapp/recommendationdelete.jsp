<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete a Post</title>
<style>
	body {
	  background-color: DarkSalmon;
	  color: white;
	}
</style>
</head>
<body>
<div align="center">
	<h1>Delete a Post</h1>
	<h1>${messages.title}</h1>
	
	<form action="recommendationdelete" method="post">
		
			<div <c:if test="${messages.disableSubmit}">style="display:none"</c:if>>
				<label for="recommendationId">RecommendationId</label>
				<input id="recommendationId" name="recommendationId" value="${fn:escapeXml(param.recommendationId)}">
				<label for="userName">User Name</label>
				<input id="userName" name="userName" value="${fn:escapeXml(param.userName)}">
				<label for="bookName">Book Name</label>
				<input id="bookName" name="bookName" value="${fn:escapeXml(param.bookName)}">
			</div>
		
		
		<p>
			<span id="submitButton" <c:if test="${messages.disableSubmit}">style="display:none"</c:if>>
			<input type="submit">
			</span>
		</p>
	</form>
	<br/><br/>
	</div>
	<footer>
	
	<div align="center">
	<br>
		 <p>� Reader's Corner 2022</p>
	</div>
	</footer>
</body>
</html>