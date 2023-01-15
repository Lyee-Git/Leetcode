/*
 * @lc app=leetcode.cn id=567 lang=cpp
 *
 * [567] 字符串的排列
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
    bool checkInclusion(string s1, string s2) {
        unordered_map<char, int> need, window;
        for (char c : s1)
            need[c]++;
        int left = 0, right = 0, validNum = 0; // validNum 记录window内包含的t中的字符(种类）数量
        int lenSubstr = INT_MAX, startSubstr = 0;
        while (right < s2.length()) {
            char cur = s2[right];
            right++;
            if (need.count(cur)) {
                window[cur]++;
                if (window[cur] == need[cur])
                    validNum++;
            }
            while (right - left == s1.length()) {
                if (validNum == need.size()) 
                    return true;
                char shrink = s2[left];
                left++;
                if (need.count(shrink)) {
                    if (need[shrink] == window[shrink])
                        validNum--;
                    window[shrink]--;
                }
            }
        }
        return false;
    }
};
// @lc code=end

