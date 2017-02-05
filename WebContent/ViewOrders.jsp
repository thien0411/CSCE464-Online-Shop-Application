<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Order</title>



<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="css/main.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<script src="js/main.js"></script>

</head>



<body>

<nav class="navbar navbar-default">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
			data-toggle="collapse" data-target="#head-nav"
			aria-expanded="false">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="CustomerHomePage.jsp">Home Page</a>
			<a class="navbar-brand" href="Login.jsp">Logout</a>
		</div>
	
	
		
	</div>
</nav>

<div class="container">
  <h2>Here is your list of order</h2>
  <table class="table">
    <thead>
      <tr>
        <th>Order Number</th>
        <th>Order Total</th>
        <th>Order Date</th>
      </tr>
    </thead>
    
    <tbody>
    	<tr>
     		<td>123123</td>
     		<td>190.00</td>
     		<td>01/01/199</td>
     		<td>
     			<form action="ManageOrder.jps"> <input type="submit" class="btn btn-primary" value="View"></form>
     		</td>
     	</tr>
     	<tr>
     		<td>123123</td>
     		<td>190.00</td>
     		<td>01/01/199</td>
     		<td>
     			<form action="ManageOrder.jps"> <input type="submit" class="btn btn-primary" value="View"></form>
     		</td>
     	</tr>
     	<tr>
     		<td>123123</td>
     		<td>190.00</td>
     		<td>01/01/199</td>
     		<td>
     			<form action="ManageOrder.jps"> <input type="submit" class="btn btn-primary" value="View"></form>
     		</td>
     	</tr>
     	<tr>
     		<td>123123</td>
     		<td>190.00</td>
     		<td>01/01/199</td>
     		<td>
     			<form action="ManageOrder.jps"> <input type="submit" class="btn btn-primary" value="View"></form>
     		</td>
     	</tr>
     	
    </tbody>
  </table>
  
  
 
</div>




</body>
</html>