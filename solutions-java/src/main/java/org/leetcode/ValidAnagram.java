package org.leetcode;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

    public static void main(String[] args) {
        //System.out.println(isAnagram("anagram", "nagaram"));
        //System.out.println(isAnagram("anagram", "nagarama"));
    }

    public static boolean isAnagram(String s, String t) {
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
