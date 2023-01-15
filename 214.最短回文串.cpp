// @before-stub-for-debug-begin
// #include <vector>
// #include <string>
// #include "commoncppproblem214.h"

// using namespace std;
// @before-stub-for-debug-end

/*
 * @lc app=leetcode.cn id=214 lang=cpp
 *
 * [214] 最短回文串
 */
#include<string>
#include<algorithm>
#include<vector>
using namespace std;
// @lc code=start
class Solution {
public:
    void BuildNext(string& pattern, vector<int>& next) 
    {
        int n = pattern.size();
        int j = next[0] = -1;
        int i = 0;
        while (i < n - 1) {
            if (j < 0 || pattern[i] == pattern[j]) {
                i++; j++;
                next[i] = j;
            }
            else
                j = next[j];
        }
    }

    string shortestPalindrome(string s) {
        // Variation of Rabin-Karp Algorithm:
        // int n = s.size();
        // int base = 131, mod = 1000000007;
        // int left = 0, right = 0, mul = 1;
        // int best = -1;
        // for (int i = 0; i < n; ++i) {
        //     left = ((long long)left * base + s[i]) % mod;
        //     right = (right + (long long)mul * s[i]) % mod;
        //     if (left == right) {
        //         best = i;
        //     }
        //     mul = (long long)mul * base % mod;
        // }
        // string add = (best == n - 1 ? "" : s.substr(best + 1, n));
        // reverse(add.begin(), add.end());
        // return add + s;

        // KMP:
        if (s.empty())
            return "";
        int n = s.size();
        vector<int> next(n);
        BuildNext(s, next);
        int i = n - 1, j = 0;
        while (i >= 0 && j < n) {
            if (j < 0 || s[i] == s[j]) { // Using s as pattern, reversed_s as target
                i--; j++;
            }
            else 
                j = next[j];
        }
        string prefix = j >= n ? "" : s.substr(j, n);
        reverse(prefix.begin(), prefix.end());
        return prefix + s;
    }
};
// @lc code=end

