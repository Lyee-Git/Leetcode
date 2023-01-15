/*
 * @lc app=leetcode.cn id=122 lang=cpp
 *
 * [122] 买卖股票的最佳时机 II
 */
#include<vector>
#include<iostream>
#include<algorithm>
using namespace std;
// @lc code=start
class Solution {
public:
    int maxProfit(vector<int>& prices) {
    //Non-DP method:
    // int len = prices.size(), maxProfit = 0;
    //     for (int i = 0; i < len - 1; i++)
    //         if (prices[i + 1] - prices[i] > 0)
    //             maxProfit += prices[i + 1] - prices[i];
    //     return maxProfit;

        //DP:
        int n = prices.size();
        int DP[n][2];
        // 0: holding stock 
        // 1: not holding stock
        DP[0][0] = 0;
        DP[0][1] = -prices[0];
        for (int i = 1; i < n; i++)
        {
            DP[i][0] = max(DP[i - 1][0], DP[i - 1][1] + prices[i]);
            DP[i][1] = max(DP[i - 1][0] - prices[i], DP[i - 1][1]);
        }
        return DP[n - 1][0];
    }
};
// @lc code=end

