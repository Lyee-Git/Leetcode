/*
 * @lc app=leetcode.cn id=70 lang=java
 *
 * [70] 爬楼梯
 */

// @lc code=start
class Solution {
    int[] dp;
    public int climbStairs(int n) {
        dp = new int[n + 1];
        return methods(n);
    }

    int methods(int n) {
        if (n <= 2)
            return n;
        if (dp[n] != 0) 
            return dp[n];
        dp[n] = methods(n - 1) + methods(n - 2);
        return dp[n];
    }
}
// @lc code=end

