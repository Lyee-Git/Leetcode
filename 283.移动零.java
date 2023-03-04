/*
 * @lc app=leetcode.cn id=283 lang=java
 *
 * [283] 移动零
 */

// @lc code=start
class Solution {
    public void moveZeroes(int[] nums) {
        int l = removeElement(nums, 0);
        for (; l < nums.length; l++)
            nums[l] = 0;
            return;
    }

    public int removeElement(int[] nums, int val) {
        int fast = 0, slow = 0;
         while (fast < nums.length) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
         }
         return slow;
    }
}
// @lc code=end

