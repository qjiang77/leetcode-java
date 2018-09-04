package DP;

/*
    矩阵最小路径和：
    求从矩阵的左上角到右下角的最小路径和，每次只能向右或者向下移动
 */
public class MinPathSum {
    public int minPathSUm(int[][] grid) {
        if(grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        int[] dp = new int[n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                // 逐行填充
                if(i == 0) {
                    dp[j] = dp[j-1];
                }else {
                    dp[j] = Math.min(dp[j-1], dp[j]);
                }
                dp[j] += grid[i][j];
            }
        }
        return dp[n-1];
    }
}
