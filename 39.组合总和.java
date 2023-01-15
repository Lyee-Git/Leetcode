
/*
 * @lc app=leetcode.cn id=39 lang=java
 *
 * [39] 组合总和
 */
import java.util.*;

// @lc code=start
class Solution {
    List<List<Integer>> res;
    LinkedList<Integer> path;
    int pathSum = 0;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        path = new LinkedList<>();
        res = new LinkedList<>();
        backtrack(candidates, 0, target);
        return res;
    }

    private void backtrack(int[] nums, int start, int target) {
        if (pathSum == target) {
            res.add(new LinkedList<>(path));
            return;
        }
        if (pathSum > target)
            return;
        for (int i = start; i < nums.length; i++) {
            pathSum += nums[i];
            path.addLast(nums[i]);
            backtrack(nums, i, target);
            path.removeLast();
            pathSum -= nums[i];
        }
    }
}
// @lc code=end
