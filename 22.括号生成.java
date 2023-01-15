/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
 */
import java.util.*;
// @lc code=start
class Solution {
    StringBuilder sb = new StringBuilder();
    List<String> res = new LinkedList<>();
    public List<String> generateParenthesis(int n) {
        backtrack(n, n, n);
        return res;
    }

    void backtrack(int n, int left, int right) {
        if (right < left)
            return;
        if (left < 0 || right < 0)
            return;
        if (sb.length() == 2 * n)
            res.add(sb.toString());
        sb.append('(');
        backtrack(n, left - 1, right);
        sb.deleteCharAt(sb.length() - 1);

        sb.append(')');
        backtrack(n, left, right - 1);
        sb.deleteCharAt(sb.length() - 1);
    }
}
// @lc code=end

