<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Manage Order</title>

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
            <c:out value="${user.userName}"/> <span class="caret"></span>
          </a>

          <ul class="dropdown-menu">
            <li><a href="ViewOrders">View Orders</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="Logout">Logout</a></li>
          </ul>
        </li>
      </ul>
    </div>
  </div>
</nav>

<div class="container">
  <h2>Order Number: ${order.orderId}</h2>

  <table class="table">
    <c:forEach var="item" items="${order.products}">
      <tr>
        <td class="order-item">
          <h3>Product Name: <c:out value="${item.name}"/></h3>
          <p>Product quantity: ${item.quantityRequested}</p>
          <p>Total Price: ${item.formattedPrice()}</p>
          <p>Seller Name: <c:out value="${item.sellerName}"/></p>
          <p>Shipping Status: ${item.isShipped ? "Shipped" : "Not yet shipped"}</p>
        </td>
        <td>
          <form action="ProductSearchResults" method="post">
            <input type="hidden" name="productId" value="${item.id}">
            <input type="submit" class="btn btn-default" value="View ProductDetails">
          </form>
          <br>
          <form action="CancelOrder" method="post">
            <input type="hidden" name="productId" value="${item.id}">
            <input type="hidden" name="orderId" value="${order.orderId}">
            <input type="submit" class="btn btn-default" value="Cancel">
          </form>
        </td>
      </tr>
    </c:forEach>
  </table>

  <div class="order-details">
    <p>Order Total: ${order.orderTotal}</p>
    <p>Ordered Date: ${order.orderDate}</p>
    <p>Shipping Address: ${order.shippingAddress}</p>
  </div>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script	src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
<script	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<script src="js/main.js"></script>
</body>
</html>
