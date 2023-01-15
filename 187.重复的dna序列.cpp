/*
 * @lc app=leetcode.cn id=187 lang=cpp
 *
 * [187] 重复的DNA序列
 */
#include<string>
#include<algorithm>
#include<vector>
#include<unordered_map>
using namespace std;
// @lc code=start
class Solution {
public:
    vector<string> findRepeatedDnaSequences(string s) {
        int length = s.length();
        unordered_map<char, int> toNum = {{'A', 0}, {'C', 1}, {'G', 2}, {'T', 3}};
        constexpr int L = 10;
        vector<string> res;
        if (length <= L)    
            return res;
        int left = 0, right = 0, hashNum = 0;
        unordered_map<int, int> countSubstr;
        while (right < length) {
            hashNum = (hashNum << 2) | toNum[s[right]];
            right++;
            if (right - left == L) {
                if (countSubstr[hashNum] == 1) {
                    countSubstr[hashNum]++;
                    res.emplace_back(s.substr(left, L));
                }
                countSubstr[hashNum]++;
                hashNum = hashNum & ((1 << (L * 2 - 2)) - 1);
                left++;
            }
        }
        return res;
    }
};
// @lc code=end

