package org.leetcode.solved;

/*
* Given an array nums.
* We define a running sum of an array as
* runningSum[i] = sum(nums[0]…nums[i]).
*
* Return the running sum of nums.
* */

import java.util.Arrays;

public class RunningSumOf1dArray {

    public static void main(String[] args) {
        //Test
        int[] nums = {1,2,3,4};
        int[] nums1 = {1,1,1,1,1};
        int[] nums2 = {3,1,2,10,1};

        System.out.println(Arrays.toString(runningSum(nums)));
        System.out.println(Arrays.toString(runningSum(nums1)));
        System.out.println(Arrays.toString(runningSum(nums2)));
    }
    public static int[] runningSum(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = nums[0];

        for (int i = 1; i < result.length; i++) {
            result[i] = nums[i] + result[i-1];
        }
        return result;
    }
}
