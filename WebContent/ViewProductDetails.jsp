<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1"/>

<title>Product Details - <c:out value="${product.name}"/></title>

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
  <div class="back">
    <form action="ProductSearchQuery" method="post">
      <input type="hidden" name="searchQuery" value="${query}">
      <input class="btn btn-default" type="submit" value="&lt; Back">
    </form>
  </div>
  <div class="product-details row">
    <h2>Product Details for <i><c:out value="${product.name}"/></i></h2>

    <div class="col-sm-4 col-md-5">
      <img src="${product.photos[0]}">
    </div>

    <div class="col-sm-8 col-md-7">
      <p>Price: $${product.formattedPrice()}</p>
      <p>Seller: ${product.sellerName}</p>
      <p>Amount in Stock: ${product.availableQuantity}</p>
      <p>Estimated Delivery Time: ${product.estimatedDeliveryDays} Days</p>

      <h3>Description</h3>
      <p>${product.description}</p>

      <form action="UpdateShoppingCart" method="post">
        <input type="hidden" id="productId" name="productId" value="${product.id}">
        <input type="hidden" name="action" value="add">

        Quantity:
        <input type="number" name="quantity" id="quantity" min="0" max="${product.availableQuantity}">
        <br />
        <button type="button" class="btn btn-primary" id="add-product">Add To Cart</button>
      </form>
    </div>
  </div>

  <div class="customer-QA">
    <h3>Customer Q and A</h3>
    <table class="table">
      <c:forEach var="qa" items="${product.qaList}">
        <tr>
          <td>
            <h4>
              <i>"<c:out value="${qa.question}"/>"</i>
              -
              <c:out value="${qa.customer.userName}" />
            </h4>

            <p>
              "<c:out value="${qa.answer}"/>"
              -
              <i><c:out value="${product.sellerName}"/></i>
            </p>
          </td>
        </tr>
      </c:forEach>
      <tr>
        <td>
          <h4>Ask a Question!</h4>

          <div>
            <textarea id="question" rows="5" cols="60"></textarea>
          </div>

          <button class="btn btn-primary" type="button" id="submit-question">Submit Question</button>
        </td>
      </tr>
    </table>
  </div>

  <div class="customer-review">
    <h3>Reviews</h3>

    <table class="table">
      <tr>
        <td>
          <h4>Overall Rating</h4>

          <div class="rating">
            <c:out value="${product.averageStars()}" escapeXml="false"/>
          </div>
        </td>
      </tr>

      <c:forEach var="review" items="${product.reviews}">
        <tr>
          <td>
            <h4><c:out value="${review.customer.userName}"/></h4>
            <p><c:out value="${review.formattedDate()}"/></p>

            <div class="rating">
              <c:out value="${review.stars()}" escapeXml="false"/>
            </div>

            <p><c:out value="${review.review}"/></p>
          </td>
        </tr>
      </c:forEach>
      <tr>
        <td>
          <h4>Submit a Review!</h4>

          <div>
            <h5>Star Rating (Out of 5)</h5>
            <input type="number" id="rating" min="0" max="5" value="5">
          </div>

          <div>
            <h5>Review</h5>
            <textarea id="review" rows="5" cols="60" placeholder="Review"></textarea>
          </div>

          <button class="btn btn-primary" type="button" id="submit-review">Submit Review</button>
        </td>
      </tr>
    </table>
  </div>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<script src="js/main.js"></script>

<script>
  $(document).ready(() => {
    $('#submit-review').click(() => {
      /* Sends productId, review, and rating (out of 5) */
      var id = $('#productId').val()
      var review = $('#review').val()
      var rating = $('#rating').val()

      if (review == null || review.trim() == '') {
        alert('Error: Please write your review before submitting!')
        return
      }

      var dataSend = {
        productId: id,
        review: review,
        rating: rating
      }

      $.post('CustomerReviews', dataSend, (data, status) => {
        if (data == 0) {
          alert('We could not process your review.')
        } else {
          /* Success! Refresh the page */
          location.reload(true)
        }
      })
    })

    $('#submit-question').click(() => {
      /* Sends productId and question */
      var id = $('#productId').val()
      var question = $('#question').val()

      if (question == null || question.trim() == '') {
        alert('Error: Please write your question before submitting!')
        return
      }

      var dataSend = {
        productId: id,
        question: question
      }

      $.post('CustomerQA', dataSend, (data, status) => {
        if (data == 0) {
          alert('We could not process your question.')
        } else {
          /* Success! Refresh the page */
          location.reload(true)
        }
      })
    })

    $('#add-product').click(() => {
      /* Sends productId, quantity, action ('add') */

      // TODO: Define this function
    })
  })
</script>
</body>
</html>
