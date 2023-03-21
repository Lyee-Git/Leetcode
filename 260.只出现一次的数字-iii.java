/*
 * @lc app=leetcode.cn id=260 lang=java
 *
 * [260] 只出现一次的数字 III
 */

// @lc code=start
class Solution {
    public int[] singleNumber(int[] nums) {
        int xorSum = 0;
        for (int num : nums)
            xorSum ^= num;
        int lsb = xorSum & (-xorSum); // Get lowest bit 1 of xorSum(x1 ^ x2)
        int x1 = 0, x2 = 0;
        for (int num : nums) {
            if ((num & lsb) == 0) {
                x1 ^= num;
            } else {
                x2 ^= num;
            }
        }
        return new int[] { x1, x2 };
    }
}
// @lc code=end
