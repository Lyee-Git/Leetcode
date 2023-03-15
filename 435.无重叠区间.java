
/*
 * @lc app=leetcode.cn id=435 lang=java
 *
 * [435] 无重叠区间
 */
import java.util.Arrays;
import java.util.Comparator;

// @lc code=start
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0)
            return 0;
        int n = intervals.length;
        int maxCompatiable = 1;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });
        int end = intervals[0][1];
        for (int i = 1; i < n; i++) {
            int[] cur = intervals[i];
            if (cur[0] >= end) {
                maxCompatiable++;
                end = cur[1];
            }
        }
        return n - maxCompatiable;
    }
}
// @lc code=end
