package DP;

/*
求数组中等差递增子区间的个数
等差递增子区间，则一个区间中最少有3个数
dp[i]，表示以第i个数位结尾的等差递增子区间个数
 */
public class ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] A) {
        if(A == null || A.length < 3) return 0;
        int[] dp = new int[A.length];
        for(int i = 2; i < A.length; i++) {
            if(A[i]-A[i-1] == A[i-1]-A[i-2]) {
                dp[i] = dp[i-1]+1;
            }
        }
        int res = 0;
        for(int count : dp) {
            res = res+count;
        }
        return res;
    }
}
