/*
 * @lc app=leetcode.cn id=1686 lang=cpp
 *
 * [1686] 石子游戏 VI
 */
#include<vector>
#include<iostream>
#include<algorithm>
#include<limits.h>
using namespace std;
// @lc code=start
class Solution {
public:
    int stoneGameVI(vector<int>& aliceValues, vector<int>& bobValues) {
        int n = aliceValues.size();
        vector<pair<int, int>> values;
        for (int i = 0; i < n; i++)
            values.emplace_back(aliceValues[i] + bobValues[i], i);
        sort(values.rbegin(), values.rend());
        int sum[2] = {0, 0}; // Sum[0]: Alice Sum[1]: Bob
        for (int i = 0; i < n; i++)
            sum[i % 2] += i % 2 == 0 ? aliceValues[values[i].second] : bobValues[values[i].second];
        return sum[0] == sum[1] ? 0 : (sum[0] > sum[1] ? 1 : -1);
    }
};
// @lc code=end

