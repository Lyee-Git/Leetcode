/*
 * @lc app=leetcode.cn id=221 lang=java
 *
 * [221] 最大正方形
 */

// @lc code=start
class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix[0].length == 0) {
            return 0;
        }
        int maxLen = 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '0') {
                    dp[i][j] = 0;
                } else {
                    if (i <= 0 || j <= 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = min(dp[i][j - 1], dp[i - 1][j],
                                dp[i - 1][j - 1]) + 1;
                    }
                    maxLen = Math.max(maxLen, dp[i][j]);
                }
            }
        }
        return maxLen * maxLen;
    }

    final int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
// @lc code=end
