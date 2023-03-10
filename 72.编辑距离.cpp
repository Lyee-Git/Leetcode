/*
 * @lc app=leetcode.cn id=72 lang=cpp
 *
 * [72] 编辑距离
 */
#include<string>
#include<algorithm>
#include<vector>
using namespace std;
// @lc code=start
class Solution {
public:
    int minDistance(string word1, string word2) {
        int m = word1.size(), n = word2.size();
        vector<vector<int>> dp(m + 1, vector<int>(n + 1, 0));
        for (int i = 1; i <= m; i++)
            dp[i][0] = i;
        for (int i = 1; i <= n; i++)
            dp[0][i] = i;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = min(dp[i - 1][j], dp[i][j - 1]) + 1;
                int directComp = dp[i - 1][j - 1];
                if (word1[i - 1] != word2[j - 1])
                    directComp++;
                dp[i][j] = min(dp[i][j], directComp);
            }
        } 
        return dp[m][n];
    }
};
// @lc code=end

