
/*
 * @lc app=leetcode.cn id=90 lang=java
 *
 * [90] 子集 II
 */
import java.util.*;

// @lc code=start
class Solution {
    // 元素可重复，但不可以重复选择
    List<List<Integer>> res;
    LinkedList<Integer> path;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new LinkedList<>();
        path = new LinkedList<>();
        Arrays.sort(nums);
        backtrack(nums, 0);
        return res;
    }

    private void backtrack(int[] nums, int start) {
        res.add(new LinkedList<>(path));

        // 只从start开始向前遍历，避免重复列举子集
        for (int i = start; i < nums.length; i++) {
            // 对于重复出现的元素，只遍历其一次
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            path.addLast(nums[i]);
            backtrack(nums, i + 1);
            path.removeLast();
        }
    }
}
// @lc code=end
