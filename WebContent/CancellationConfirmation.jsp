<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1"/>

<title>Cancellation Confirmation</title>

<jsp:include page="/WEB-INF/stylesheets.html" />
</head>
<body>
<%@ include file="/WEB-INF/navbar-common.jsp" %>

<div class="container">
  <h2>Cancel Confirmation! </h2>
  <h3>The following item(s) has been cancelled:</h3>

  <table class="table">
    <tr>
      <td class="order-item">
      	<p>OrderNumber: ${orderId}</p>
        <p>Item Name: ${orderItem.name}</p>
        <p>Quantity: ${orderItem.quantityRequested}</p>
        <p>Seller Name: ${orderItem.sellerName}</p>
        <p>Price: ${orderItem.formattedTotalPrice()}</p>
        <p>Status: "Cancelled"</p>

      </td>
    </tr>
  </table>
 <h3>The total amount of $${orderItem.formattedTotalPrice()} has been refund to your credit card account.</h3>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<script src="js/main.js"></script>
</body>
</html>
