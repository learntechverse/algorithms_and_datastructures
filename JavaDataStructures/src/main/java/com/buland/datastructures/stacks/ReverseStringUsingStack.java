package com.buland.datastructures.stacks;

import java.util.Stack;

public class ReverseStringUsingStack {


    /**
     * Time Complexity:
     *
     *     Step 1 (Convert string to char array):
     *         text.toCharArray() converts the input string to a character array.
     *         This takes O(n) time, where n is the length of the string.
     *
     *     Step 3 (Pushing characters to the stack):
     *         The for loop iterates over the textChars array and pushes each character into the stack.
     *         Each push() operation takes constant time O(1).
     *         Therefore, this loop runs O(n) times, where n is the length of the string.
     *
     *     Step 4 (Reassigning characters to the char array using stack.get(i)):
     *         The second for loop runs n times.
     *         Inside the loop, the code uses stack.get(i), which has a time complexity of O(1) for retrieving elements in a Stack backed by an ArrayList (the default implementation in Java).
     *         Therefore, this loop also takes O(n) time.
     *
     *     Step 6 (Returning a new string):
     *         Constructing a new string from the textChars array takes O(n) time.
     *
     * Total Time Complexity:
     *
     *     All major steps take O(n) time.
     *     Therefore, the overall time complexity is O(n).
     *
     * Space Complexity:
     *
     *     Step 1 (char array):
     *         The textChars array requires O(n) space to store the characters of the input string.
     *
     *     Step 2 (Stack):
     *         The stack requires O(n) space because it stores each character of the string.
     *
     *     Step 6 (New string):
     *         Constructing a new string from the textChars array also takes O(n) space.
     *
     * Total Space Complexity:
     *
     *     The total space complexity is the sum of space used by the textChars array, the stack, and the new string.
     *     Therefore, the overall space complexity is O(n).
     *
     * Summary:
     *
     *     Time Complexity: O(n), where n is the length of the input string.
     *     Space Complexity: O(n), since we store the characters in both the textChars array and the stack.
     *
     * @param text
     * @return
     */
    public static String reverse(String text) {
        char[] textChars = text.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        for (char textChar: textChars) {
            stack.push(textChar);
        }

        for (int i=0; i<text.length(); i++) {
            //textChars[i] = stack.get(i);//will give same direction and not in reverse
            textChars[i] = stack.pop();
        }

        return new String(textChars);
    }


    /**
     * Time and Space Complexity:
     *
     *     Time Complexity: O(n), because we still have to traverse the string/array once to reverse it.
     *     Space Complexity:
     *         O(1) extra space (if you ignore the space for the input and output string). The only extra space used is for a few variables (left, right, and temp).
     *         The space for the character array (text.toCharArray()) is O(n), but this is unavoidable if you're given an immutable string as input.
     *
     * Conclusion:
     *
     *     You cannot reduce the space complexity to O(1) if you're working with an immutable string in Java.
     *     However, if you work directly on a mutable character array (and ignore the space for the array itself), you can reverse it in O(1) additional space using the two-pointer approach.
     *
     * @param text
     * @return
     */
    public static String reverseWithBetterSpaceComplexity(String text) {
        char[] textChars = text.toCharArray();  // O(n) space for the char array

        int left = 0;
        int right = textChars.length - 1;

        // Two-pointer approach to swap characters
        while (left < right) {
            char temp = textChars[left];
            textChars[left] = textChars[right];
            textChars[right] = temp;

            left++;
            right--;
        }

        return new String(textChars);  // O(n) time
    }


    public static void main(String[] args) {

        System.out.printf("Revered String: %s\n", reverse("Buland"));
        System.out.printf("Revered String: %s\n", reverse("My"));
        System.out.printf("Revered String: %s\n", reverse("Cool"));
        System.out.printf("Revered String: %s\n", reverse("My Name Is Buland"));

        System.out.printf("Revered String: %s\n", reverseWithBetterSpaceComplexity("My Name Is Buland"));
    }
}
