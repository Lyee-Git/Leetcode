/*
 * @lc app=leetcode.cn id=121 lang=cpp
 *
 * [121] 买卖股票的最佳时机
 */
#include<vector>
#include<iostream>
#include<limits.h>
using namespace std;
// @lc code=start
class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int minPrice = INT_MAX;
        int maxProfit = 0;
        for (auto it : prices)
        {
            if (it < minPrice)
                minPrice = it;
            if (it - minPrice > maxProfit)
                maxProfit = it - minPrice;
        }
        return maxProfit;
    }
};
// @lc code=end

