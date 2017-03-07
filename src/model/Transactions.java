package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Transactions {
	private String firstName;
	private String lastName;
	private String cardType;
	private String cardNumber;
	private String securityCode;
	private String expireMonth;
	private String billingAddress;
	private String shippingAddress;

	public Transactions() {
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getSecurityCode() {
		return securityCode;
	}

	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}

	public String getExpireMonth() {
		return expireMonth;
	}

	public void setExpireMonth(String expireMonth) {
		this.expireMonth = expireMonth;
	}

	public String getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public boolean validData () {
		boolean isValid = true;

		if (this.cardNumber == null || this.cardNumber.trim().equals("") || this.cardNumber.length() != 16)
			isValid = false;

		if (this.securityCode == null || this.securityCode.trim().equals("")) {
			if (!(this.securityCode.trim().length() == 3 || this.securityCode.trim().length() == 4))
				isValid = false;
		}

		if (this.firstName == null || this.firstName.trim().equals("")) isValid = false;
		if (this.lastName == null || this.lastName.trim().equals("")) isValid = false;
		if (this.cardType == null || this.cardType.trim().equals("")) isValid = false;
		if (this.expireMonth == null || this.expireMonth.trim().equals("")) isValid = false;
		if (this.billingAddress == null || this.billingAddress.trim().equals("")) isValid = false;
		if (this.shippingAddress == null || this.shippingAddress.trim().equals("")) isValid = false;

		return isValid;
	}

	public boolean sufficientFunds () {
		boolean hasFunds = true;

		return hasFunds;
	}

	public Orders createOrder() {
		Orders order = new Orders();

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String orderDate = formatter.format(date);

		order.setOrderDate(orderDate);
		order.setBillingAddress(this.billingAddress);
		order.setShippingAddress(this.shippingAddress);
		order.setCreditCardNumber(this.cardNumber);

		return order;
	}
}
