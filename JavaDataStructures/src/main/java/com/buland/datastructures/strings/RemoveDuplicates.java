package com.buland.datastructures.strings;

import java.util.LinkedHashSet;
	import java.util.Set;
	
	public class RemoveDuplicates {

		public static void main(String[] args) {
			String input = "programming";
			String result = removeDuplicates(input);
			System.out.printf("\nOriginal string: %s , String after removing duplicates: %s", input, result);

			input = "Allegator";
			result = removeDuplicates(input);
			System.out.printf("\nOriginal string: %s , String after removing duplicates: %s", input, result);

			input = "Buland";
			result = removeDuplicates(input);
			System.out.printf("\nOriginal string: %s , String after removing duplicates: %s", input, result);

			input = "dBuland";
			result = removeDuplicates(input);
			System.out.printf("\nOriginal string: %s , String after removing duplicates: %s", input, result);
		}


		/**
		 * Algorithm is as follow.
		 * 1. Convert input string into char array
		 * 2. create previousChar var as well as StringBudiler var 'removedDuplicatesStr' to store character into new sting that will be without duplicates
		 * 3. loop through the char array
		 * 4. if (previoudChar == loop through char) continue; (its a duplicate)
		 * @param str
		 * @return
		 */
	    public static String removeDuplicates(String str) {
	        // Create a LinkedHashSet to store characters of the string
	        char[] charArray = str.toCharArray(); //time complexity O(n)
			
	        // Add each character to the set
			char previousChar = 0;
			StringBuilder removedDuplicatesStr = new StringBuilder();
	        for (char c : charArray) {
	            if ( previousChar == c || removedDuplicatesStr.indexOf(String.valueOf(c))!=-1 ) continue;
				else {
					previousChar = c;
					removedDuplicatesStr.append(c);
				}
	        }//time complexity = O(n)

	        // Build the result string from the set
	        return removedDuplicatesStr.toString();
	    }
	
	}
