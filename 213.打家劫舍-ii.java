/*
 * @lc app=leetcode.cn id=213 lang=java
 *
 * [213] 打家劫舍 II
 */
import java.util.*;
// @lc code=start
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) 
            return nums[0];
        else if (n == 2) 
            return Math.max(nums[0], nums[1]);
        return Math.max(robRange(0, n - 2, nums), robRange(1, n - 1, nums));
    }   

    private int robRange(int start, int end, int[] nums) {
        int dp0 = 0, dp1 = 0, dp2 = 0;
        for (int i = end; i >= start; i--) {
            dp0 = Math.max(dp2 + nums[i], dp1);
            dp2 = dp1;
            dp1 = dp0;
        }
        return dp0;
    }
}
// @lc code=end

