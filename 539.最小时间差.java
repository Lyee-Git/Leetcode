/*
 * @lc app=leetcode.cn id=539 lang=java
 *
 * [539] 最小时间差
 */
import java.util.*;
// @lc code=start
class Solution {
    public int findMinDifference(List<String> timePoints) {
        int n = timePoints.size();
        if (n > 1440)
            return 0;
        Collections.sort(timePoints);
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            String cur = timePoints.get(i);
            String next = timePoints.get((i + 1) % n);
            int diffMinute = diffMinute(cur, next);
            res = Math.min(res, diffMinute);
        }
        return res;
    }

    int diffMinute(String time1, String time2) {
        int h1 = Integer.parseInt(time1.substring(0, 2));
        int h2 = Integer.parseInt(time2.substring(0, 2));
        int m1 = Integer.parseInt(time1.substring(3));
        int m2 = Integer.parseInt(time2.substring(3));
        if (h2 < h1)
            return Math.abs((h2 - h1 + 23) * 60 + m2 + 60 - m1);
        else 
            return Math.abs((h2 - h1) * 60 + m2 - m1);
    }
}
// @lc code=end

