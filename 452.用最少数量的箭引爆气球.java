
/*
 * @lc app=leetcode.cn id=452 lang=java
 *
 * [452] 用最少数量的箭引爆气球
 */
import java.util.Arrays;
import java.util.Comparator;

// @lc code=start
class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0)
            return 0;
        int n = points.length;
        int maxCompatiable = 1;
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[1] > b[1]) {
                    return 1;
                } else if (a[1] < b[1]) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        int end = points[0][1];
        for (int i = 1; i < n; i++) {
            int[] cur = points[i];
            if (cur[0] > end) {
                maxCompatiable++;
                end = cur[1];
            }
        }
        return maxCompatiable;
    }
}
// @lc code=end
