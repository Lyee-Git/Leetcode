/*
 * @lc app=leetcode.cn id=486 lang=cpp
 *
 * [486] 预测赢家
 */

// @lc code=start
#include<vector>
#include<iostream>
#include<algorithm>
#include<limits.h>
using namespace std;
class Solution {
public:
    bool PredictTheWinner(vector<int>& nums) {
        int n = nums.size();
        vector<int> dp(n);
        for (int i = 0; i < n; i++)
            dp[i] = nums[i];
        for (int i = n - 2; i >= 0; i--)
            for (int j = i + 1; j < n; j++)
                dp[j] = max(nums[i] - dp[j], nums[j] - dp[j - 1]);
                // O(n ^ 2) : dp[i][j] = max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
                // When handle dp[i][j], only dp[i + 1][] & dp[i][] are used
                // So omit first dimension and use end of interval(j) as index only
        return dp[n - 1] >= 0;
    }
};
// @lc code=end

