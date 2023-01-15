/*
 * @lc app=leetcode.cn id=78 lang=java
 *
 * [78] 子集
 */
import java.util.*;
// @lc code=start
class Solution {
    List<List<Integer>> res;
    LinkedList<Integer> path;
    public List<List<Integer>> subsets(int[] nums) {
        res = new LinkedList<>();
        path = new LinkedList<>();
        backtrack(nums, 0);
        return res;
    }

    private void backtrack(int[] nums, int start) {
        res.add(new LinkedList<>(path));

        // 只从start开始向前遍历，避免重复列举子集
        for (int i = start; i < nums.length; i++) {
            path.addLast(nums[i]);
            backtrack(nums, i + 1);
            path.removeLast();
        }
    }
}
// @lc code=end

