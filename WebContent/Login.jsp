<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1"/>

<title>Login - MVC Web Application</title>

<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="css/main.css">
</head>

<body>
<div class="container">
  <div id="header">
    <h1>Online Shopping Application</h1>
    <h2>Login</h2>
  </div>

  <div id="cred">
    <form action="Login">
      <div class="input-group">
        <input type="text" class="form-control" name="userName" placeholder="Username" required="required">
      </div>

      <div class="input-group">
        <input type="password" class="form-control" name="password" placeholder="Password" required="required">
      </div>

      <div class="btn-group btn-group-justified" role="group">
        <div class="btn-group" role="group">
          <input type="submit" class="btn btn-primary" value="Login">
        </div>
      </div>
    </form>

    <h4><a href="Registration.jsp">Are you a New User?</a></h4>
  </div>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
</body>
</html>
