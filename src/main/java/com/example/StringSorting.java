package com.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StringSorting {

	public static Logger logger = Logger.getLogger(StringSorting.class.getName());

	private String original;
	private ArrayList<String> array;
	private Map<Character, ArrayList<String>> map = new HashMap<>();

	public StringSorting() {
	}

	public StringSorting(String original) {
		this.original = original;
	}

	private void parseString() {
		String[] splitResult = original.split(" ");

		for (String stringSplitResult : splitResult) {
			Character key = null;

			try {
				key = Character.toLowerCase(stringSplitResult.charAt(0));
			} catch (StringIndexOutOfBoundsException e) {
				logger.log(Level.WARNING, "String must be not empty");
			}

			ArrayList<String> arrayListByKey = map.get(key);

			if (arrayListByKey != null) {
				arrayListByKey.add(stringSplitResult);
			} else {
				arrayListByKey = new ArrayList<>();
				arrayListByKey.add(stringSplitResult);
				map.put(key, arrayListByKey);
			}
//			
		}
	}

	private void sortMap() {
		Set<Character> keySet = map.keySet();

		for (Character key : keySet) {

			ArrayList<String> arrayListForSort = map.get(key);

			arrayListForSort.sort(new DefaultComparator());

			map.put(key, arrayListForSort);
		}

	}

	public void printResult() {

		parseString();

		sortMap();

		Set<Character> keySet = map.keySet();

		for (Character key : keySet) {

			ArrayList<String> arrayList = map.get(key);

			if (arrayList.size() > 1) {
				System.out.print("Key " + key + " :");
				for (String arrayElement : arrayList) {
					System.out.print(" " + arrayElement);
				}

				System.out.println();
			}
		}
	}
}
