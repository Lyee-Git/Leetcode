// @before-stub-for-debug-begin
// #include <vector>
// #include <string>
// #include "commoncppproblem188.h"

// using namespace std;
// @before-stub-for-debug-end

/*
 * @lc app=leetcode.cn id=188 lang=cpp
 *
 * [188] 买卖股票的最佳时机 IV
 */
#include<vector>
#include<iostream>
#include<algorithm>
#include<limits.h>
using namespace std;
// @lc code=start
class Solution {
public:
    int maxProfit(int k, vector<int>& prices) {
        /* 2 * (k + 1) States: 
        [n][i][j]
        i indicates num of sales: 0, 1, 2.....k
        j indicates state of holing a stock or not: 0, 1
        */
        int n = prices.size();
        if (prices.empty() || !k)
            return 0;
        int dp[n][k + 1][2];
        dp[0][0][0] = 0;
        dp[0][0][1] = -prices[0];
        for (int j = 1; j < k + 1; j++)
            dp[0][j][0] = dp[0][j][1] = INT_MIN / 2;
        for (int i = 1; i < n; i++)
            for (int j = 0; j < k + 1; j++)
            {
                if (!j)
                {
                    dp[i][j][0] = dp[i - 1][j][0];
                    dp[i][j][1] = max(dp[i - 1][j][1], dp[i - 1][j][0] - prices[i]);
                }
                else
                {
                    dp[i][j][0] = max(dp[i - 1][j][0], dp[i - 1][j - 1][1] + prices[i]);
                    dp[i][j][1] = max(dp[i - 1][j][1], dp[i - 1][j][0] - prices[i]);
                }
            }
        int maxProfit[k], res = 0;
        for (int i = 0; i < k;i++)
            maxProfit[i] = dp[n - 1][i + 1][0];
        res = *max_element(maxProfit + 0, maxProfit + k);
        return max(res, 0);
    }
};
// @lc code=end

