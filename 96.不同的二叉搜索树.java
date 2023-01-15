/*
 * @lc app=leetcode.cn id=96 lang=java
 *
 * [96] 不同的二叉搜索树
 */

// @lc code=start
class Solution {
    int[][] dp;
    public int numTrees(int n) {
        dp = new int[n + 1][n + 1];
        return nums(1, n);
    }

    private int nums(int lo, int hi) {
        if (lo > hi)
            return 1;
        if (dp[lo][hi] != 0)
            return dp[lo][hi];
        int res = 0;
        for (int i = lo; i <= hi; i++) {
            int left = nums(lo, i - 1);
            int right = nums(i + 1, hi);
            res += left * right;
        }
        dp[lo][hi] = res;
        return res;
    }
}
// @lc code=end

