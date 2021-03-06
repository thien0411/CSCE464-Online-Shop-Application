package model;

public class QuestionAnswer {
	private Users customer;
	private String question;
	private String answer;
	
	QuestionAnswer () {
	}
	
	QuestionAnswer (Users customer, String question, String answer) {
		this.customer = customer;
		this.question = question;
		this.answer = answer;
	}

	public Users getCustomer() {
		return customer;
	}

	public void setCustomer(Users customer) {
		this.customer = customer;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	public static boolean addQuestion (Integer productId, Users customer, String question) {
		boolean sent;
		
		Database db = new Database();
		db.connect();
		
		sent = db.addQuestion(productId, customer.getId(), question);
		
		db.close();
		return sent;
	}
}
