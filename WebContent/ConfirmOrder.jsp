<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1"/>

<title>Confirm Order | <c:out value="${initParam.App_Title}" /></title>

<jsp:include page="/WEB-INF/stylesheets.html" />
</head>
<body>
<%@ include file="/WEB-INF/navbar-common.jsp" %>

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

  <div style="max-width: 30em;">
    <div class="form-group">
      First Name:
      <input type="text" class="form-control" id="firstName"
        placeholder="First Name">
    </div>

    <div class="form-group">
      Last Name:
      <input type="text" class="form-control" id="lastName"
        placeholder="Last Name">
    </div>

    <div class="form-group">
      Card Type:
      <select class="form-control" id="cardType">
        <option value="visa">Visa</option>
        <option value="master">Master</option>
        <option value="discover">Discover</option>
      </select>
    </div>

    <div class="form-group">
      Card Number:
      <input type="text" class="form-control" id="cardNumber"
        placeholder="Card Number" maxlength="16">
    </div>

    <div class="form-group">
      Security Code:
      <input type="text" class="form-control" id="securityCode"
        placeholder="Security Code" maxlength="4">
    </div>

    <div class="form-group">
      Card Expiration:
      <input type="month" class="form-control" id="expireMonth"
        placeholder="Card Expiration">
    </div>

    <div class="form-group">
      Billing Address:
      <input type="text" class="form-control" id="billingAddress"
        placeholder="Billing Address">
    </div>

    <div class="form-group">
      Shipping Address:
      <input type="text" class="form-control" id="shippingAddress"
        placeholder="Shipping Address">
    </div>
  </div>

  <div>
    <br>
    <input type="hidden" id="cartTotal" value="${cartTotal}">
    <button type="button" id="confirmPayment" class="btn btn-primary">Confirm Payment</button>
  </div>

  <form action="View&CheckoutShoppingCart.jsp" method="post">
    <input type="submit" class="btn btn-default" value="Cancel Payment">
    <br><br>
  </form>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<script src="js/main.js"></script>

<script>
  $(document).ready(() => {
    /* TODO: confirm_function */
    function confirm_function () {
      /*
      * Send cardType, cardNumber, securityCode, expireMonth,
      * totalOrder
      */
      var cardType = $('#cardType').val()
      var cardNumber = $('#cardNumber').val()
      var securityCode = $('#securityCode').val()
      var expireMonth = $('#expireMonth').val()
      var totalOrder = $('#cartTotal').val()

      if (cardType == null || cardType.trim() == '' ||
          cardNumber == null || cardNumber.trim() == '' ||
          securityCode == null || securityCode.trim() == '' ||
          expireMonth == null || expireMonth.trim() == '' ||
          totalOrder == null || totalOrder.trim() == '') {
        $('#confirmPayment').prop('disabled', false)
        alert('Error: Please fill out the form.')
        return
      }

      var firstName = $('#firstName').val()
      var lastName = $('#lastName').val()
      var billingAddress = $('#billingAddress').val()
      var shippingAddress = $('#shippingAddress').val()
      
      /* Make sure form is filled out for the order as well */
      
      if (firstName == null || firstName.trim() == '' ||
          lastName == null || lastName.trim() == '' ||
          billingAddress == null || billingAddress.trim() == '' ||
          shippingAddress == null || shippingAddress.trim() == '') {
        $('#confirmPayment').prop('disabled', false)
        alert('Error: Please fill out the form.')
        return
      }

      var dataSend = {
        cardType: cardType,
        cardNumber: cardNumber,
        securityCode: securityCode,
        expireMonth: expireMonth,
        totalOrder: totalOrder
      }
      
      var orderDataSend = {
          firstName: firstName,
          lastName: lastName,
          billingAddress: billingAddress,
          shippingAddress: shippingAddress
      }

      $.post('/BankingApplication/Bank', dataSend, (data, status) => {
        if (data == 1) {
          /* Success! */
          place_order_function(orderDataSend)
        } else {
          $('#confirmPayment').prop('disabled', false)
          alert('Insufficient funds/invalid card data')
        }
      })
    }

    /* TODO: place_order_function */
    function place_order_function (orderData) {
      /*
      * Send firstName, lastName, billingAddress, shippingAddress
      */
      $.post('', orderData, (data, status) => {
        if (data == 1) {
          /* Success*/
        } else {
          $('#confirmPayment').prop('disabled', false)
          alert('Error: Could not process order')
        }
      })

    }

    $('#confirmPayment').click(() => {
      $('#confirmPayment').prop('disabled', true)
      confirm_function()
    })
  })
</script>
</body>
</html>
