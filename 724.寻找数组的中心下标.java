/*
 * @lc app=leetcode.cn id=724 lang=java
 *
 * [724] 寻找数组的中心下标
 */

// @lc code=start
class Solution {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        for (int num : nums)
            sum += num;
        int prefix = 0, res = -1;
        for (int i = 0; i < nums.length; i++) {
            if (prefix * 2 == sum - nums[i]) {
                res = i;
                break;
            }
            prefix += nums[i];
        }
        return res;
    }
}
// @lc code=end

