/*
 * @lc app=leetcode.cn id=1094 lang=java
 *
 * [1094] 拼车
 */

// @lc code=start
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        boolean res = true;
        int[] diffNum = new int[1001];
        for (int[] trip : trips) {
            int incre = trip[0];
            diffNum[trip[1]] += incre;
            if (trip[2] != 1001)
                diffNum[trip[2]] -= incre;
        }
        if (diffNum[0] > capacity)
            return false;
        for (int i = 1; i < 1001; i++) {
            diffNum[i] += diffNum[i - 1];
            if (diffNum[i] > capacity)
                res = false;
        }
        return res;
    }
}
// @lc code=end

