<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1"/>

<title>Customer Transaction</title>

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
  <h2>Your Transaction</h2>

  <table class="table">
    <tr>
      <th>Name</th>
      <th>Quantity</th>
      <th>Price (Individual)</th>
      <th>Seller Name</th>
    </tr>

    <c:forEach var="item" items="${shoppingCart}">
      <tr>
        <td><c:out value="${item.name}"/></td>
        <td><c:out value="${item.quantityRequested}"/></td>
        <td><c:out value="${item.formattedPrice()}"/></td>
        <td><c:out value="${item.sellerName}"/></td>
      </tr>
    </c:forEach>

    <tr>
      <td colspan="4"><h3>Total: <c:out value="${formattedCartTotal}"/></h3></td>
    </tr>
  </table>

  <h3>Payment Information</h3>

  <form style="max-width: 30em;"
    action="CustomerTransactionConfirmation" method="post">
    <div class="form-group">
      First Name:
      <input type="text" class="form-control" name="firstName"
        placeholder="First Name">
    </div>

    <div class="form-group">
      Last Name:
      <input type="text" class="form-control" name="lastName"
        placeholder="Last Name">
    </div>

    <div class="form-group">
      Card Type:
      <select class="form-control" name="cardType">
        <option value="visa">Visa</option>
        <option value="master">Master</option>
        <option value="discover">Discover</option>
      </select>
    </div>

    <div class="form-group">
      Card Number:
      <input type="text" class="form-control" name="cardNumber"
        placeholder="Card Number" maxlength="16">
    </div>

    <div class="form-group">
      Security Code:
      <input type="text" class="form-control" name="securityCode"
        placeholder="Security Code" maxlength="3">
    </div>

    <div class="form-group">
      Card Expiration:
      <input type="month" class="form-control" name="expireMonth"
        placeholder="Card Expiration">
    </div>

    <div class="form-group">
      Billing Address:
      <input type="text" class="form-control" name="billingAddress"
        placeholder="Billing Address">
    </div>

    <div class="form-group">
      Shipping Address:
      <input type="text" class="form-control" name="shippingAddress"
        placeholder="Shipping Address">
    </div>

    <input type="submit" class="btn btn-primary" value="Confirm Payment">
    <br><br>
  </form>

  <form action="View&CheckoutShoppingCart.jsp" method="post">
    <input type="submit" class="btn btn-default" value="Cancel Payment">
    <br><br>
  </form>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<script src="js/main.js"></script>
</body>
</html>
