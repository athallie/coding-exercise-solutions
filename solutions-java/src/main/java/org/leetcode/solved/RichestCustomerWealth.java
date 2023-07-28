package org.leetcode.solved;

/*You are given an m x n integer grid accounts where accounts[i][j]
is the amount of money the ith customer has in the jth bank.
Return the wealth that the richest customer has.

A customer's wealth is the amount of money they have in all their bank accounts.
The richest customer is the customer that has the maximum wealth.*/
public class RichestCustomerWealth {
    public static void main(String[] args) {
        //Test
        int[][] accounts = {{1, 2, 3}, {3, 2, 1}};
        int[][] accounts1 = {{1,5},{7,3},{3,5}};
        int[][] accounts2 = {{2, 8, 7}, {7, 1, 3}, {1, 9, 5}};
        System.out.println(getMaxWealth(accounts));
        System.out.println(getMaxWealth(accounts1));
        System.out.println(getMaxWealth(accounts2));
    }
    public static int getMaxWealth(int[][] accounts) {
        int largest = -1;
        for (int[] account : accounts) {
            int sum = 0;
            for (int amount : account) {
                sum += amount;
            }
            if (sum > largest) {
                largest = sum;
            }
            sum = 0;
        }
        return largest;
    }
}
