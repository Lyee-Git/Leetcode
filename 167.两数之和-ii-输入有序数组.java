
/*
 * @lc app=leetcode.cn id=167 lang=java
 *
 * [167] 两数之和 II - 输入有序数组
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int lo = 0, hi = numbers.length - 1;
        while (lo < hi) {
            if (numbers[lo] + numbers[hi] < target) {
                lo++;
            } else if (numbers[lo] + numbers[hi] > target) {
                hi--;
            } else {
                return new int[] { lo + 1, hi + 1 };
            }
        }
        return null;
    }
}
// @lc code=end
