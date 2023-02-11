/*
 * @lc app=leetcode.cn id=55 lang=java
 *
 * [55] 跳跃游戏
 */
import java.util.*;
// @lc code=start
class Solution {
    public boolean canJump(int[] nums) {
        int far = 0, n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            far = Math.max(far, i + nums[i]);
            if (far <= i)
                return false;
        }
        return far >= n - 1;
    }
}
// @lc code=end

