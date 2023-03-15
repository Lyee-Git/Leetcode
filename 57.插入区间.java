
/*
 * @lc app=leetcode.cn id=57 lang=java
 *
 * [57] 插入区间
 */
import java.util.*;

// @lc code=start
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int left = newInterval[0], right = newInterval[1];
        List<int[]> res = new LinkedList<>();
        boolean newIntAdded = false;
        for (int i = 0; i < intervals.length; i++) {
            int[] cur = intervals[i];
            if (cur[1] < left) {
                res.add(cur);
            } else if (cur[0] > right) {
                if (!newIntAdded) {
                    newIntAdded = true;
                    res.add(newInterval);
                }
                res.add(cur);
            } else {
                newInterval[1] = Math.max(newInterval[1], cur[1]);
                newInterval[0] = Math.min(newInterval[0], cur[0]);
            }
        }
        if (!newIntAdded) {
            res.add(newInterval);
        }
        int[][] ans = new int[res.size()][];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }
}
// @lc code=end
