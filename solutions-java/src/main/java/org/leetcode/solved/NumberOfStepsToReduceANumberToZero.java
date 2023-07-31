package org.leetcode.solved;

/*
* Given an integer num, return the number of steps to reduce it to zero.
* In one step, if the current number is even,
* you have to divide it by 2, otherwise, you have to subtract 1 from it.
* */

public class NumberOfStepsToReduceANumberToZero {
    public static void main(String[] args) {
        System.out.println(solution(14));
        System.out.println(solution(8));
        System.out.println(solution(123));
    }

    public static int solution(int num) {
        int count = 0;
        while(num != 0) {
            if (num % 2 == 0) {
                num /= 2;
            } else {
                num -= 1;
            }
            count++;
        }
        return count;
    }
}
