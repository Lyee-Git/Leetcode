
/*
 * @lc app=leetcode.cn id=712 lang=java
 *
 * [712] 两个字符串的最小ASCII删除和
 */
import java.util.*;

// @lc code=start
class Solution {
    int[][] dp;

    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }
        return minDelSum(s1, 0, s2, 0);
    }

    // 返回s1[i..]和s2[j..]的最小删除和
    private int minDelSum(String s1, int i, String s2, int j) {
        int res = 0;
        if (i == s1.length()) {
            for (; j < s2.length(); j++)
                res += s2.charAt(j);
            return res;
        }
        if (j == s2.length()) {
            for (; i < s1.length(); i++)
                res += s1.charAt(i);
            return res;
        }
        if (dp[i][j] != -1)
            return dp[i][j];
        if (s1.charAt(i) == s2.charAt(j)) {
            dp[i][j] = minDelSum(s1, i + 1, s2, j + 1);
        } else {
            dp[i][j] = Math.min(minDelSum(s1, i + 1, s2, j) + s1.charAt(i),
                    minDelSum(s1, i, s2, j + 1) + s2.charAt(j));
        }
        return dp[i][j];
    }
}
// @lc code=end
