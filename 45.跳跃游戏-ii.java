/*
 * @lc app=leetcode.cn id=45 lang=java
 *
 * [45] 跳跃游戏 II
 */

// @lc code=start
class Solution {
    public int jump(int[] nums) {
        int jump = 0, end = 0, n = nums.length;
        int far = 0; // (start,end)范围内可以跳到的最大下标
        for (int i = 0; i < n - 1; i++) {
            far = Math.max(far, i + nums[i]);
            // 上一次选择的范围结束，进行下一跳
            if (end == i) {
                jump++;
                end = far;
            }
        }
        return jump;
    }
}
// @lc code=end
