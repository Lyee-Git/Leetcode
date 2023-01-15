/*
 * @lc app=leetcode.cn id=5 lang=cpp
 *
 * [5] 最长回文子串
 */
#include<string>
#include<algorithm>
#include<vector>
using namespace std;
// @lc code=start
class Solution {
public:
    string longestPalindrome(string s) {
        int n = s.size(), maxLength = 1, begin = 0;
        vector<vector<bool>> dp(n, vector<bool>(n, false));
        for (int i = 0; i < n; i++)
            dp[i][i] = true;
        for (int l = 2; l <= s.length(); l++) {
            for (int i = 0; i < s.length(); i++) {
                int j = i + l - 1;
                if (j >= s.length())
                    break;
                if (s[i] == s[j]) {
                    if (l <= 2) 
                        dp[i][j] = true;
                    else
                        dp[i][j] = dp[i + 1][j - 1];
                }
                if (dp[i][j] && l > maxLength) {
                    maxLength = l;
                    begin = i;
                }
            }
        }
        return s.substr(begin, maxLength);
    }
};
// @lc code=end

