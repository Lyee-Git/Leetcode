/*
 * @lc app=leetcode.cn id=123 lang=cpp
 *
 * [123] 买卖股票的最佳时机 III
 */
#include<vector>
#include<iostream>
#include<algorithm>
#include<limits.h>
using namespace std;
// @lc code=start
class Solution {
public:
    int maxProfit(vector<int>& prices) {
        //Method 1:
//         vector<vector<int>> dp(prices.size(), vector<int>(5,0));
//         dp[0][0] = 0;
//         dp[0][1] = -prices[0];
//         dp[0][2] = 0;
//         dp[0][3] = -prices[0];
//         dp[0][4] = 0;
//    /* 5 States: 
//         0: none
//         1: (already committed) first buy
//         2: (already committed) first sale
//         3: (already committed) second buy
//         4: (already committed) second sale
//     */
//         for(int i = 1; i < prices.size(); i++) {
//             dp[i][0] = dp[i - 1][0];
//             dp[i][1] = max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
//             dp[i][2] = max(dp[i - 1][2], dp[i - 1][1] + prices[i]);
//             dp[i][3] = max(dp[i - 1][3], dp[i - 1][2] - prices[i]);
//             dp[i][4] = max(dp[i - 1][4], dp[i - 1][3] + prices[i]);
//         }
//         return dp[prices.size() - 1][4];


        //Method 2:
        /* 6 States: 
        [n][i][j]
        i indicates num of sales: 0, 1, 2
        j indicates state of holing a stock or not: 0, 1
        */
        int n = prices.size();
        int DP[n][3][2], maxProfit = 0;
        DP[0][0][0] = 0;
        DP[0][0][1] = -prices[0];
        DP[0][1][0] = DP[0][1][1] = DP[0][2][0] = DP[0][2][1] = INT_MIN / 2;
        for (int i = 1; i < n; i++)
        {
            DP[i][0][0] = DP[i - 1][0][0];
            DP[i][0][1] = max(DP[i - 1][0][0] - prices[i], DP[i - 1][0][1]);
            DP[i][1][0] = max(DP[i - 1][1][0], DP[i][0][1] + prices[i]);
            DP[i][1][1] = max(DP[i - 1][1][1], DP[i - 1][1][0] - prices[i]);
            DP[i][2][0] = max(DP[i - 1][2][0], DP[i - 1][1][1] + prices[i]);
            DP[i][2][1] = max(DP[i - 1][2][1], DP[i - 1][2][0] - prices[i]);
        }
        maxProfit = max(DP[n - 1][1][0], DP[n - 1][2][0]);
        return max(maxProfit, 0);
    }
};
// @lc code=end

