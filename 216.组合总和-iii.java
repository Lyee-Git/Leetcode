/*
 * @lc app=leetcode.cn id=216 lang=java
 *
 * [216] 组合总和 III
 */
import java.util.*;
// @lc code=start
class Solution {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();
    int sum = 0;
    public List<List<Integer>> combinationSum3(int k, int n) {
        backtrack(k, n, 1, 9);
        return res;
    }

    void backtrack(int k, int n, int start, int max) {
        if (path.size() > k || path.size() + n - start + 1 < k || sum > n)
            return;
        if (path.size() == k && sum == n) {
            res.add(new LinkedList<>(path));
            return;
        }
        for (int i = start; i <= max; i++) {
            sum += i;
            path.addLast(i);
            backtrack(k, n, i + 1, max);
            path.removeLast();
            sum -= i;
        }
    }
}
// @lc code=end

