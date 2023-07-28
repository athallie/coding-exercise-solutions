package org.leetcode.solved;

/*
* Given an integer n, return a string array answer (1-indexed) where:
* answer[i] == "FizzBuzz" if i is divisible by 3 and 5.
* answer[i] == "Fizz" if i is divisible by 3.
* answer[i] == "Buzz" if i is divisible by 5.
* answer[i] == i (as a string) if none of the above conditions are true.
*/

import java.util.List;

public class FizzBuzz {
    public static void main(String[] args) {
        //Test
        System.out.println(fizzBuzz(3));
        System.out.println(fizzBuzz(5));
        System.out.println(fizzBuzz(15));
    }

    public static List<String> fizzBuzz(int n) {
        String[] answer = new String[n];
        for (int i = 0; i < answer.length; i++) {
            int index = i + 1;
            if (index % 3 == 0 && index % 5 == 0) {
                answer[i] = "FizzBuzz";
            } else if (index % 3 == 0) {
                answer[i] = "Fizz";
            } else if (index % 5 == 0) {
                answer[i] = "Buzz";
            } else {
                answer[i] = String.valueOf(index);
            }
        }
        return List.of(answer);
    }
}
