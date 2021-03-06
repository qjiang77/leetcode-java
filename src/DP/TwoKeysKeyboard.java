package DP;

/*
650. 2 Keys Keyboard (Medium)

题目描述：最开始只有一个字符 A，问需要多少次操作能够得到 n 个字符 A，每次操作可以复制当前所有的字符，或者粘贴。

Input: 3
Output: 3
Explanation:
Intitally, we have one character 'A'.
In step 1, we use Copy All operation.
In step 2, we use Paste operation to get 'AA'.
In step 3, we use Paste operation to get 'AAA'.
 */
public class TwoKeysKeyboard {
    public int minSteps(int n) {
        int[] dp = new int[n+1];
        int h = (int)Math.sqrt(n);
        for(int i = 2; i < n+1; i++) {
            dp[i] = i;
            for(int j = 2; j < h+1; j++) {
                if(i % j == 0) {
                    dp[i] = dp[j]+dp[i/j];
                    break;
                }
            }
        }
        return dp[n];
    }
}
