/*
 * @lc app=leetcode.cn id=525 lang=java
 *
 * [525] 连续数组
 */
import java.util.*;
// @lc code=start
class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> prefixToIndex = new HashMap<>();
        int res = 0, prefixCounter = 0;
        // For any i that makes sum(nums[0..i]) == 0, res should be updated to i + 1
        prefixToIndex.put(0, -1); 
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i] == 1 ? 1 : -1;
            prefixCounter += num;
            if (prefixToIndex.containsKey(prefixCounter)) {
                int firstIndex = prefixToIndex.get(prefixCounter);
                res = Math.max(res, i - firstIndex);
            } else {
                prefixToIndex.put(prefixCounter, i);
            }
        }
        return res;
    }
}
// @lc code=end

