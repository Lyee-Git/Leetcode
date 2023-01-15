/*
 * @lc app=leetcode.cn id=1109 lang=java
 *
 * [1109] 航班预订统计
 */

// @lc code=start
class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] diffNum = new int[n];
        for (int[] booking : bookings) {
            int incre = booking[2];
            diffNum[booking[0] - 1] += incre;
            if (booking[1] != n)
                diffNum[booking[1]] -= incre;
        }
        // 由差分数组计算原数组
        for (int i = 1; i < n; i++)
            diffNum[i] += diffNum[i - 1];
        return diffNum;
    }
}
// @lc code=end

