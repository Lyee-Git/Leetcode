/*
 * @lc app=leetcode.cn id=931 lang=java
 *
 * [931] 下降路径最小和
 */
import java.util.*;
// @lc code=start
class Solution {
    int m, n;

    public int minFallingPathSum(int[][] matrix) {
        this.m = matrix.length;
        this.n = matrix[0].length;
        int[][] dp = new int[m][n]; 
        for (int i = 0; i < m; i++)
            Arrays.fill(dp[i], 10001);
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            res = Math.min(res, minSum(matrix, dp, m - 1, i));
        }
        return res;
    }

    // 返回下落到matrix[i][j]的路径最小值
    int minSum(int[][] matrix, int[][] dp, int i, int j) {
        if (i < 0 || j < 0 || i >= m || j >= n)
            return 10002;
        if (i == 0)
            return matrix[i][j];
        if (dp[i][j] != 10001)
            return dp[i][j];
        dp[i][j] = matrix[i][j] + min(minSum(matrix, dp, i - 1, j), minSum(matrix, dp, i - 1, j - 1), 
                    minSum(matrix, dp, i - 1, j + 1));
        return dp[i][j];
    }

    final int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
// @lc code=end

