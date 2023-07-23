package org.leetcode;

/*
* Question:
* You are given two strings word1 and word2.
* Merge the strings by adding letters in alternating order, starting with word1.
* If a string is longer than the other, append the additional letters onto the end of the merged string.
*Return the merged string.
*/

public class MergeStringsAlternately {
    public static void main(String[] args) {
        String word1 = "abchjkl";
        String word2 = "pqrefg";
        System.out.println(mergeAlternately(word1, word2));
    }

    public static String mergeAlternately(String word1, String word2) {
        String[] word1Chars = word1.split("");
        String[] word2Chars = word2.split("");
        int lowerLength;
        int additionals = 0;
        StringBuilder newStr = new StringBuilder();
        if (word1.length() < word2.length()) {
            lowerLength = word1.length();
            additionals = word2.length() - word1.length();
        } else {
            lowerLength = word2.length();
            if (word2.length() < word1.length()) {
                additionals = word1.length() - word2.length();
            }
        }
        for (int i = 0; i < lowerLength; i++) {
            newStr.append(word1Chars[i]).append(word2Chars[i]);
        }
        if (word1.length() > word2.length()) {
            newStr.append(word1.substring(word1.length() - additionals));
        } else if (word2.length() > word1.length()) {
            newStr.append(word2.substring(word2.length() - additionals));
        }
        return newStr.toString();
    }
}