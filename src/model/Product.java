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

	public Product(String name, Integer category, String sellerName, Double price, String thumbnail) {
		this.name = name;
		this.category = category;
		this.sellerName = sellerName;
		this.price = price;
		this.thumbnail = thumbnail;
	}

}
