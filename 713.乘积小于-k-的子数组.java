/*
 * @lc app=leetcode.cn id=713 lang=java
 *
 * [713] 乘积小于 K 的子数组
 */
// Sliding window O(n)
// Prefix Sum + Binary Search O(nlogn)
// @lc code=start
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k == 0) {
            return 0;
        }
        int n = nums.length;
        double[] logPrefix = new double[n + 1];
        double logK = Math.log(k);
        int res = 0;
        for (int i = 0; i < n; i++) {
            logPrefix[i + 1] = logPrefix[i] + Math.log(nums[i]);
        }
        // For each j, find smallest i such that sum(log i+...logj) < logK
        for (int j = 0; j < n; j++) {
            int lo = 0, hi = j + 1; // hi = j also works
            int i = j + 1;
            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                double subLogSum = logPrefix[j + 1] - logPrefix[mid];
                // add 10^-9 to avoid additional counts when subLogSum == logK
                if (subLogSum + 1e-9 < logK) {
                    i = mid;
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
            res += j - i + 1;
        }
        return res;
    }
}
// @lc code=end
