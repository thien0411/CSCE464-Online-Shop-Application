<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cancel Order</title>

<link rel="stylesheet"
	href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="css/main.css">

</head>
<body>
	<nav class="navbar navbar-default">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#head-nav" aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="CustomerHomePage.jsp">Welcome</a>
		</div>

		<div class="collapse navbar-collapse" id="head-nav">
			<ul class="nav navbar-nav">
				<li><a href="CustomerHomePage.jsp">Home</a></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false"> Account <span class="caret"></span>
				</a>

					<ul class="dropdown-menu">
						<li><a href="ViewOrders.jsp">View Orders</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="Login.jsp">Logout</a></li>
					</ul></li>
			</ul>
		</div>
	</div>
	</nav>

	<div class="container">

		<ul>
			<h3>Order Number: 123123</h3>

			<ul>

				<li>
					<h4>Items1:</h4>
				</li>
				<ul>
					<li>
						<h4>Product Name: Product2</h4>
					</li>
					<li>
						<h4>Product quantity: 10</h4>
					</li>
					<li>
						<h4>Total Price: $100.00</h4>
					</li>
					<li>
						<h4>Seller Name: Amazon</h4>
					</li>
					<li>
						<h4>Shipping Status: Wait for shipping</h4>
					</li>
					<form action="CancellationConfirmation.jsp">
						<input type="submit" class="" value="Confirm Cancellation">
					</form>
					<br>
					<form action="CustomerHomePage.jsp">
						<input type="submit" class="" value="Discard Cancellation">
					</form>
				</ul>
			</ul>

		</ul>

	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
	<script
		src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
	<script src="js/main.js"></script>
</body>
</html>