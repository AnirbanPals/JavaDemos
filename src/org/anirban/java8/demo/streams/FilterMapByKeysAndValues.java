package org.anirban.java8.demo.streams;

import java.util.HashMap;
import java.util.Map;

public class FilterMapByKeysAndValues {

	    public static void main(String[] args) {

	        Map<String, String> hmap = new HashMap<>();
	        
	        hmap.put("in", "INDIA");
	        hmap.put("uK", "United Kingdom");
	        hmap.put("nz", "New Zealand");
	        hmap.put("sl", "Srilanka");
	        hmap.put("bs", "Bahamas");
	        hmap.put("ro", "Romania");
	        hmap.put("de", "Germany");
	        hmap.put("hu", "Hungary");
	        hmap.put("sk", "Slovakia");
	        hmap.put("si", "Slovenia");
	        hmap.put("so", "Somalia");
	        hmap.put("us", "United States");
	        hmap.put("ru", "Russia");
	        
	        hmap.entrySet().stream().filter(map -> map.getKey().startsWith("s"))
	                .forEach(m -> System.out.println(m));
	        
	        hmap.entrySet().stream().filter(map -> map.getValue().equals("Slovakia")
	                || map.getValue().equals("Slovenia"))
	                .forEach(m -> System.out.println(m));	        
	    }
	}