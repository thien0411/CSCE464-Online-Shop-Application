package model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import util.Images;

public class Product {
	private String name;
	private Integer category;
	private String sellerName;
	private Double price;
	private String thumbnail;

	private String description;
	private List<String> photos;
	private Integer availableQuantity;

	public Product() {
	}

	public Product(String name, Integer category, String sellerName, Double price, String thumbnail) {
		this.name = name;
		this.category = category;
		this.sellerName = sellerName;
		this.price = price;
		this.thumbnail = thumbnail;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCategory() {
		return category;
	}

	public void setCategory(Integer category) {
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

	public String showDetails(HttpServletRequest request) {
		/*Currently, this is hardcoded search results*/
		/*TODO: Later change to be more dynamic*/

		String photo = Images.resolveExtension(request, "img/wolves");
		StringBuilder sb = new StringBuilder();
		sb.append("<h2>Product details for <i>Cool Item</i></h2>");
		sb.append("<img src=\"");
		sb.append(photo);
		sb.append("\">");
		sb.append("<p>Price: $255.99</p>");
		sb.append("<p>Seller: RealSeller123</p>");
		sb.append("<p>Amount in Stock: 15</p>");
		sb.append("<p>Estimated Delivery: 7-10 Buisness Days</p>");
		sb.append("<h3>Description</h3>");
		sb.append("<p>This totally real and absolutely cool item is the bees knees. It's the best around! Wow!</p>");

		return sb.toString();
	}
	
	public String showCustomerQA() {
		StringBuilder sb = new StringBuilder();
		sb.append("<div class=\"entry\">");
		sb.append("<h4>- So is this product waterproof, or should I just avoid taking it in the shower?</h4>");
		sb.append("<p>Umm. You probably shouldn't do that. -<i>RealSeller123</i></p>");
		sb.append("</div>");

		return sb.toString();
	}
	
	public String showCustomerReviews() {
		return "";
	}
}
