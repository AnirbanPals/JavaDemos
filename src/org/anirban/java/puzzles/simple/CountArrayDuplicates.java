package org.anirban.java.puzzles.simple;

import java.util.HashMap;
import java.util.Map;

public class CountArrayDuplicates {

	public static void main(String args[]) {

		int[] arr = { 10, 30, 50, 30, 30, 40, 40, 40, 40, 50, 10, 60 };

		Map<Integer, Integer> elementCountMap = new HashMap<Integer, Integer>();

		for (int num : arr) {
			if (elementCountMap.containsKey(num)) {
				elementCountMap.put(num, elementCountMap.get(num) + 1);
			} else {
				elementCountMap.put(num, 1);
			}
		}
		System.out.println(elementCountMap);
	}
}
