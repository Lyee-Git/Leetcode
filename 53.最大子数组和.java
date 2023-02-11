/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子数组和
 */

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
        int dp0 = nums[0], dp1 = 0, res = dp0;
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            dp1 = Math.max(nums[i], nums[i] + dp0);
            dp0 = dp1;
            res = Math.max(res, dp0);
        }
        return res;
    }
}
// @lc code=end

