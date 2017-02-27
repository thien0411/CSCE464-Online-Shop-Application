package model;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import util.Images;

public class Product {
	private Integer id;
	private String name;
	private String category;
	private String sellerName;
	private Double price;
	private String thumbnail;

	private Integer estimatedDeliveryDays;
	private String description;
	private List<String> photos;
	private Integer availableQuantity;

	public Product () {
	}

	public Product (String name, String category, String sellerName, Double price, String thumbnail) {
		this.name = name;
		this.category = category;
		this.sellerName = sellerName;
		this.price = price;
		this.thumbnail = thumbnail;
	}
	
	public Product (String name, String sellerName, Double price, Integer estDeliveryDays, List<String> photos,
			String description) {
		this.name = name;
		this.sellerName = sellerName;
		this.price = price;
		this.estimatedDeliveryDays = estDeliveryDays;
		this.photos = photos;
		this.description = description;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public Integer getEstimatedDeliveryDays() {
		return estimatedDeliveryDays;
	}

	public void setEstimatedDeliveryDays(Integer estimatedDeliveryDays) {
		this.estimatedDeliveryDays = estimatedDeliveryDays;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<String> getPhotos() {
		return photos;
	}

	public void setPhotos(List<String> photos) {
		this.photos = photos;
	}

	public Integer getAvailableQuantity() {
		return availableQuantity;
	}

	public void setAvailableQuantity(Integer availableQuantity) {
		this.availableQuantity = availableQuantity;
	}

	public String showResults(HttpServletRequest request) {
		/*Currently, this is hardcoded search results*/
		/*TODO: Later change to be more dynamic*/

		/* The table is formatted in this order
		 * Thumbnail
		 * Name
		 * Category
		 * Seller Name
		 * Price
		 * -Blank- (for the View Product button)*/

		String thumbnail = Images.resolveExtension(request, "img/wolves");
		String productDetails = "<input type=\"hidden\" name=\"productCode\" value=\"coolItem\">\n"
				+ "<input type=\"submit\" class=\"btn btn-default\" value=\"View Product Details\">";

		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < 10; i++) {
			sb.append("<tr>");
			sb.append("<td><img src=\"");
			sb.append(thumbnail);
			sb.append("\"></td>");
			sb.append("<td>Totally Real Product " + (i+1) + "</td>");
			sb.append("<td>1</td>");
			sb.append("<td>RealSeller123</td>");
			sb.append("<td>$15.25</td>");
			sb.append("<td><form action=\"ViewProductDetails.jsp\">");
			sb.append(productDetails);
			sb.append("</form></td>");
			sb.append("</tr>\n");
		}

		return sb.toString();
	}

	public static List<Product> productSearch (String productQuery) {
		List<Product> productList = new LinkedList<Product>();
		Database db = new Database();
		db.connect();
		db.getProducts(productList, productQuery);
		db.close();
		return productList;
	}

	public String showDetails(HttpServletRequest request) {
		/*Currently, this is hardcoded search results*/
		/*TODO: Later change to be more dynamic*/

		String photo = Images.resolveExtension(request, "img/wolves");
		StringBuilder sb = new StringBuilder();
		sb.append("<h2>Product details for <i>Cool Item</i></h2>");

		sb.append("<div class=\"col-sm-4 col-md-5\">");
		sb.append("<img src=\"");
		sb.append(photo);
		sb.append("\">");
		sb.append("</div>");

		sb.append("<div class=\"col-sm-8 col-md-7\">");
		sb.append("<p>Price: $15.25</p>");
		sb.append("<p>Seller: RealSeller123</p>");
		sb.append("<p>Amount in Stock: 15</p>");
		sb.append("<p>Estimated Delivery: 7-10 Buisness Days</p>");
		sb.append("<h3>Description</h3>");
		sb.append("<p>This totally real and absolutely cool item is the bees knees. It's the best around! Wow!</p>");
		sb.append("<form action=\"View&CheckoutShoppingCart.jsp\"><input class=\"btn btn-primary\" type=\"submit\" value=\"Add To Cart\"\"></form>");
		sb.append("</div>");

		return sb.toString();
	}

	public String showCustomerQA() {
		StringBuilder sb = new StringBuilder();
		sb.append("<tr><td>");
		sb.append("<h4>- So is this product waterproof, or should I just avoid taking it in the shower?</h4>");
		sb.append("<p>Umm. You probably shouldn't do that. -<i>RealSeller123</i></p>");
		sb.append("</td></tr>");

		return sb.toString();
	}

	public String showRating(Integer stars) {
		if (stars > 5 || stars < 0) {
			return "?";
		}

		StringBuilder sb = new StringBuilder();
		sb.append("<div class=\"rating\">");

		/* Put in filled stars */
		for(int i = 0; i < stars; i++) {
			sb.append("<span class=\"glyphicon glyphicon-star\" aria-hidden=\"true\"></span>");
		}

		/*Give the rest of the stars, if not 5 out of 5 */
		for(int i = 0; i < 5 - stars; i++) {
			sb.append("<span class=\"glyphicon glyphicon-star-empty\" aria-hidden=\"true\"></span>");
		}

		sb.append("</div>");

		return sb.toString();
	}

	public String showCustomerReviews() {
		StringBuilder sb = new StringBuilder();

		sb.append("<tr><th>");
		sb.append("<h4>Overall Rating</h4>");
		sb.append(showRating(4));
		sb.append("</th></tr>");

		sb.append("<tr><td>");
		sb.append("<h4>I love this product so much!</h4>");
		sb.append(showRating(5));
		sb.append("<p>This product fills me with so much joy. The next sentence describes my admiration for this.</p>");
		sb.append("<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>");
		sb.append("</td></tr>");

		sb.append("<tr><td>");
		sb.append("<h4>This is adequate</h4>");
		sb.append(showRating(3));
		sb.append("<p>Not the coolest. Not the worst.</p>");
		sb.append("</td></tr>");

		return sb.toString();
	}

	public String showShoppingCart(HttpServletRequest request) {
		/*
		 * Thumbnail
		 * Name
		 * Seller Name
		 * Quantity
		 * Total Price
		 * Delivery Date
		 * (Empty) for buttons*/

		String thumbnail = Images.resolveExtension(request, "img/wolves");

		StringBuilder sb = new StringBuilder();

		for(int i = 0; i < 3; i++) {
			sb.append("<tr>");
			sb.append("<td><img src=\"");
			sb.append(thumbnail);
			sb.append("\"></td>");
			sb.append("<td>Totally Real Product " + (i+1) + "</td>");
			sb.append("<td>RealSeller123</td>");
			sb.append("<td>1</td>");
			sb.append("<td>$15.25</td>");
			sb.append("<td>7 to 10 buisness days</td>");
			sb.append("<td><button class=\"btn btn-default\">Delete Item</button></td>");
			sb.append("</tr>\n");
		}

		return sb.toString();
	}
	
	public String showTransaction() {
		/*
		 * Name
		 * Seller Name
		 * Quantity
		 * Total Price*/

		StringBuilder sb = new StringBuilder();

		for(int i = 0; i < 3; i++) {
			sb.append("<tr>");
			sb.append("<td>Totally Real Product " + (i+1) + "</td>");
			sb.append("<td>RealSeller123</td>");
			sb.append("<td>1</td>");
			sb.append("<td>$15.25</td>");
			sb.append("</tr>\n");
		}

		return sb.toString();
	}


	public static Product getProduct(int productId) {
		Product p = null;

		Database db = new Database();
		db.connect();
		
		p = db.getProductById(productId);
		
		db.close();
		return p;
	}
}
