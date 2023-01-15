/*
 * @lc app=leetcode.cn id=131 lang=cpp
 *
 * [131] 分割回文串
 */
#include<string>
#include<algorithm>
#include<vector>
using namespace std;
// @lc code=start
class Solution {
private:
    vector<vector<int>> dp;
    vector<vector<string>> result;
    vector<string> ans;
public:
    void DFS(int lo, const string& s) {
        int n = s.size();
        if (lo == n)
            result.emplace_back(ans);
        for (int hi = lo; hi < n; hi++) {
            if (dp[lo][hi]) {
                ans.emplace_back(s.substr(lo, hi - lo + 1));
                DFS(hi + 1, s);
                ans.pop_back();
            }
        }
    }

    vector<vector<string>> partition(string s) {
        int n = s.size();
        dp.assign(n, vector<int>(n, true));
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) 
                dp[i][j] = dp[i + 1][j - 1] && s[i] == s[j];
        }
        DFS(0, s);
        return result;
    }
};
// @lc code=end

