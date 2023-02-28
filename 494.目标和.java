/*
 * @lc app=leetcode.cn id=494 lang=java
 *
 * [494] 目标和
 */

// @lc code=start
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length, sum = 0;
        for (int num : nums)
            sum += num;
        if (sum + target < 0 || (sum + target) % 2 == 1)
            return 0;
        sum = (sum + target) / 2;
        int[] dp = new int[sum + 1];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = sum; j >= 0; j--) {
                if (j - nums[i] < 0)
                    continue;
                else {
                    dp[j] = dp[j] + dp[j - nums[i]];
                }
            }
        }
        return dp[sum];
    }
}
// @lc code=end
