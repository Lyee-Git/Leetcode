/*
 * @lc app=leetcode.cn id=152 lang=java
 *
 * [152] 乘积最大子数组
 */

// @lc code=start
class Solution {
    public int maxProduct(int[] nums) {
        int len = nums.length, res = Integer.MIN_VALUE;
        int[] maxPro = new int[len];
        int[] minPro = new int[len];
        maxPro[0] = minPro[0] = nums[0];
        res = Math.max(res, maxPro[0]);
        for (int i = 1; i < len; i++) {
            maxPro[i] = max(nums[i], maxPro[i - 1] * nums[i], minPro[i - 1] * nums[i]);
            minPro[i] = min(nums[i], maxPro[i - 1] * nums[i], minPro[i - 1] * nums[i]);
            res = Math.max(res, maxPro[i]);
        }
        return res;
    }

    final int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    final int max(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }
}
// @lc code=end
