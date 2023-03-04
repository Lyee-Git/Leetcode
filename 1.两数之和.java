
/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */
import java.util.*;

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> index = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++)
            index.put(nums[i], i);
        for (int i = 0; i < n; i++) {
            if (index.containsKey(target - nums[i])) {
                int ind = index.get(target - nums[i]);
                if (i != ind)
                    return new int[] { Math.min(i, ind), Math.max(i, ind) };
            }
        }
        return null;
    }
}
// @lc code=end
