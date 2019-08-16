package com.example;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Application {

//	public static String STR = "Privet prekrasny novyy nadezhniy mir mart kak aprel asia";
//	public static String STR = null;
	public static String STR = "asdasd bsd bsdf bs";


	//FIXME: нет сортировки групп
	//fixme: fails on null
	//fixme: как писать тесты для такого класса?
	//fixme: side effects
	//fixme: encoding??
	public static void main(String[] args) {
		StringSorting stringSorting = new StringSorting(STR);
		stringSorting.printResult();
//		stringSorting.printResult();
//		stringSorting.printResult();
	}
}
