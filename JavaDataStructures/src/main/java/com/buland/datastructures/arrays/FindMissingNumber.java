package com.buland.datastructures.arrays;

import java.util.Arrays;

/**
 * Q: Given an array of n-1 distinct numbers in the range of 1 to n. Find the missing number in it.
 *
 * Example:
 * Input Array: [2,4,1,8,6,3,7]
 * Output: 5
 * Explination: The missing # from range 1-8 is 5.
 */
public class FindMissingNumber {

    public static void main(String[] args) {
        int []numbers = {3, 2, 6, 3, 1, 4, 8, 7};

        int missingNumber = findMissingNumberOption1ForNotDistinctNumbers(numbers);
        System.out.printf("\nMissing Number is %d\n",missingNumber);

        numbers = new int[]{2, 6, 3, 1, 4, 8, 7};
        missingNumber = findMissingNumberOption1ForNotDistinctNumbers(numbers);
        System.out.printf("\nMissing Number is %d\n",missingNumber);

        numbers = new int[]{2, 6, 3, 1, 5, 4, 8};
        missingNumber = findMissingNumberOption1ForNotDistinctNumbers(numbers);
        System.out.printf("\nMissing Number is %d\n",missingNumber);

        numbers = new int[]{2, 6, 3, 1, 5, 4, 8};
        missingNumber = findMissingNumberUsingMathematicalFormula(numbers);
        System.out.printf("\nfindMissingNumberUsingMathematicalFormula: Missing Number is %d\n",missingNumber);

        numbers = new int[]{2, 6, 3, 1, 5, 4, 8};
        missingNumber = findMissingNumberUsingMathematicalFormulaOption2(numbers, (numbers.length+1));//one # missing
        System.out.printf("\nfindMissingNumberUsingMathematicalFormulaOption2: Missing Number is %d\n",missingNumber);

        numbers = new int[]{1, 2, 3, 4, 5, 6, 7};
        missingNumber = findMissingNumberUsingMathematicalFormulaOption2(numbers, numbers.length);//nothing missing
        System.out.printf("\nfindMissingNumberUsingMathematicalFormulaOption2: Missing Number is %d\n",missingNumber);
    }


    /**
     * Time Complexity is O(n^2)
     * @param numbers
     * @return
     */
    private static int findMissingNumberOption1ForNotDistinctNumbers(int[] numbers) {
        if ( numbers == null || numbers.length==0) {
            throw new IllegalArgumentException("Incoming Array is " + ( numbers == null ? "null" : "empty"));
        }

        int missingNumber = Integer.MIN_VALUE; //in case no # gets find
        for (int i=0; i<numbers.length; i++) {
            for (int j=i; j<numbers.length; j++) {
                if(numbers[i] > numbers[j]) {
                    int tmp = numbers[j];
                    numbers[j] = numbers[i];
                    numbers[i] = tmp;
                }
            }
        } //sorted array in O(n^2) time complexity

        //System.out.printf("\nSorted Array  is %s\n", Arrays.toString(numbers));

        for (int i=0; i<numbers.length-1; i++) {
            if ( numbers[i+1] - numbers[i] == 0 ) continue; //same #s appeared (one number appeared multiple times)
            if ( numbers[i+1] - numbers[i] != 1) {
                return numbers[i]+1;
            }
        } //time complexity is O(n)

        return missingNumber;
    }


    /**
     * Mathematically, the sum of n natural #s is n*(n+1)/2
     * for example if we have an array of natural numbers as [1,2,3,4], its sum comes to (1+2+3+4) = 10 or if you do it via maths formula than
     * ((4 * (4+1))/2) = 10 , n in this case is 4 that is length of the array.
     *
     * So as the sum of all the natural #s is 10 so if we loop through the above array and keep substracting starting with the overall sum.
     * For example, our mathematical sum is 10 so we start the loop.
     * 1. 1st iteration will do 10-1 = 9
     * 2. 2nd Iteration will do 9-2 = 7
     * 3. 3rd iteration will do 7-3 = 4
     * 4. 4rth iteration will do 4-4 = 0
     *
     * As after the iteration of the rray final result is 0 so means no # is missing between 1-4.
     *
     * Lets take another example.
     * Array = [1, 2, 3, 5, 7, 6]
     * N = 1-7
     * Array Sum = 1+2+3+5+7+6 = 24
     * Mathematical Formula = (7 * (7+1))/2 = (7 * 8)/2 = 56/2 = 28
     * For example, our mathematical sum is 28 so we start the loop.
     *      * 1. 1st iteration will do 28-1 = 27
     *      * 2. 2nd Iteration will do 27-2 = 25
     *      * 3. 3rd iteration will do 25-3 = 22
     *      * 4. 4rth iteration will do 22-5 = 17
     *      * 5. 5th iteration will do 17-7 = 10
     *      * 6. 6th iteration will do 10-6 = 4
     *
     * So our missing # is 4.
     *
     * Other approach is to do following:-
     *
     * 1. Calculate given array sum. In our above example its 24
     * 2. Calculate Mathematical formula. In our example above its 28
     * 3. Mathematical Formula - Array Sum = 28 -24 = 4 (is our missing #)
     *
     * @param numbers
     * @return
     */
    private static int findMissingNumberUsingMathematicalFormula(int[] numbers) {
        System.out.println("inside findMissingNumberUsingMathematicalFormula------------");
        if ( numbers == null || numbers.length==0) {
            throw new IllegalArgumentException("Incoming Array is " + ( numbers == null ? "null" : "empty"));
        }

        int n = numbers.length + 1; //because one # is missing in the range
        int mathematicalFormulaOfNaturalNums = (n * (n+1))/2; //Time Complexity - O(1) - Constant time
        System.out.printf("\nmathematicalFormulaOfNaturalNums = %d\n",mathematicalFormulaOfNaturalNums);
        int difference = mathematicalFormulaOfNaturalNums;
        for (int i=0; i<numbers.length; i++) {
            difference -= numbers[i];
        } //time complexity = O(n)
        System.out.printf("\ndifference = %d\n",difference);

        return difference;
    }

    private static int findMissingNumberUsingMathematicalFormulaOption2(int[] numbers, int maxRange) {
        System.out.println("inside findMissingNumberUsingMathematicalFormulaOption2------------");
        if ( numbers == null || numbers.length==0) {
            throw new IllegalArgumentException("Incoming Array is " + ( numbers == null ? "null" : "empty"));
        }

        //int n = numbers.length + 1; //because one # is missing in the range, can only work if there is number missing
        int n = maxRange;
        int mathematicalFormulaOfNaturalNums = (n * (n+1))/2; //Time Complexity - O(1) - Constant time
        System.out.printf("\nmathematicalFormulaOfNaturalNums = %d\n",mathematicalFormulaOfNaturalNums);
        int arraySump = 0;
        for (int i=0; i<numbers.length; i++) {
            arraySump += numbers[i];
        } //time complexity = O(n)
        System.out.printf("\narraySump = %d\n",  arraySump);

        System.out.printf("\ndifference = %d\n", (mathematicalFormulaOfNaturalNums - arraySump));

        return (mathematicalFormulaOfNaturalNums - arraySump);
    }
}
