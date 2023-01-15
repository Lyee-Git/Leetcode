/*
 * @lc app=leetcode.cn id=3 lang=cpp
 *
 * [3] 无重复字符的最长子串
 */
#include<iostream>
#include<vector>
#include<algorithm>
#include<limits.h>
#include<string>
#include<unordered_map>
using namespace std;
// @lc code=start
class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        unordered_map<char, int> window;
        int left = 0, right = 0;
        int lenSubstr = 0;
        while (right < s.length()) {
            char cur = s[right];
            window[cur]++;
            right++;
            while (window[cur] > 1) {
                char shrink = s[left];
                window[shrink]--;
                left++;
            }
            lenSubstr = max(lenSubstr, right - left);
        }
        return lenSubstr;
    }
};
// @lc code=end

