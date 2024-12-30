package com.buland.datastructures.linkedlist;

import java.util.LinkedHashSet;
	import java.util.Set;
	
	public class RemoveDuplicates {
	    public static String removeDuplicates(String str) {
	        // Create a LinkedHashSet to store characters of the string
	        Set<Character> set = new LinkedHashSet<>();
	        // Convert the string to a character array
	        char[] chars = str.toCharArray();
	        // Add each character to the set
	        for (char c : chars) {
	            set.add(c);
	        }
	        // Build the result string from the set
	        StringBuilder sb = new StringBuilder();
	        for (char c : set) {
	            sb.append(c);
	        }
	        return sb.toString();
	    }
	
	    public static void main(String[] args) {
	        String input = "programming";
	        String result = removeDuplicates(input);
	        System.out.println("Original string: " + input);
	        System.out.println("String after removing duplicates: " + result);
	    }
	}
