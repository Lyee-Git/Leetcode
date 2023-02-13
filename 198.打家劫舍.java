/*
 * @lc app=leetcode.cn id=198 lang=java
 *
 * [198] 打家劫舍
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        // int n = nums.length;
        // int[] dp = new int[n + 2];
        // for (int i = n - 1; i >= 0; i--) {
        // dp[i] = Math.max(dp[i + 1], dp[i + 2] + nums[i]);
        // }
        // return dp[0];

        // 压缩dp到一维：
        int n = nums.length;
        int dp0 = 0, dp1 = 0, dp2 = 0;
        for (int i = n - 1; i >= 0; i--) {
            dp0 = Math.max(dp1, dp2 + nums[i]);
            dp2 = dp1;
            dp1 = dp0;
        }
        return dp0;
    }
}
// @lc code=end
