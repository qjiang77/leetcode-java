package DP;

/*
72. Edit Distance (Hard)

Example 1:

Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation:
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')
Example 2:

Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation:
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')

-- replace
-- insert
-- delete
 */
public class EditDistance {
    public int minDistance(String word1, String word2) {
        if(word1 == null || word2 == null) return 0;

        int n1 = word1.length();
        int n2 = word2.length();
        int[][] dp = new int[n1+1][n2+1];
        for(int i = 1; i < n1+1; i++) {
            dp[i][0] = i;
        }
        for(int i = 1; i < n2+1; i++) {
            dp[0][i] = i;
        }
        for(int i = 1; i < n1+1; i++) {
            for(int j = 1; j < n2+1; j++) {
                if(word1.charAt(i) == word2.charAt(j)) {
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j])+1;
                }
            }
        }
        return dp[n1][n2];
    }
}
