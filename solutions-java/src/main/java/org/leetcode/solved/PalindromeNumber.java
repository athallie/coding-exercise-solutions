package org.leetcode.solved;

/*Given an integer x, return true if x is a palindrome, and false otherwise.*/

public class PalindromeNumber {
    public static void main(String[] args) {
        //Test
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(10));
    }

    public static boolean isPalindrome(int x) {
        if (x >= 0) {
            int y = x;
            long reversed = 0;
            while (y > 0) {
                int remainder = y % 10;
                reversed = reversed * 10 + remainder;
                y /= 10;
            }
            return x == reversed;
        }
        return false;
    }
}
