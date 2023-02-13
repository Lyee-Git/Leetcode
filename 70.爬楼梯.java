/*
 * @lc app=leetcode.cn id=70 lang=java
 *
 * [70] 爬楼梯
 */

// @lc code=start
class Solution {
    int[] dp;

    public int climbStairs(int n) {
        if (n == 1)
            return 1;
        else if (n == 2) 
            return 2;
        dp = new int[n + 1];
        //return methods(n);
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i-2];
        }
        return dp[n];
    }

    // int methods(int n) {
    //     if (n <= 2)
    //         return n;
    //     if (dp[n] != 0)
    //         return dp[n];
    //     dp[n] = methods(n - 1) + methods(n - 2);
    //     return dp[n];
    // }
}
// @lc code=end
