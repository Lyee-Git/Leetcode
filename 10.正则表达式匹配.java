
/*
 * @lc app=leetcode.cn id=10 lang=java
 *
 * [10] 正则表达式匹配
 */
import java.util.*;

// @lc code=start
class Solution {
    int[][] dp;

    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        dp = new int[m][n];
        for (int i = 0; i < m; i++)
            Arrays.fill(dp[i], -1);
        return check(s, 0, p, 0);
    }

    private boolean check(String s, int i, String p, int j) {
        int m = s.length(), n = p.length();
        boolean res;
        if (j == n)
            return i == m;
        if (i == m) {
            if ((n - j) % 2 != 0)
                return false;
            for (; j + 1 < n; j += 2) {
                if (p.charAt(j + 1) != '*')
                    return false;
            }
            return true;
        }
        if (dp[i][j] != -1)
            return dp[i][j] == 1;
        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
            if (j + 1 < n && p.charAt(j + 1) == '*') {
                res = check(s, i + 1, p, j) ||
                        check(s, i, p, j + 2);
            } else {
                res = check(s, i + 1, p, j + 1);
            }
        } else {
            if (j + 1 < n && p.charAt(j + 1) == '*')
                res = check(s, i, p, j + 2);
            else
                res = false;
        }
        dp[i][j] = res ? 1 : 0;
        return res;
    }
}
// @lc code=end
