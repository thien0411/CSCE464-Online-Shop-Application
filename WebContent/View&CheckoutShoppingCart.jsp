<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1"/>

<title>Shopping Cart</title>

<jsp:include page="/WEB-INF/stylesheets.html" />
</head>
<body>
<%@ include file="/WEB-INF/navbar-common.jsp" %>

<div class="container">
  <h2>Shopping Cart</h2>

  <c:choose>
    <c:when test="${shoppingCart.size() == 0}">
      <h3>Your shopping cart is empty.</h3>
    </c:when>

    <c:otherwise>
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
                <div>
                  <input type="hidden" name="productId" value="${item.id}">
                  <input type="hidden" name="action" value="delete">
                  <input type="submit" class="btn btn-default remove-item" value="Delete Item">
                </div>
              </td>
            </tr>
          </c:forEach>
        <tr>
          <td colspan="7"><h3>Total: $<span id="formattedTotal"><c:out value="${formattedCartTotal}"/></span></h3></td>
        </tr>
      </table>

      <form action="CustomerTransaction.jsp" method="post">
        <input class="btn btn-primary" type="submit" value="Checkout">
      </form>
    </c:otherwise>
  </c:choose>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<script src="js/main.js"></script>
<script>
  /* TODO: Define AJAX for updating shopping cart */
  
  $(document).ready(() => {
    $('.remove-item').click(function () {
      /* Sends action, productId */
      var action = $(this).prev().val()
      var id = $(this).prev().prev().val()
      
      var dataSend = {
        action: action,
        productId: id
      }
      
      $(this).prop('disabled', true)
      
      var temp = $(this)
      
      $.post('UpdateShoppingCart', dataSend, (data, status) => {
        var result = JSON.parse(data)
        
        switch (result.success) {
          case 0:
            temp.prop('disabled', false)
            alert("We could not process your request.")
            break;
          case 1:
            $('#cartCount').text('Shopping Cart (' + result.cartTotal + ')')
            $('#formattedTotal').text(result.formattedTotal)
            temp.after('<h3>*Item Removed*</h3>')
            temp.remove()
        }
      })
    })
  })
</script>
</body>
</html>
