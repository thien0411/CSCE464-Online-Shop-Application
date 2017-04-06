<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1"/>

<title>Registration | <c:out value="${initParam.App_Title}" /></title>

<jsp:include page="/WEB-INF/stylesheets.html" />
</head>
<body>
<div class="container">
  <div id="header">
    <h1>Online Shopping Application</h1>
    <h2>Registration</h2>
  </div>

  <div id="cred">
    <form action="Registration" method="post">
      <div class="input-group">
        <input type="text" class="form-control" name="userName" placeholder="Username" required="required" value="">
      </div>

      <div class="input-group">
        <input type="password" class="form-control" name="password" placeholder="Password" required="required">
      </div>

      <div class="btn-group btn-group-justified" role="group">
        <div class="btn-group" role="group">
          <input type="submit" class="btn btn-primary" value="Register New Account">
        </div>
      </div>
    </form>

    <h4><a href="Login.jsp">Home</a></h4>
  </div>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
</body>
</html>
