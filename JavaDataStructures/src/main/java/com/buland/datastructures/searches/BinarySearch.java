package com.buland.datastructures.searches;

public class BinarySearch {
	
	    /**
	     * Performs binary search on a sorted array.
	     * 
	     * @param arr the sorted array
	     * @param key the value to search for
	     * @return the index of the key if found, otherwise -1
	     */
	    public static int binarySearch(int[] arr, int key) {
	        int low = 0;
	        int high = arr.length - 1;
	
	        while (low <= high) {
	            int mid = low + (high - low) / 2; // Prevent overflow
	
	            if (arr[mid] == key) {
	                return mid; // Key found
	            }
	            if (arr[mid] < key) {
	                low = mid + 1; // Search in the right half
	            } else {
	                high = mid - 1; // Search in the left half
	            }
	        }
	
	        return -1; // Key not found
	    }
	
	    public static void main(String[] args) {
	        int[] sortedArray = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
	        int key = 7;
	
	        int result = binarySearch(sortedArray, key);
	        if (result != -1) {
	            System.out.println("Element found at index: " + result);
	        } else {
	            System.out.println("Element not found in the array.");
	        }
	    }
}