
/*
 * @lc app=leetcode.cn id=139 lang=java
 *
 * [139] 单词拆分
 */
import java.util.*;

// @lc code=start
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> dict = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n + 1]; // 由于需要一个base case, 所以长度设为n + 1
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                // The substring begins at beginIndex and extends to endIndex - 1
                if (dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
// @lc code=end
