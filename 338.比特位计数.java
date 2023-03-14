/*
 * @lc app=leetcode.cn id=338 lang=java
 *
 * [338] 比特位计数
 */

// @lc code=start
class Solution {
    public int[] countBits(int n) {
        int[] dp = new int[n + 1];
        int highBitsNum = 0; // Should be 2 ^ x
        for (int i = 1; i <= n; i++) {
            if ((i & (i - 1)) == 0) {
                highBitsNum = i;
            }
            dp[i] = dp[i - highBitsNum] + 1;
        }
        return dp;
    }
}
// @lc code=end

