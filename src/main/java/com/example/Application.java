package com.example;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Application {
//	public static String STR = "Привет мой прекрасный мир";
//	public static String STR = "";
//	public static String STR = "Привет привет мой прекрасный ангел мир";
	public static String STR = "Прювет Привет мой прекрасный мир ангел Амани";
//	public static String STR = "Привет Прювет мой прекрасный мир";
//	public static String STR = "Привет мой прекрасный мир";

	public static void main(String[] args) {
		StringSorting stringSorting = new StringSorting(STR);
		stringSorting.printResult();

	}
}
