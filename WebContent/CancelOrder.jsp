<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1"/>

<title>Cancel Order | <c:out value="${initParam.App_Title}" /></title>

<jsp:include page="/WEB-INF/stylesheets.html" />
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
  <h2>Do you want to cancel the following item?</h2>

  <table class="table">
    <tr>
      <td class="order-item">
      	<p>OrderNumber: ${orderId}</p>
        <p>Item Name: ${orderItem.name}</p>
        <p>Quantity: ${orderItem.quantityRequested}</p>
        <p>Seller Name: ${orderItem.sellerName}</p>
        <p>Price: ${orderItem.formattedTotalPrice()}</p>
        <p>Shipping Status: ${orderItem.isShipped ? "Shipped" : "Not yet shipped"}</p>
      </td>

      <td>
        <form action="CancelOrderTransaction" method="post">
          <input type="hidden" name="itemId" value="${orderItem.id}">
          <input type="hidden" name="orderId" value="${orderId}">
          <input type="submit" class="btn btn-default" value="Confirm Cancellation">
        </form>
        <br>
        <form action="CustomerHomePage.jsp">
          <input type="submit" class="btn btn-default" value="Discard Cancellation">
        </form>
      </td>
    </tr>
  </table>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<script src="js/main.js"></script>
</body>
</html>
