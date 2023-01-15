/*
 * @lc app=leetcode.cn id=877 lang=cpp
 *
 * [877] 石子游戏
 */
#include<vector>
using namespace std;
// @lc code=start
class Solution {
public:
    bool stoneGame(vector<int>& piles) {
        // int n = piles.size();
        // vector<int> dp(n);
        // for (int i = 0; i < n; i++)
        //     dp[i] = piles[i];
        // for (int i = n - 2; i >= 0; i--)
        //     for (int j = i + 1; j < n; j++)
        //         dp[j] = max(piles[i] - dp[j], piles[j] - dp[j - 1]);
        //         // O(n ^ 2) : dp[i][j] = max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
        //         // When handle dp[i][j], only dp[i + 1][] & dp[i][] are used
        //         // So omit first dimension and use end of interval(j) as index only
        // return dp[n - 1] >= 0;
        return true;
    }
};
// @lc code=end

