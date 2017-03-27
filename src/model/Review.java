package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Review {
	private Users customer;
	private Date date;
	private Integer rating;
	private String review;
	
	Review (Users customer, Date date, Integer rating, String review) {
		this.customer = customer;
		this.date = date;
		this.rating = rating;
		this.review = review;
	}
	
	Review (Users customer, String date, int rating, String review) {
		this.customer = customer;
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		try {
			this.date = formatter.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		this.rating = rating;
		this.review = review;
	}

	public Users getCustomer() {
		return customer;
	}

	public void setCustomer(Users customer) {
		this.customer = customer;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}
	
	public String formattedDate () {
		SimpleDateFormat formatter = new SimpleDateFormat("EEEEEEEEE, MMMMMMMM dd, yyyy");
		return formatter.format(this.date);
	}
	
	public static String stars (Integer stars) {
		if (stars > 5) stars = 5;
		if (stars < 0) stars = 0;

		StringBuilder sb = new StringBuilder();

		/* Put in filled stars */
		for(int i = 0; i < stars; i++) {
			sb.append("<span class=\"glyphicon glyphicon-star\" aria-hidden=\"true\"></span>");
		}

		/*Give the rest of the stars, if not 5 out of 5 */
		for(int i = 0; i < 5 - stars; i++) {
			sb.append("<span class=\"glyphicon glyphicon-star-empty\" aria-hidden=\"true\"></span>");
		}

		return sb.toString();
	}
	
	public String stars () {
		return Review.stars(this.rating);
	}
	
	public static boolean addReview (Users customer, Integer productId, String customerReview, Integer rating) {
		// TODO: Add review to database
		return false;
	}
}
