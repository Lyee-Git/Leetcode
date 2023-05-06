
// 剑指 Offer II 107. 矩阵中的距离
// @lc code=start
import java.util.*;

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++)
            Arrays.fill(dp[i], m + n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0)
                    dp[i][j] = 0;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    if (i - 1 >= 0)
                        dp[i][j] = Math.min(dp[i - 1][j] + 1, dp[i][j]);
                    if (j - 1 >= 0)
                        dp[i][j] = Math.min(dp[i][j - 1] + 1, dp[i][j]);
                }
            }
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (mat[i][j] == 1) {
                    if (i + 1 < m)
                        dp[i][j] = Math.min(dp[i + 1][j] + 1, dp[i][j]);
                    if (j + 1 < n)
                        dp[i][j] = Math.min(dp[i][j + 1] + 1, dp[i][j]);
                }
            }
        }
        return dp;
    }
}
