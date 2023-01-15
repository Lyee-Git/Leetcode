// @before-stub-for-debug-begin
// #include <vector>
// #include <string>
// #include "commoncppproblem132.h"

// using namespace std;
// // @before-stub-for-debug-end

/*
 * @lc app=leetcode.cn id=132 lang=cpp
 *
 * [132] 分割回文串 II
 */
#include<string>
#include<algorithm>
#include<vector>
#include<limits.h>
using namespace std;
// @lc code=start
class Solution {
public:
    int minCut(string s) {
        int n = s.size();
        vector<vector<int>> dp(n, vector<int>(n, true));
        for (int i = n - 1; i >= 0; i--)
            for (int j = i + 1; j < n; j++)
                dp[i][j] = dp[i + 1][j - 1] && s[i] == s[j];
        vector<int> minPartition(n, INT_MAX);
        minPartition[0] = 0;
        for (int i = 1; i < n; i++) {
            if (dp[0][i])
                minPartition[i] = 0;
            else for (int j = 0; j < i; j++) {
                if (dp[j + 1][i])
                    minPartition[i] = min(minPartition[i], minPartition[j] + 1);
            }
        }
        return minPartition[n - 1];
    }
};
// @lc code=end

