<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1"/>

<title>Confirm Order | <c:out value="${initParam.App_Title}" /></title>

<jsp:include page="/WEB-INF/stylesheets.html" />
</head>
<body>
<%@ include file="/WEB-INF/navbar-common.jsp" %>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<script src="js/main.js"></script>

<script>
  $(document).ready(() => {
    /* TODO: confirm_function */

    /* TODO: place_order_function */
  })
</script>
</body>
</html>
