package model;

import java.util.List;

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
		this.name = "";
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

	public String showResults() {
		/*Currently, this is hardcoded search results*/
		StringBuffer sb = new StringBuffer();

		/* The table is formatted in this order
		 * Thumbnail
		 * Name
		 * Category
		 * Seller Name
		 * Price */
		
		for(int i = 0; i < 10; i++) {
			sb.append("<tr>");
			sb.append("<td><img src=\"\"></td>");
			sb.append("<td>Totally Real Product " + (i+1) + "</td>");
			sb.append("<td>1</td>");
			sb.append("<td>RealSeller123</td>");
			sb.append("<td>$15.25</td>");
			sb.append("</tr>\n");
		}

		return sb.toString();
	}
}
