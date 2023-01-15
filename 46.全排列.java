
/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 */
import java.util.*;

// @lc code=start
class Solution {
    List<List<Integer>> res;
    int n;

    private void backtrack(int first, List<Integer> path) {
        if (first == n) {
            res.add(new ArrayList<>(path));
        }
        for (int i = first; i < n; i++) {
            Collections.swap(path, i, first); // Selected: nums[0..first], Waited: remaining
            backtrack(first + 1, path);
            Collections.swap(path, i, first);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        n = nums.length;
        res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        for (int i = 0; i < n; i++)
            path.add(nums[i]);
        backtrack(0, path);
        return res;
    }
}
// @lc code=end
