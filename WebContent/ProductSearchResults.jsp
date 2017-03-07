<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1"/>

<title>Search - <c:out value="${query}"/></title>

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
        <li><a href="View&CheckoutShoppingCart.jsp">Shopping Cart (<c:out value="${shoppingCart.size()}"/>)</a></li>
        <li><a href="ManageOrder.jsp">Manage Order</a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown"
          role="button" aria-haspopup="true" aria-expanded="false">
            <c:out value="${user.userName}" /> <span class="caret"></span>
          </a>

          <ul class="dropdown-menu">
            <li><a href="ViewOrders">View Orders</a></li>
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
            <option value="1">Camping/Hiking</option>
            <option value="2">Electronic</option>
            <option value="3">Kitchen</option>
            <option value="4">Office</option>
          </select>
          <input type="text" class="form-control" name="searchQuery" placeholder="Search" value="${query}" required="required">
        </div>
        <input type="button" class="btn btn-default" onclick="validateSearch(this.form)" value="Submit">
      </form>
    </div>
  </div>
</nav>

<div class="container">
  <h2>Search results for <i><c:out value="${query}"/></i></h2>
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
      <c:forEach var="item" items="${productList}">
        <tr>
          <td><img src="${item.thumbnail}" alt="Thumbnail"></td>
          <td><c:out value="${item.name}"/></td>
          <td><c:out value="${item.category}"/></td>
          <td><c:out value="${item.sellerName}"/></td>
          <td>$<c:out value="${item.formattedPrice()}"/></td>
          <td>
            <form action="ProductSearchResults" method="post">
              <input type="hidden" name="productId" value="${item.id}">
              <input type="submit" class="btn btn-default" value="View ProductDetails">
            </form>
          </td>
        </tr>
      </c:forEach>
    </tbody>
  </table>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<script src="js/main.js"></script>
</body>
</html>
