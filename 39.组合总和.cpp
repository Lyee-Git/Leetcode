/*
 * @lc app=leetcode.cn id=39 lang=cpp
 *
 * [39] 组合总和
 */
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
// @lc code=start
class Solution
{
public:
    vector<vector<int>> res;
    vector<int> array;
    void FindCombination(int i, vector<int> &candidates, int target)
    {
        if (i == candidates.size())
            return;
        if (target - candidates[i] >= 0)
        {
            array.emplace_back(candidates[i]);
            if (target - candidates[i] == 0)
            {
                res.emplace_back(array);
                array.pop_back();
                // Tree Pruning Here: For a sorted array, if (target - candidates[i] == 0) satisfied,
                // no need to check following elem
                return; // Tree Pruning
            }
            FindCombination(i, candidates, target - candidates[i]);
            array.pop_back();
        }
        FindCombination(i + 1, candidates, target);
    }

    vector<vector<int>> combinationSum(vector<int> &candidates, int target)
    {
        sort(candidates.begin(), candidates.end());
        FindCombination(0, candidates, target);
        return res;
    }
};
// @lc code=end
