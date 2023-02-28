/*
 * @lc app=leetcode.cn id=416 lang=java
 *
 * [416] 分割等和子集
 */

// @lc code=start
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0, n = nums.length;
        for (int num : nums)
            sum += num;
        if (sum % 2 != 0)
            return false;
        sum /= 2;
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        for (int i = 0; i < n; i++) {
            for (int j = sum; j >= 0; j--) {
                if (j - nums[i] >= 0)
                    dp[j] = dp[j] || dp[j - nums[i]];
                // 这里j从sum开始反向遍历是为了避免重复添加元素
                // 原本的二维情况可以正向遍历，状态方程：
                // dp[i][j]=dp[i-1][j]||dp[i-1][j-nums[i]] 代表用前i个元素能否凑出和为j的情况
            }
        }
        return dp[sum];
    }
}
// @lc code=end
