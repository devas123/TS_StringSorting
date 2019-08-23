package com.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StringSorting {

	public static final Logger logger = Logger.getLogger(StringSorting.class.getName());

	private String original;
	Comparator<String> comparator;
	Comparator<Character> keyComparator;
	private Map<Character, ArrayList<String>> map = new TreeMap<>();

	public StringSorting() {
	}

	public StringSorting(String original, Comparator<String> arrayComparator, Comparator<Character> keyComparator) {
		this.original = original;
		this.comparator = arrayComparator;
		this.keyComparator = keyComparator;
		this.map = new TreeMap<>(keyComparator);
	}

	public Map<Character, ArrayList<String>> getMap() {
		Map<Character, ArrayList<String>> clonedMap = new HashMap<>();
		Set<Entry<Character, ArrayList<String>>> clonedEntrySet = map.entrySet();

		for (Entry<Character, ArrayList<String>> entry : clonedEntrySet) {
			clonedMap.put(entry.getKey(), new ArrayList<>(entry.getValue()));
		}

		return clonedMap;
	}

	public void parseString() {

		if (original == null || original.replaceAll("\\s+", " ").trim().isEmpty()) {
			logger.log(Level.WARNING, "String must be not null or empty");
		} else {

			original = original.replaceAll("\\s+", " ").trim();

			String[] splitResult = original.split(" ");

			for (String stringSplitResult : splitResult) {

				Character key = Character.toLowerCase(stringSplitResult.charAt(0));

				map.compute(key, (letter, array) -> {
					if (array == null) {
						array = new ArrayList<>();
					}
					array.add(stringSplitResult);
					return array;
				});

			}

			sortMap();
		}
	}

	public void print() {
		List<Character> keyList = new ArrayList<>(map.keySet());

		for (Character key : keyList) {

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

	private void sortMap() {
		Set<Character> keySet = map.keySet();

		for (Character key : keySet) {

			ArrayList<String> arrayListForSort = map.get(key);

			arrayListForSort.sort(comparator);
		}
	}
}
