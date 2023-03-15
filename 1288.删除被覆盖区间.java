
/*
 * @lc app=leetcode.cn id=1288 lang=java
 *
 * [1288] 删除被覆盖区间
 */
import java.util.Arrays;

// @lc code=start
class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (int[] a, int[] b) -> {
            if (a[0] == b[0])
                return b[1] - a[1];
            else
                return a[0] - b[0];
        });
        int rMax = intervals[0][1];
        int res = intervals.length;
        for (int i = 1 ; i < intervals.length; i++) {
            int[] cur = intervals[i];
            if (rMax >= cur[1]) {
                res--;
            } else {
                rMax = Math.max(rMax, cur[1]);
            }
        }
        return res;
    }
}
// @lc code=end
