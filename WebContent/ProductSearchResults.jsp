<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1"/>

<title>Search - ${query}</title>

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
						<li><a href="Login.jsp">Logout</a></li>
					</ul>
				</li>
			</ul>

			<form class="navbar-form navbar-right" role="search" action="ProductSearchQuery" method="post">
				<div class="form-group">
          <label for="categories">Category</label>
          <select class="form-control" name="category">
            <option value="0">All Categories</option>
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
            <option value="4">4</option>
          </select>
					<input type="text" class="form-control" name="searchQuery" placeholder="Search" value="${query}" required="required">
				</div>
				<input type="button" class="btn btn-default" onclick="validateSearch(this.form)" value="Submit">
			</form>
		</div>
	</div>
</nav>

<div class="container">
  <h2>Search results for <i>${query}</i></h2>
  <table class="table">
    <thead>
      <tr>
        <th>Thumbnail</th>
        <th>Name</th>
        <th>Category</th>
        <th>Seller Name</th>
        <th>Price</th>
        <td></td>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td><img src="${productList[0].thumbnail}" alt="Thumbnail"></td>
        <td>${productList[0].name}</td>
        <td>${productList[0].category}</td>
        <td>${productList[0].sellerName}</td>
        <td>$${productList[0].price}</td>
        <td>[Button]</td>
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
