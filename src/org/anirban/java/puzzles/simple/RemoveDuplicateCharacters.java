package org.anirban.java.puzzles.simple;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class RemoveDuplicateCharacters {
	
	public static void main(String[] args) {
		String x = "SILLYSPIDERS ARE NOT REALLY SILLY. But they are.";
		char[] y = x.toCharArray();
		int size = y.length;

		Map<Character, Integer> map = new LinkedHashMap<>();

		int i = 0;
		while (i != size) {
			if (map.containsKey(y[i]) == false) {
				map.put(y[i], 1);
			} else {
				/*
				 * int oldVal = map.get(y[i]); int newVal = oldVal + 1; map.put(y[i], newVal);
				 */
				map.put( y[i], map.get(y[i])+1 );
			}
			++i;
		}
		System.out.println(map);

		String res = "";
		Set<Map.Entry<Character, Integer>> lhmap = map.entrySet();

		for (Map.Entry<Character, Integer> data : lhmap) {
			res = res + data.getKey();
		}
		System.out.println(res);
	}
}