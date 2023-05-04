/*
 * @lc app=leetcode.cn id=983 lang=java
 *
 * [983] 最低票价
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        int[] durations = new int[]{1, 7, 30};
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < 3; k++) {
                int curDate = days[i];
                int j = i;
                while (j >= 0 && curDate - durations[k] < days[j]) {
                    j--;
                }
                int tempCost = 0;
                if (j < 0) {
                    tempCost = costs[k];
                } else {
                    tempCost = dp[j] + costs[k];
                }
                dp[i] = Math.min(dp[i], tempCost);
            }
        }
        return dp[n - 1];
    }
}
// @lc code=end

