package com.buland.datastructures.strings;

/**
 * Q: Given a string, the task is to check whether given string is a palindrome or not.
 *
 * Example:
 *
 * 1. Input = "madam", Output = true
 * 2. Input = "that", Output = false
 * 3. Input = "lol", Output = true
 *
 */
public class CheckPalindrome {

    public static void main(String[] args) {
        String words = "madam";
        Boolean isPalindrome = isPalindromeOption1(words);
        System.out.printf("\nisPalindromeOption1, Words=%s %s\n",words, (isPalindrome ? "is a Palindrome": "is not a Palindrome") );
        isPalindrome = isPalindromeOption2(words);
        System.out.printf("\nisPalindromeOption2, Words=%s %s\n",words, (isPalindrome ? "is a Palindrome": "is not a Palindrome") );


        words = "that";
        isPalindrome = isPalindromeOption1(words);
        System.out.printf("\nisPalindromeOption1, Words=%s %s\n",words, (isPalindrome ? "is a Palindrome": "is not a Palindrome") );
        isPalindrome = isPalindromeOption2(words);
        System.out.printf("\nisPalindromeOption2, Words=%s %s\n",words, (isPalindrome ? "is a Palindrome": "is not a Palindrome") );

        words = "lol";
        isPalindrome = isPalindromeOption1(words);
        System.out.printf("\nisPalindromeOption1, Words=%s %s\n",words, (isPalindrome ? "is a Palindrome": "is not a Palindrome") );
        isPalindrome = isPalindromeOption2(words);
        System.out.printf("\nisPalindromeOption2, Words=%s %s\n",words, (isPalindrome ? "is a Palindrome": "is not a Palindrome") );

    }

    private static Boolean isPalindromeOption1(String words) {
        char[] charArray = words.toCharArray();
        char[] newCharArray = new char[charArray.length];
        int endIndex = charArray.length-1;
        int startIndex = 0;
        while (endIndex>=0) {
            newCharArray[startIndex++] = charArray[endIndex--];
        }
        //System.out.printf("\nOldcharArray=%s, newCharArray=%s\n", Arrays.toString(charArray), Arrays.toString(newCharArray));
        String newWords = String.valueOf(newCharArray);
        //System.out.printf("\nOldString=%s, NewString=%s\n", words, newWords);
        return newWords.equals(words);
    }


    /**
     * Palindrome string is same no matter you start from any direction like "madam", "lol".
     *
     * The way Algorithm works.
     * 1. convert given string into charArray by using string built in method toCharArray().
     * 2. Get two pointers end = array.length-1 and start=0
     * 3. if array[start] != array[end] return false
     * 4. increase start by 1 and decrement end by 1
     * 5. keep repeating till the end
     * 6. after the loop if we come out, means its a palindrome hence retunr true
     *
     * @param words
     * @return
     */
    private static Boolean isPalindromeOption2(String words) {
        char[] charArray = words.toCharArray();
        int endIndex = charArray.length-1;
        int startIndex = 0;
        while (endIndex>=0) {
            if (charArray[startIndex++] != charArray[endIndex--]) return false;
        }
        return true;
    }
}
