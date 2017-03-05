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
	
	private List<Review> reviews;

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

	/* Getters/Setters */
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

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	/* Methods */
	public static List<Product> productSearch (String productQuery) {
		List<Product> productList = new LinkedList<Product>();
		Database db = new Database();
		db.connect();
		db.getProducts(productList, productQuery);
		db.close();
		return productList;
	}

	public String showCustomerQA() {
		StringBuilder sb = new StringBuilder();
		sb.append("<tr><td>");
		sb.append("<h4>- So is this product waterproof, or should I just avoid taking it in the shower?</h4>");
		sb.append("<p>Umm. You probably shouldn't do that. -<i>RealSeller123</i></p>");
		sb.append("</td></tr>");

		return sb.toString();
	}
	
	public String averageStars () {
		int size = this.reviews.size();
		int total = 0;
		int averageReview = 0;
		
		for (int i = 0; i < size; i++) {
			total += this.reviews.get(i).getRating();
		}
		
		if (size > 0) averageReview = total/size;
		
		return Review.stars(averageReview);
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
	
	public void dbGetReviews () {
		Database db = new Database();
		db.connect();
		
		this.reviews = db.getReviewsByProductId(this.id);
		
		db.close();
	}
}
