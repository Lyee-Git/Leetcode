
/*
 * @lc app=leetcode.cn id=986 lang=java
 *
 * [986] 区间列表的交集
 */
import java.util.*;

// @lc code=start
class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int i = 0, j = 0;
        int m = firstList.length, n = secondList.length;
        List<int[]> res = new LinkedList<>();
        while (i < m && j < n) {
            int[] a = firstList[i];
            int[] b = secondList[j];
            if (a[1] >= b[0] && b[1] >= a[0]) {
                res.add(new int[] { Math.max(a[0], b[0]), Math.min(a[1], b[1]) });
            }
            if (a[1] < b[1])
                i++;
            else
                j++;
        }
        int[][] ans = new int[res.size()][2];
        for (int k = 0; k < res.size(); k++)
            ans[k] = res.get(k);
        return ans;
    }
}
// @lc code=end
