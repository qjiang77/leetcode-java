package DP;

/*
Leetcode 263: Ugly Number
Write a program to check whether a given number is an ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.

Example 1:

Input: 6
Output: true
Explanation: 6 = 2 × 3
Example 2:

Input: 8
Output: true
Explanation: 8 = 2 × 2 × 2
Example 3:

Input: 14
Output: false
Explanation: 14 is not ugly since it includes another prime factor 7.

    考点：数学知识
    特别的，1可以是丑数
    其他丑数需要满足，只能被2，3，5分解
    那么，ugly = 2i3j5k
    ==> 解法：将丑数不断除以2，3，5，判断剩下的数是否为1即可

 */
public class UglyNumber {
    public boolean isUgly(int num) {
        if(num == 0) return false;
        int[] factors = new int[]{2,3,5};
        for(int factor : factors) {
            while(num % factor == 0) {
                num = num/factor;
            }
        }
        if(num == 1) return true;
        return false;
    }
}
