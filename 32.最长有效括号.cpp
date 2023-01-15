// @before-stub-for-debug-begin
// #include <vector>
// #include <string>
// #include "commoncppproblem32.h"

// using namespace std;
// @before-stub-for-debug-end

/*
 * @lc app=leetcode.cn id=32 lang=cpp
 *
 * [32] 最长有效括号
 */
#include<string>
#include<algorithm>
#include<vector>
using namespace std;
// @lc code=start
class Solution {
public:
    int longestValidParentheses(string s) {
        int n = s.size(), ans = 0;
        if (n == 0)
            return 0;
        vector<int> dp(n, 0);
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            if (s[i] == '(')
                dp[i] = 0;
            else {
                if (s[i - 1] == '(')
                    dp[i] = i < 2 ? 2 : 2 + dp[i - 2];
                else if (i - 1 - dp[i - 1] >= 0 && s[i - 1 - dp[i - 1]] == '(') {
                    int beforeParen = i - 2 - dp[i - 1];
                    if (beforeParen < 0)
                        dp[i] = dp[i - 1] + 2;
                    else
                        dp[i] = dp[i - 1] + 2 + dp[beforeParen];
                }
            }
            ans = max(ans, dp[i]);
        }
        return ans;
    }
};
// @lc code=end

