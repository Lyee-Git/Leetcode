
/*
 * @lc app=leetcode.cn id=220 lang=java
 *
 * [220] 存在重复元素 III
 */
import java.util.*;

// @lc code=start
class Solution {
    // Sliding Window + Treeset
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        TreeSet<Long> set = new TreeSet<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            Long lowerBound = set.ceiling((long) (nums[i] - valueDiff));
            if (lowerBound != null && lowerBound <= (long) (nums[i] + valueDiff)) {
                return true;
            }
            if (i >= indexDiff) {
                set.remove((long) nums[i - indexDiff]);
            }
            set.add((long) nums[i]);
        }
        return false;
    }
}
// @lc code=end
