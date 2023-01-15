
/*
 * @lc app=leetcode.cn id=77 lang=java
 *
 * [77] 组合
 */
import java.util.*;

// @lc code=start
class Solution {
    List<List<Integer>> res;
    LinkedList<Integer> path;

    public List<List<Integer>> combine(int n, int k) {
        res = new LinkedList<>();
        path = new LinkedList<>();
        backtrack(n, 1, k);
        return res;
    }

    private void backtrack(int n, int start, int k) {
        // 剪枝： 如果不能得到大小为k的组合
        if (path.size() + n - start + 1 < k)
            return;

        // base case
        if (path.size() == k) {
            res.add(new LinkedList<>(path));
            return;
        }

        // 只从start开始向前遍历，避免重复列举子集
        for (int i = start; i <= n; i++) {
            path.addLast(i);
            backtrack(n, i + 1, k);
            path.removeLast();
        }
    }
}
// @lc code=end
