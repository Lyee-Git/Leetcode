/*
 * @lc app=leetcode.cn id=209 lang=java
 *
 * [209] 长度最小的子数组
 */

// @lc code=start
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int res = Integer.MAX_VALUE;
        int[] prefix = new int[n + 1];
        for (int i = 0 ; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        for (int j = 0; j < n; j++) {
            int i = -1;
            int lo = 0, hi = j + 1;
            // Find largest i such that prefix[j + 1] - prefix[i] >= target
            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                int subSum = prefix[j + 1] - prefix[mid];
                if (subSum >= target) {
                    i = mid;
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
            if (i != -1)
                res = Math.min(res, j - i + 1);
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
// @lc code=end

