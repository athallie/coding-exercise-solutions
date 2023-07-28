package org.leetcode.solved;

import java.util.HashMap;

/*Given two strings s and t, return true if t is an anagram of s, and false otherwise.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
typically using all the original letters exactly once.
*/

public class ValidAnagram {

    public static void main(String[] args) {
        //Tests
        System.out.println(solution("anagram", "nagaram"));
        System.out.println(solution("anagram", "nagarama"));
    }

    public static boolean solution(String s, String t) {
        if (s.length() == t.length()) {
            HashMap<Character, Integer> sCharCount = new HashMap<>();
            char[] sChars = s.toCharArray();
            char[] tChars = t.toCharArray();

            for (char sChar : sChars) {
                if (sCharCount.containsKey(sChar)) {
                    sCharCount.put(sChar, sCharCount.get(sChar) + 1);
                }
                sCharCount.putIfAbsent(sChar, 1);
            }

            for (char tChar : tChars) {
                if (sCharCount.containsKey(tChar)) {
                    sCharCount.put(tChar, sCharCount.get(tChar) - 1);
                    if (sCharCount.get(tChar) < 0) {
                        return false;
                    }
                } else {
                    return false;
                }
            }

            return true;
        }
        return false;
    }

}
