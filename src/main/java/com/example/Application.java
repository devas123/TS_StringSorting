package com.example;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class Application {

	public static String STR = "Privet prekrasny novyy nadezhniy mir mart kak aprel asia";
//	public static String STR = null;
//	public static String STR = "";
//	public static String STR = "    ";
//	public static String STR = "asdasd bsd bsdf bs";
//	public static String STR = "  Привет прекрасный Привет новый мой мир мой   ангел анапа жетон   ";

	// FIXME: нет сортировки групп
	// fixme: fails on null
	// fixme: как писать тесты для такого класса?
	// fixme: side effects
	// fixme: encoding??
	public static void main(String[] args) {

		Comparator<String> arrayComparator = new DefaultComparator();
		Comparator<Character> keyComparator = new CharComparator();
		StringSorting stringSorting = new StringSorting(STR, arrayComparator, (o1, o2) -> {
			return o1.compareTo(o2);
		});
		stringSorting.parseString();
//		stringSorting.print();

		StringSortingV2 stringSortingV2 = new StringSortingV2();
		Map<Character, List<String>> resultMap = stringSortingV2.parseString(STR, (o1, o2) -> {
			return o1.compareTo(o2);
		});

		Map<Character, List<String>> sortedMap = stringSortingV2.sortingMap(resultMap, arrayComparator);
		
		stringSortingV2.printMap(sortedMap);
		stringSortingV2.printMap(sortedMap);
	}
}
