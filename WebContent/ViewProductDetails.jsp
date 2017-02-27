<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1"/>

<title>Product Details - Cool Item</title>

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
        <li><a href="ManageOrder.jsp">Manage Order</a></li>
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown"
					role="button" aria-haspopup="true" aria-expanded="false">
						${userName} <span class="caret"></span>
					</a>

					<ul class="dropdown-menu">
						<li><a href="ViewOrders.jsp">View Orders</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="Logout">Logout</a></li>
					</ul>
				</li>
			</ul>
		</div>
	</div>
</nav>

<div class="container">
  <div class="back">
    <form action="ProductSearchQuery" method="post">
      <input type="hidden" name="searchQuery" value="${query}">
      <input class="btn btn-default" type="submit" value="&lt; Back">
    </form>
  </div>
  <div class="product-details row">
    <h2>Product Details for <i>${product.name}</i></h2>
    
    <div class="col-sm-4 col-md-5">
      <img src="${product.photos[0]}">
    </div>
    
    <div class="col-sm-8 col-md-7">
      <p>Price: $${product.price}</p>
      <p>Seller: ${product.sellerName}</p>
      <p>Amount in Stock: ${product.availableQuantity}</p>
      <p>Estimated Delivery Time: ${product.estimatedDeliveryDays} Days</p>

      <h3>Description</h3>
      <p>${product.description}</p>

      <form action="UpdateShoppingCart" method="post">
        <input type="submit" class="btn btn-primary" value="Add To Cart">
      </form>
    </div>
  </div>

  <div class="customer-QA">
    <h3>Customer Q and A</h3>
    <table class="table">
      p.showCustomerQA()
     </table>
  </div>

  <div class="customer-review">
    <h3>Reviews</h3>

    <table class="table">
      p.showCustomerReviews()
    </table>
  </div>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<script src="js/main.js"></script>
</body>
</html>
