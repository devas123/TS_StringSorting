package com.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StringSortingV2 {

	public static final Logger logger = Logger.getLogger(StringSortingV2.class.getName());

	public StringSortingV2() {
	}

	public Map<Character, List<String>> parseString(String original, Comparator<Character> keyComparator) {

		Map<Character, List<String>> map = new TreeMap<>(keyComparator);

		if (original == null || original.replaceAll("\\s+", " ").trim().isEmpty()) {
			logger.log(Level.WARNING, "String must be not null or empty");
		} else {

			String[] splitResult = parse(original);

			fillMap(map, splitResult);
		}

		return map;
	}

	public Map<Character, List<String>> sortingMap(Map<Character, List<String>> origineMap,
			Comparator<String> arrayComparator) {

		Map<Character, List<String>> clonedMap = new TreeMap<>();
		Set<Entry<Character, List<String>>> clonedEntrySet = origineMap.entrySet();

		for (Entry<Character, List<String>> entry : clonedEntrySet) {
			clonedMap.put(entry.getKey(), new ArrayList<>(entry.getValue()));
		}

		sortMap(clonedMap, arrayComparator);

		return clonedMap;
	}

	public void printMap(Map<Character, List<String>> map) {

		List<Character> keyList = new ArrayList<>(map.keySet());

		for (Character key : keyList) {

			List<String> arrayList = map.get(key);

			if (arrayList.size() > 1) {

				System.out.print("Key " + key + " :");

				for (String arrayElement : arrayList) {
					System.out.print(" " + arrayElement);
				}

				System.out.println();
			}
		}

	}

	private void fillMap(Map<Character, List<String>> map, String[] splitResult) {
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
	}

	private String[] parse(String original) {
		original = original.replaceAll("\\s+", " ").trim();

		return original.split(" ");
	}

	private void sortMap(Map<Character, List<String>> map, Comparator<String> comparator) {
		Set<Character> keySet = map.keySet();

		for (Character key : keySet) {

			List<String> arrayListForSort = map.get(key);

			arrayListForSort.sort(comparator);
		}
	}
}
