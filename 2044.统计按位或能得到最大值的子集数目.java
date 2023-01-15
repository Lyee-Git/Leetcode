/*
 * @lc app=leetcode.cn id=2044 lang=java
 *
 * [2044] 统计按位或能得到最大值的子集数目
 */

// @lc code=start
class Solution {
    int maxOrVal = 0;
    int count = 0;
    public int countMaxOrSubsets(int[] nums) {
        DFS(nums, 0, 0);
        return count;
    }

    void DFS(int[] nums, int pos, int orVal) {
        if (pos == nums.length) {
            if (orVal > maxOrVal) {
                maxOrVal = orVal;
                count = 1;
            }
            else if (orVal == maxOrVal)
                count++;
            return;
        }
        DFS(nums, pos + 1, orVal);
        DFS(nums, pos + 1, orVal | nums[pos]);
    }
}
// @lc code=end

