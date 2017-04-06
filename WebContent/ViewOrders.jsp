<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1"/>

<title>View Order | <c:out value="${initParam.App_Title}" /></title>

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

  <c:choose>
    <c:when test="${orderList.size() == 0}">
      <h2>You have no orders.</h2>
    </c:when>
    <c:otherwise>
      <h2>List of order(s)</h2>
      <table class="table">
        <tr>
          <th>Order Number</th>
          <th>Order Total</th>
          <th>Order Date</th>
        </tr>

        <c:forEach var="order" items="${orderList}">
        	<tr>
         		<td>${order.orderId}</td>
         		<td>$${order.orderTotal}</td>
         		<td>${order.orderDate}</td>
         		<td>
         			<form action="ManageOrder" method="post">
                <input type="hidden" name="orderId" value="${order.orderId}">
                <input type="submit" class="btn btn-default" value="View ManageOrder">
           		</form>
         	  </td>
         	</tr>
        </c:forEach>
      </table>
    </c:otherwise>
  </c:choose>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<script src="js/main.js"></script>
</body>
</html>
