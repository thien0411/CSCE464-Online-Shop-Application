package model;

import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.List;

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
	private List<QuestionAnswer> qaList;
	
	private Integer quantityRequested;
	
	private Boolean isShipped;

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

	public List<QuestionAnswer> getQaList() {
		return qaList;
	}

	public void setQaList(List<QuestionAnswer> qaList) {
		this.qaList = qaList;
	}

	public Integer getQuantityRequested() {
		return quantityRequested;
	}

	public void setQuantityRequested(Integer quantityRequested) {
		this.quantityRequested = quantityRequested;
	}

	public Boolean getIsShipped() {
		return isShipped;
	}

	public void setIsShipped(Boolean isShipped) {
		this.isShipped = isShipped;
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
	
	public String formattedPrice () {
		DecimalFormat df = new DecimalFormat(".##");
		return df.format(this.price);
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
	
	public boolean validQuantity () {
		return this.quantityRequested <= this.availableQuantity;
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

	public void dbGetQA () {
		Database db = new Database();
		db.connect();

		this.qaList = db.getQAByProductId(this.id);

		db.close();
	}
}
