package org.leetcode.solved;

import java.util.Arrays;

public class TwoSum {
    public static void main(String[] args) {
        //Test
        System.out.println(Arrays.toString(getTwoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(getTwoSum(new int[]{3, 2, 4}, 6)));
        System.out.println(Arrays.toString(getTwoSum(new int[]{3, 3}, 6)));
    }

    public static int[] getTwoSum(int[] nums, int target) {
        int[] ans = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    ans[0] = i;
                    ans[1] = j;
                    return ans;
                }
            }
        }
        return ans;
    }
}
