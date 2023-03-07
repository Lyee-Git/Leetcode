/*
 * @lc app=leetcode.cn id=647 lang=java
 *
 * [647] 回文子串
 */

// @lc code=start
class Solution {
    public int countSubstrings(String s) {
        int res = 0, n = s.length();
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            res++;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j <= i + 1) {
                        dp[i][j] = 1;
                        res++;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                        res += dp[i][j];
                    }
                }
            }
        }
        return res;
    }
}
// @lc code=end

