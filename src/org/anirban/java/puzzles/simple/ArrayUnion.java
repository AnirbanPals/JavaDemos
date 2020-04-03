package org.anirban.java.puzzles.simple;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ArrayUnion {

	public static void main(String[] args) {

		List<String> al1 = new ArrayList<>();
		al1.add("A");
		al1.add("B");
		al1.add("C");
		al1.add("F");
		al1.add("G");
		al1.add("N");
		al1.add("O");		
		al1.add("S");
		al1.add("T");
		al1.add("T");
		
		List<String> al2 = new ArrayList<>();
		al2.add("A");
		al2.add("B");
		al2.add("C");
		al2.add("D");
		al2.add("E");
		al2.add("F");
		al2.add("P");
		al2.add("Q");
		al2.add("R");
		al2.add("S");
		al2.add("T");
		al2.add("Z");
		al2.add("A");
		al2.add("B");
		al2.add("c");
		al2.add("n");
		al2.add("E");
		al2.add("F");

		Set<String> uniqueList = new HashSet<String>(al1); 
		List<String> al3 = new ArrayList<>(uniqueList.size());
		al3.addAll(uniqueList);
		
		Iterator<String> i = uniqueList.iterator();

		while (i.hasNext()) {
			String str = i.next();
			for (int j = 0; j < al2.size(); j++) {
				if ((str.equals(al2.get(j)))) {
					al2.remove(j);
				}
			}
		}
		al3.addAll(al2.subList(0, al2.size()));
		System.out.println(al1 + " UNION " + al2);
		System.out.println(al3);
	}
}