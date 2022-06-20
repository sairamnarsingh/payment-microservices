package com.example.demo.util;

public class RandomNoGenerator {

	public static String idGen() {
		String hexString = Long.toHexString(Double.doubleToLongBits(Math.random()));
		return hexString;
	}
}
