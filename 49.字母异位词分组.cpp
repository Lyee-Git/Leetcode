/*
 * @lc app=leetcode.cn id=49 lang=cpp
 *
 * [49] 字母异位词分组
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
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        unordered_map<string, int> group;
        vector<vector<string>> res;
        int index = 0;
        for (string str : strs) {
            string s = str;
            sort(str.begin(), str.end());
            if (group.count(str))
                res[group[str]].emplace_back(s);
            else {
                vector<string> temp(1, s);
                group[str] = index++;
                res.emplace_back(temp);
            }
        }
        return res;
    }
};
// @lc code=end

