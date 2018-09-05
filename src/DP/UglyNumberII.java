package DP;

/*
Leetcode 264: Ugly Number II
Write a program to find the n-th ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.

Example:

Input: n = 10
Output: 12
Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.

 考点：【数学知识】
    解法一：列举所有的丑数，再排序，得到n th丑数（三重循环）
    解法二：
        new_num = min{ugly_num[i2]*2, ugly_num[i3]*3, ugly_num[i5]*5}
        记录三个index，从3个candidate中选最小的一个作为结果
        时间和空间复杂度都为O(n)
 */

public class UglyNumberII {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        // 第一个丑数是1
        dp[0] = 1;
        // 对应2，3，5的下标
        int idx2 = 0;
        int idx3 = 0;
        int idx5 = 0;
        int counter = 1;
        while (counter < n) {
            // 找出数组dp[idx2]*2、
            //dp[idx3]*3、dp[idx5]*5的最小值，
            // 最小值即为下一个丑数，同时更新最小值对应的下标，
            // 如果多个数字同时为最小值，则它们的下标都要更新
            int min = minOf
                    (dp[idx2] * 2,
                            dp[idx3] * 3,
                            dp[idx5] * 5);

            if (min == dp[idx2] * 2) {
                idx2++;
            }
            if (min == dp[idx3] * 3) {
                idx3++;
            }
            if (min == dp[idx5] * 5) {
                idx5++;
            }
            dp[counter] = min;
            counter++;
        }
        return dp[n - 1];
    }

    private int minOf(int a, int b, int c) {
        int temp = a < b ? a : b;
        return temp < c ? temp : c;
    }
}
