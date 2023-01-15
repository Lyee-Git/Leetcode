
/*
 * @lc app=leetcode.cn id=47 lang=java
 *
 * [47] 全排列 II
 */
import java.util.*;

// @lc code=start
class Solution {
    List<List<Integer>> res;
    LinkedList<Integer> path;
    boolean[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {
        path = new LinkedList<>();
        res = new LinkedList<>();
        used = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums, nums.length);
        return res;
    }

    private void backtrack(int[] nums, int n) {
        if (path.size() == n) {
            res.add(new LinkedList<>(path));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (used[i])
                continue;
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            used[i] = true;
            path.addLast(nums[i]);
            backtrack(nums, n);
            path.removeLast();
            used[i] = false;
        }
    }
}
// @lc code=end
