/*
 * @lc app=leetcode.cn id=56 lang=cpp
 *
 * [56] 合并区间
 */
#include<vector>
#include<algorithm>
using namespace std;
// @lc code=start
class Solution {
public:
    // static bool compare(vector<int>& a, vector<int>& b)
    // {
    //     return a[0] < b[0];
    // }
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        if (intervals.size() == 0)
            return {};
        sort(intervals.begin(), intervals.end());//, compare);
        vector<vector<int>> merged;
        for (int i = 0; i < intervals.size(); ++i)
        {
            int L = intervals[i][0], R = intervals[i][1];
            if (!merged.size() || merged.back()[1] < L) 
                merged.push_back({L, R});
            else 
                merged.back()[1] = max(merged.back()[1], R);
        }
        return merged;
    }
};
// @lc code=end

