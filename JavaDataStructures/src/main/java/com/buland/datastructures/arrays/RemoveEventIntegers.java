package com.buland.datastructures.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveEventIntegers {

    public static void main(String[] args) {
        int[] arrayWithOddAndEvenNums = {1,2,3,4,5,6,7,8,9,10};

        int[] arrayWithOddNums = getOddNumsOption1(arrayWithOddAndEvenNums);
        System.out.printf("Option1: Array With Odd Nums: %s \n", Arrays.toString(arrayWithOddNums));

        arrayWithOddNums = getOddNumsOption2(arrayWithOddAndEvenNums);
        System.out.printf("Option2: Array With Odd Nums: %s \n", Arrays.toString(arrayWithOddNums));

        List<Integer> arrayWithOddNumsList = getOddNumsOption3(arrayWithOddAndEvenNums);
        System.out.printf("Option3: Array With Odd Nums: %s \n", arrayWithOddNumsList);

    }

    private static int[] getOddNumsOption1(int[] arrayWithOddAndEvenNums) {
        int oddNumCount = 0;
        for (int i=0; i<arrayWithOddAndEvenNums.length; i++) {
            if (arrayWithOddAndEvenNums[i] % 2 != 0 ) oddNumCount++; //if num mod 2 != 0, its an odd num
        }

        int[] arrayWithOddNums = new int[oddNumCount];
        for (int i=0, j=0; i<arrayWithOddAndEvenNums.length; i++) {
            if (arrayWithOddAndEvenNums[i] % 2 != 0 ) {
                arrayWithOddNums[j] = arrayWithOddAndEvenNums[i]; //if num mod 2 != 0, its an odd num
                j++;
            }
        }
        return arrayWithOddNums;
    }


    private static int[] getOddNumsOption2(int[] arrayWithOddAndEvenNums) {

        List<Integer> arrayWithOddNums = new ArrayList<Integer>();
        for (int i=0; i<arrayWithOddAndEvenNums.length; i++) {
            if (arrayWithOddAndEvenNums[i] % 2 != 0 ) {
                arrayWithOddNums.add(arrayWithOddAndEvenNums[i]); //if num mod 2 != 0, its an odd num
            }
        }

        /**
         * What it does is:
         *
         *     getting a Stream<Integer> from the list
         *     obtaining an IntStream by mapping each element to itself (identity function), unboxing the int value hold by each Integer object (done automatically since Java 5)
         *     getting the array of int by calling toArray
         *
         * You could also explicitly call intValue via a method reference, i.e:
         * int[] arr = list.stream().mapToInt(Integer::intValue).toArray();
         */
        return arrayWithOddNums.stream().mapToInt(i -> i).toArray();
    }


    private static List<Integer> getOddNumsOption3(int[] arrayWithOddAndEvenNums) {

        List<Integer> arrayWithOddNums = new ArrayList<Integer>();
        for (int i=0; i<arrayWithOddAndEvenNums.length; i++) {
            if (arrayWithOddAndEvenNums[i] % 2 != 0 ) {
                arrayWithOddNums.add(arrayWithOddAndEvenNums[i]); //if num mod 2 != 0, its an odd num
            }
        }

        return arrayWithOddNums;
    }

}
