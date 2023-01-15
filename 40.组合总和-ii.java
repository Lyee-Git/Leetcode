
/*
 * @lc app=leetcode.cn id=40 lang=java
 *
 * [40] 组合总和 II
 */
import java.util.*;

// @lc code=start
class Solution {
    List<List<Integer>> res;
    LinkedList<Integer> path;
    int pathSum = 0;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        path = new LinkedList<>();
        res = new LinkedList<>();
        Arrays.sort(candidates);
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
            // 重要剪枝，由于是已排序数组，我们可以忽略后面的元素
            if (pathSum + nums[i] > target)
                break;
            if (i > start && nums[i] == nums[i - 1])
                continue;
            pathSum += nums[i];
            path.addLast(nums[i]);
            backtrack(nums, i + 1, target);
            path.removeLast();
            pathSum -= nums[i];
        }
    }
}
// @lc code=end
