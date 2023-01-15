/*
 * @lc app=leetcode.cn id=76 lang=cpp
 *
 * [76] 最小覆盖子串
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
    string minWindow(string s, string t) {
        unordered_map<char, int> need, window;
        for (char c : t)
            need[c]++;
        int left = 0, right = 0, validNum = 0; // validNum 记录window内包含的t中的字符(种类）数量
        int lenSubstr = INT_MAX, startSubstr = 0;
        while (right < s.length()) {
            char cur = s[right];
            right++;
            if (need.count(cur)) {
                window[cur]++;
                if (window[cur] == need[cur])
                    validNum++;
            }
            while (validNum == need.size()) {
                if (right - left < lenSubstr) {
                    lenSubstr = right - left;
                    startSubstr = left;
                }
                char shrink = s[left];
                left++;
                if (need.count(shrink)) { // 只对t中出现的字符进行判断，否则会得到错误的validNum!
                    window[shrink]--;
                    if (window[shrink] < need[shrink])
                        validNum--;
                }
            }
        }
        return lenSubstr == INT_MAX ? "" : s.substr(startSubstr, lenSubstr);
    }
};
// @lc code=end

