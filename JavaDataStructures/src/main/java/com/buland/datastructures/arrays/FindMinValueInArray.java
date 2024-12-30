package com.buland.datastructures.arrays;

import java.util.Arrays;

public class FindMinValueInArray {

    public static void main(String[] args) {
        int[] numbers = {1,2,0,-1,-3,15};

        int minValue = findMinimumValue(numbers);
        System.out.printf("Minimum Value in Array %s is %d", Arrays.toString(numbers), minValue);

        try {
            System.out.println("\n");
            numbers = new int[0];
            minValue = findMinimumValue(numbers);
            System.out.printf("Minimum Value in Array %s is %d", Arrays.toString(numbers), minValue);
        } catch(IllegalArgumentException iae) {
            iae.printStackTrace();
        }

        try {
            System.out.println("\n");
            numbers = null;
            minValue = findMinimumValue(numbers);
            System.out.printf("Minimum Value in Array %s is %d", Arrays.toString(numbers), minValue);
        } catch(IllegalArgumentException iae) {
            iae.printStackTrace();
        }

    }

    /**
     * Algorithm details.
     * 1. if incoming array is null or empty retunr some arbitraty number, in our case we use -010
     * 2. Assign minValue variable to the value of 1st index (minValue = numbers[0])
     * 3. loop through starting with the 2nd index till teh end of array length
     * 4. if minValue >= to numbers[index] than minvalue = numbers[index]
     * 5. go back to #3 and repeat till the end of array length
     *
     * complexity is O(n) as we scan the whole array once n times.
     *
     * @param numbers
     * @return
     */
    private static int findMinimumValue(int[] numbers) {
        int minValue = 0;
        int lastIndex = -1;

        if ( numbers == null || numbers.length==0) {
            throw new IllegalArgumentException("Incoming Array is " + ( numbers == null ? "null" : "empty"));
        }

        minValue = numbers[0];
        for (int i=1; i<numbers.length; i++) {
            if ( minValue >= numbers[i]) {
                minValue = numbers[i];
                lastIndex = i;
            }
        }

        System.out.printf("\nIndex of Last Min Value is %d\n",lastIndex);
        return minValue;
    }
}
