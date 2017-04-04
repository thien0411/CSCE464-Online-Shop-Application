<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1"/>

<title>Exception Error | <c:out value="${initParam.App_Title}" /></title>

<jsp:include page="/WEB-INF/stylesheets.html" />
</head>
<body>
<h1>Woops! Java Exception!</h1>

<h2>Details</h2>

<p>Type: <c:out value="${pageContext.exception["class"]}"/></p>
<p>Message: <c:out value="${pageContext.exception.message}" /></p>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<script src="js/main.js"></script>
</body>
</html>
