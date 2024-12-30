package com.buland.datastructures.arrays;

public class FindSecondMaxInArray {

    public static void main(String[] args) {
        int [] numbers = {1,2,3,0,-9,3,2,16};

        int secondMaxNumber = findFirstSecondMaxNumFromStartInArray(numbers);
        System.out.printf("\n Second Max Number is %d\n", secondMaxNumber);

        numbers = new int[]{1,1,1};
        secondMaxNumber = findFirstSecondMaxNumFromStartInArray(numbers);
        System.out.printf("\n Second Max Number is %d\n", secondMaxNumber);

        numbers = new int[]{-11,-1,3};
        secondMaxNumber = findFirstSecondMaxNumFromStartInArray(numbers);
        System.out.printf("\n Second Max Number is %d\n", secondMaxNumber);

        numbers = new int[]{-11,-12,3};
        secondMaxNumber = findFirstSecondMaxNumFromStartInArray(numbers);
        System.out.printf("\n Second Max Number is %d\n", secondMaxNumber);

        numbers = new int[]{13,34,2,34,33,1};
        secondMaxNumber = findSecondMaxNumInArrayOption1(numbers);
        System.out.printf("\n Second Max Number is %d\n", secondMaxNumber);

        numbers = new int[]{13,34,2,34,33,35};
        secondMaxNumber = findSecondMaxNumInArrayOption1(numbers);
        System.out.printf("\n Second Max Number is %d\n", secondMaxNumber);

        numbers = new int[]{13,34,2,34,35,36,35};
        secondMaxNumber = findSecondMaxNumInArrayOption1(numbers);
        System.out.printf("\n Second Max Number is %d\n", secondMaxNumber);

        numbers = new int[]{13,34,2,34,33,1};
        secondMaxNumber = findSecondMaxNumInArrayOption2(numbers);
        System.out.printf("\n findSecondMaxNumInArrayOption2, Second Max Number is %d\n", secondMaxNumber);

    }


    /**
     * this function simply returns the second max value in the array so less than maximum value in array
     *
     * Time Complexity is O(n)
     *
     * @param numbers
     * @return
     */
    static int findSecondMaxNumInArrayOption1(int[] numbers) {
        if ( numbers==null || numbers.length==0) {
            throw new IllegalArgumentException("Incoming Array is either " + (numbers==null ? "null" : "empty") );
        }
        if (numbers.length==1) return numbers[0];

        int firstMaxNumber =  (numbers[1] > numbers[0] ? numbers[1] : numbers[0]);
        int secondMaxNumber = (numbers[1] < numbers[0] ? numbers[1] : numbers[0]);
        for (int i=2; i < numbers.length; i++) {
            if (numbers[i] > firstMaxNumber) {
                secondMaxNumber = firstMaxNumber;
                firstMaxNumber = numbers[i];
            } else if (numbers[i] > secondMaxNumber) {
                secondMaxNumber = numbers[i];
            }
        }

        return secondMaxNumber;
    }

    /**
     * this function simply returns the second max value in the array so less than maximum value in array
     *
     * Time Complexity is O(n)
     *
     * @param numbers
     * @return
     */
    static int findSecondMaxNumInArrayOption2(int[] numbers) {
        if ( numbers==null || numbers.length==0) {
            throw new IllegalArgumentException("Incoming Array is either " + (numbers==null ? "null" : "empty") );
        }

        int firstMaxNumber =  Integer.MIN_VALUE;
        int secondMaxNumber = Integer.MIN_VALUE;
        for (int i=0; i < numbers.length; i++) {
            if (numbers[i] > firstMaxNumber) {
                secondMaxNumber = firstMaxNumber;
                firstMaxNumber = numbers[i];
            } else if (numbers[i] > secondMaxNumber && numbers[i] != firstMaxNumber) {
                secondMaxNumber = numbers[i];
            }
        }

        return secondMaxNumber;
    }

    /**
     * this function simply returns the second max value from the start
     * @param numbers
     * @return
     */
    static int findFirstSecondMaxNumFromStartInArray(int[] numbers) {
        if ( numbers==null || numbers.length==0) {
            throw new IllegalArgumentException("Incoming Array is either " + (numbers==null ? "null" : "empty") );
        }
        //boolean matches = Boolean.FALSE;
        int secondMaxNumber = numbers[0];
        for (int i=1; i < numbers.length; i++) {
            if (secondMaxNumber < numbers[i]) {
                return numbers[i];
            }
        }

        return secondMaxNumber;
    }
}
