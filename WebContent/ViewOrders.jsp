<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1"/>

<title>View Order</title>

<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="css/main.css">
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
			<a class="navbar-brand" href="CustomerHomePage.jsp">Welcome</a>
		</div>

		<div class="collapse navbar-collapse" id="head-nav">
			<ul class="nav navbar-nav">
				<li><a href="CustomerHomePage.jsp">Home</a></li>
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown"
					role="button" aria-haspopup="true" aria-expanded="false">
						Account <span class="caret"></span>
					</a>

					<ul class="dropdown-menu">
						<li><a href="ViewOrders.jsp">View Orders</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="Login.jsp">Logout</a></li>
					</ul>
				</li>
			</ul>
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
     		<td>150.00</td>
     		<td>01/01/2017</td>
     		<td>
     			<form action="ManageOrder.jsp"> <input type="submit" class="btn btn-default" value="View"></form>
     		</td>
     	</tr>
     	<tr>
     		<td>234567</td>
     		<td>158.00</td>
     		<td>14/01/2017</td>
     		<td>
     			<form action="ManageOrder.jsp"> <input type="submit" class="btn btn-default" value="View"></form>
     		</td>
     	</tr>
     	<tr>
     		<td>345678</td>
     		<td>164.00</td>
     		<td>12/01/2017</td>
     		<td>
     			<form action="ManageOrder.jsp"> <input type="submit" class="btn btn-default" value="View"></form>
     		</td>
     	</tr>
     	<tr>
     		<td>456789</td>
     		<td>182.00</td>
     		<td>11/01/2017</td>
     		<td>
     			<form action="ManageOrder.jsp"> <input type="submit" class="btn btn-default" value="View"></form>
     		</td>
     	</tr>
    </tbody>
  </table>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<script src="js/main.js"></script>
</body>
</html>
