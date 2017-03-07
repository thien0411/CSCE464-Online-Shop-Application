package util;

public class ShippingRefNoGenerator {
	private static Integer range = 500000;
	
	public static Integer generateRandom() {
		return (int) Math.floor(range * Math.random());
	}
}
