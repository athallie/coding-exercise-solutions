package org.leetcode.solved;

/*Given two strings needle and haystack,
return the index of the first occurrence of needle in haystack,
or -1 if needle is not part of haystack.*/

public class FindTheIndexOfTheFirstOccurenceInAString {
    public static void main(String[] args) {
        //Test
        System.out.println(solution("sadbutsad", "sad"));
        System.out.println(solution("leetcode", "leeto"));
    }
    public static int solution(String haystack, String needle) {
        StringBuilder str = new StringBuilder();
        if (haystack.length() < needle.length()) {
            return -1;
        }
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0) && i < (haystack.length() - needle.length() + 1)) {
                str.append(haystack, i, i + needle.length());
                if (str.toString().equals(needle)) {
                    return i;
                } else {
                    str.setLength(0);
                }
            }
        }
        return -1;
    }
}
