package org.anirban.java.puzzles.simple;

import java.util.Map;
import java.util.NoSuchElementException;
import java.util.TreeMap;

public class HighestSubstring {
	public static void main(String[] args) {
		Map<Integer, String> stringMap = new TreeMap<Integer, String>();
		int i = 0;
		int n = 1;
		String str = "abcdefghJKLMNOPQRSxyz";
		str = str + 0;
		int len = str.length();
		for (i = 0, n = 1; n <= len - 1; i++, n++) {
			func(i, n, len, str, stringMap);
		}
		try {
			System.out.println(stringMap.get(((TreeMap<Integer, String>)stringMap).lastKey()));
		} catch (ClassCastException cce) {
			cce.printStackTrace();
			System.err.println("Unexpected Map type - send a sorted TreeMap");
		} catch (NoSuchElementException e) {
			System.out.println("No continuous substring found!");
		}
	}
	
	public static void func(int i, int n, int len, String str, Map<Integer, String> stringMap) {
		int z = 0;
		boolean flag1 = true;
		boolean flag2 = false;
		while (n < len) {
			// find the sub-sequence of alphabetically ordered characters
			if (str.charAt(n) - str.charAt(i) == 1) {
				flag2 = true;
				if (flag1) {
					z = i;
					flag1 = false;
				}
				n = n + 1;
				i = i + 1;
			} 
			else 
			{
				if (flag2) {
					stringMap.put(str.substring(z, n).length(), str.substring(z, n));
				}
				break;
			}
		}
	}	
}