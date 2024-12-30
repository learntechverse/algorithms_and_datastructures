package com.buland.datastructures.sorting;

import java.util.Arrays;
import java.util.Random;

/**
 * Selection sort is a simple comparison-based sorting algorithm. The basic idea is to repeatedly find the minimum
 * (or maximum, depending on sorting order) element from the unsorted part of the list and swap it with the first unsorted element.
 *
 * Here’s how selection sort works step-by-step:
 *
 *     Start at the beginning of the list.
 *     Find the minimum element in the unsorted portion of the list (from the current position to the end).
 *     Swap the minimum element found with the element at the current position.
 *     Move to the next position (increment the index) and repeat the process until the entire list is sorted.
 *
 * Working of Selection Sort algorithm:
 * Lets consider the following array as an example: arr[] = {64, 25, 12, 22, 11}
 *
 * First pass:
 * For the first position in the sorted array, the whole array is traversed from index 0 to 4 sequentially. The first position where 64 is
 * stored presently, after traversing whole array it is clear that 11 is the lowest value.
 * 64 25 12 22 11
 * Thus, replace 64 with 11. After one iteration 11, which happens to be the least value in the array, tends to appear in the first
 * position of the sorted list.
 * 11 25 12 22 64
 *
 * Second Pass:
 * For the second position, where 25 is present, again traverse the rest of the array in a sequential manner.
 * 11 25 12 22 64
 * After traversing, we found that 12 is the second lowest value in the array and it should appear at the second place in the array,
 * thus swap these values.
 * 11 12 25 22 64
 *
 * Third Pass:
 * Now, for third place, where 25 is present again traverse the rest of the array and find the third least value present in the array.
 * 11 12 25 22 64
 * While traversing, 22 came out to be the third least value and it should appear at the third place in the array, thus swap 22 with
 * element present at third position.
 * 11 12 22 25 64
 *
 * Fourth pass:
 * Data Structure and Algorithms
 * Similarly, for fourth position traverse the rest of the array and find the fourth least element in the array
 * As 25 is the 4th lowest value hence, it will place at the fourth position.
 * 11 12 22 25 64
 *
 * Fifth Pass:
 * At last the largest value present in the array automatically get placed at the last position in the array
 * The resulted array is the sorted array.
 * 11 12 22 25 64
 *
 * Time Complexity:
 *
 *     Best case: O(n²)
 *     Worst case: O(n²)
 *     Average case: O(n²)
 *
 * This is because in every pass, the algorithm searches through a decreasing number of unsorted elements, and for each element, it
 * performs a comparison with all the others in the unsorted part.
 *
 * Space Complexity:
 *
 *     O(1) because the sorting is done in place (no additional space is needed apart from a few variables for swapping).
 *
 * Use Cases:
 *
 *     Selection sort is rarely used in practice because of its poor time complexity, especially for large datasets. However, it can
 *     be useful for educational purposes to understand sorting algorithms and for small datasets where its simplicity might outweigh
 *     the time complexity concerns.
 *
 * In Selection Sort, we can divide Array into two buckets logically, Left side is always sorted while right side in unsorted
 */
public class SelectionSort {

    public static void main(String[] args) {
        sortGivenSize(1000);
        System.out.println("\n");
        sortGivenSize(3000);
        System.out.println("\n");
        sortGivenSize(5000);
    }

    static void sortGivenSize(int ARRAY_SIZE) {
        int[] numbers = new int[ARRAY_SIZE];
        Random random = new Random();
        for (int i=0; i<ARRAY_SIZE; i++) {
            numbers[i] = random.nextInt(100000);
        }

        //numbers = new int[]{7,3,5,10,-5,-2,0,1,9,6};
        //System.out.printf("Array Before Sorting: %s\n", Arrays.toString(numbers));

        long startTime = System.currentTimeMillis();
        selectionSort(numbers);
        long endTime = System.currentTimeMillis();

        System.out.printf("Selection Sort of Size=%d took %dms\n", ARRAY_SIZE, (endTime-startTime));
        //System.out.printf("Array After Sorting: %s\n", Arrays.toString(numbers));
    }

    private static void selectionSort(int[] numbers) {
        int arrLength = numbers.length;
        for (int i = 0; i< arrLength; i++) {
            int minIndex = i;
            int lowNum = numbers[i];
            for (int j=(i+1); j<arrLength ; j++) {
                if ( numbers[j] < lowNum ) {
                    minIndex = j;
                    lowNum = numbers[j];
                }
            }
            swap(numbers, i, minIndex);
        }
    }


    /**
     * method to swap 2 #s at given array indices
     *
     * @param numbers
     * @param index1
     * @param index2
     */
    private static void swap(int[] numbers, int index1, int index2) {
        int tmp = numbers[index1];
       numbers[index1] = numbers[index2];
       numbers[index2] = tmp;
    }

}
