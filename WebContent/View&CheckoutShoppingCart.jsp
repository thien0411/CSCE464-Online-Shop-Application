<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1"/>

<title>Shopping Cart</title>

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
            <c:out value="${userName}"/> <span class="caret"></span>
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
  <h2>Shopping Cart</h2>

  <table class="table">
    <tr>
      <th>Thumbnail</th>
      <th>Name</th>
      <th>Seller Name</th>
      <th>Quantity</th>
      <th>Price (Individual)</th>
      <th>Estimated Delivery Days</th>
      <td></td>
    </tr>
      <c:forEach var="item" items="${shoppingCart}">
        <tr>
          <td><img src="${item.thumbnail}" alt="Thumbnail"></td>
          <td><c:out value="${item.name}"/></td>
          <td><c:out value="${item.sellerName}"/></td>
          <td><c:out value="${item.quantityRequested}" /></td>
          <td>$<c:out value="${item.formattedPrice()}"/></td>
          <td><c:out value="${item.estimatedDeliveryDays}"/></td>
          <td>
            <form action="UpdateShoppingCart" method="post">
              <input type="hidden" name="productId" value="${item.id}">
              <input type="hidden" name="action" value="delete">
              <input type="submit" class="btn btn-default" value="Delete Item">
            </form>
          </td>
        </tr>
      </c:forEach>
    <tr>
      <td colspan="7"><h3>Total: $<c:out value="${cartTotal}"/></h3></td>
    </tr>
  </table>

  <form action="CustomerTransaction.jsp" method="post">
    <input class="btn btn-primary" type="submit" value="Checkout">
  </form>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<script src="js/main.js"></script>
</body>
</html>
