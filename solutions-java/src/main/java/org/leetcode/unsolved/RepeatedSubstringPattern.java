package org.leetcode.unsolved;

/*
* Given a string s,
* check if it can be constructed by taking a substring of it
* and appending multiple copies of the substring together.*/

import java.util.Arrays;

public class RepeatedSubstringPattern {
    public static void main(String[] args) {
        //Tests
        System.out.println(solution("ab".repeat(4)));
        System.out.println(solution("ab".repeat(27)));
        System.out.println(solution("abc".repeat(4)));
        System.out.println(solution("ababab"));
        System.out.println(solution("abac"));
        System.out.println(solution("abcabc"));
        System.out.println(solution("abaababaab"));
        System.out.println(solution("abcdabcdabcdabcdabcd"));
        System.out.println(solution("abacababacab"));
        System.out.println(solution("ababababababaababababababaababababababa"));
    }

    //length 4 -> 2 substr
    //length 6 -> 2 || 3 substr
    //length 8 -> 2 || 4 substr
    //length 10 -> 2 || 5 substr
    //length 12 -> 2 || 3 || 4 || 6 substr -> 2, 2, 3
    // FPB = 24 -> 2, 12 -> 2, 6 -> 2, 3
    // FPB Genap = X -> 2, n1 -> 2, n2 -> 2, n3 -> ...
    // 2^i * ni

    public static boolean solution(String s) {
        if (s.length() == 1) {
            return false;
        }
        if (s.length() == 2) {
            return s.charAt(0) == s.charAt(1);
        }
        if (s.length() == 3) {
            return s.charAt(0) == s.charAt(1) && s.charAt(1) == s.charAt(2);
        }
        if (s.length() == 5) {
            return
                    s.charAt(0) == s.charAt(1) &&
                    s.charAt(1) == s.charAt(2) &&
                    s.charAt(2) == s.charAt(3) &&
                    s.charAt(3) == s.charAt(4);
        }
        if (s.length() == 7) {
            return
                    s.charAt(0) == s.charAt(1) &&
                    s.charAt(1) == s.charAt(2) &&
                    s.charAt(2) == s.charAt(3) &&
                    s.charAt(3) == s.charAt(4) &&
                    s.charAt(4) == s.charAt(5) &&
                    s.charAt(5) == s.charAt(6);
        }

        int X = s.length();
        int count = 0;
        while (X / 2 != 1) {
            X /= 2;
            count++;
        }

        count += 3;

        int[][] pairs = new int[count][2];
        pairs[0][0] = 1;

        X = s.length();
        int i = 0;
        int j = 2;

        while ((double) X / j != 1) {
            if (X % j == 0) {
                fillArray(i, X /= j, j, pairs);
                if ((double) X / j <= 1) {
                    i++;
                    break;
                }
                i++;
            } else if (X % 2 != 0 && X % 3 != 0 && X % 5 != 0 && X % 7 != 0) {
                break;
            }

            if (j == 2) {
                j++;
                continue;
            }
            j += 2;
            if (j > 7) {
                j = 2;
            }
        }

        X = s.length();

        for (j = 3; j < 98; j++) {
            if (pairs.length == i) {
                break;
            }
            if (X != j && X % j == 0) {
                pairs[i][0] = j;
                pairs[i][1] = X / j;
                i++;
            }
        }

        for (int[] pair : pairs) {
            if (pair[0] == 0 && pair[1] == 0) {
                continue;
            }
            if (s.substring(0, pair[0]).equals(s.substring(pair[0], pair[0] * 2))) {
                if (s.substring(s.length() - pair[0]).equals(s.substring(0, pair[0]))) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void fillArray(int i, int X, int divisor, int[][] pairs) {
        if (i == 0) {
            pairs[i][0] = divisor * pairs[i][0];
        } else {
            pairs[i][0] = divisor * pairs[i-1][0];
        }
        pairs[i][1] = X;
    }
}
