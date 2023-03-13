
/*
 * @lc app=leetcode.cn id=301 lang=java
 *
 * [301] 删除无效的括号
 */
import java.util.*;

// @lc code=start
class Solution {

    public List<String> removeInvalidParentheses(String s) {
        int lremove = 0, rremove = 0;
        List<String> res = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                lremove++;
            } else if (s.charAt(i) == ')') {
                if (lremove > 0)
                    lremove--;
                else
                    rremove++;
            }
        }
        dfs(s, 0, lremove, rremove, res);
        if (res.isEmpty()) {
            res.add("");
        }
        return res;
    }

    private void dfs(String s, int start, int lremove, int rremove, List<String> res) {
        if (lremove == 0 && rremove == 0) {
            if (isvalid(s))
                res.add(s);
            return;
        }
        for (int i = start; i < s.length(); i++) {
            // Pruning
            if (lremove + rremove > s.length())
                break;
            // e.g. : For "(((())", we only need to remove one of four '('
            if (i > start && s.charAt(i) == s.charAt(i - 1)) {
                continue;
            }
            if (s.charAt(i) == '(' && lremove > 0) {
                String trimmed = s.substring(0, i) + s.substring(i + 1);
                dfs(trimmed, i, lremove - 1, rremove, res);
            }
            if (s.charAt(i) == ')' && rremove > 0) {
                String trimmed = s.substring(0, i) + s.substring(i + 1);
                dfs(trimmed, i, lremove, rremove - 1, res);
            }
        }
    }

    private boolean isvalid(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            } else if (s.charAt(i) == ')') {
                count--;
                if (count < 0)
                    return false;
            }
        }
        return count == 0;
    }
}
// @lc code=end
