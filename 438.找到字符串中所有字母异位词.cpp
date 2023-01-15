/*
 * @lc app=leetcode.cn id=438 lang=cpp
 *
 * [438] 找到字符串中所有字母异位词
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
    vector<int> findAnagrams(string s, string p) {
        unordered_map<char, int> need, window;
        for (char c : p)
            need[c]++;
        int left = 0, right = 0, validNum = 0; // validNum 记录window内包含的t中的字符(种类）数量
        int lenSubstr = INT_MAX, startSubstr = 0;
        vector<int> res;
        while (right < s.length()) {
            char cur = s[right];
            right++;
            if (need.count(cur)) {
                window[cur]++;
                if (window[cur] == need[cur])
                    validNum++;
            }
            while (right - left == p.length()) {
                if (validNum == need.size()) 
                    res.emplace_back(left);
                char shrink = s[left];
                left++;
                if (need.count(shrink)) {
                    if (need[shrink] == window[shrink])
                        validNum--;
                    window[shrink]--;
                }
            }
        }
        return res;
    }
};
// @lc code=end

