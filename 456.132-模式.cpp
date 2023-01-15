// @before-stub-for-debug-begin
// #include <vector>
// #include <string>
// #include "commoncppproblem456.h"

// using namespace std;
// @before-stub-for-debug-end

/*
 * @lc app=leetcode.cn id=456 lang=cpp
 *
 * [456] 132 模式
 */
#include <vector>
#include <stack>
#include <limits.h>
#include <algorithm>
using namespace std;
// @lc code=start
class Solution
{
public:
    bool find132pattern(vector<int> &nums)
    {
        // stack<int> sta;
        // int k_candidate = INT_MIN, len = nums.size();
        // // Find Ascending i, j, k such that nums[i] < nums[k] < nums[j]
        // sta.push(nums[len - 1]);
        // for (int i = len - 2; i >= 0; i--)
        // {
        //     if (!sta.empty() && nums[i] < sta.top())
        //         if (nums[i] < k_candidate)
        //             return true;
        //         else
        //             sta.push(nums[i]);
        //     else
        //     {
        //         while (!sta.empty() && sta.top() < nums[i]) // 递减栈
        //         {
        //             if (sta.top() > k_candidate)
        //                 k_candidate = sta.top();
        //             sta.pop();
        //         }
        //         sta.push(nums[i]);
        //     }
        // }
        // return false;

        // (Typical Mistake)
        // Consider this : [3,5,0,3,4]
        // in a decreasing stack, we can't confirm i(idx of 1) < j(idx of 3)
        // stack<int> sta;
        // int i_candidate = INT_MAX, len = nums.size();
        // sta.push(nums[0]);
        // for (int i = 1; i < len; i++)
        // {
        //     if (!sta.empty() && nums[i] < sta.top())
        //         if (nums[i] > i_candidate)
        //             return true;
        //         else
        //             sta.push(nums[i]);
        //     else
        //     {
        //         while (!sta.empty() && sta.top() < nums[i])
        //         {
        //             i_candidate = min(i_candidate, sta.top());
        //             sta.pop();
        //         }
        //         sta.push(nums[i]);
        //     }
        // }
        // return false;

        // Method # 2
        stack<int> sta;
        int len = nums.size();
        vector<int> prev_min{INT_MAX}; // For every index i, get min element in nums[0...i - 1]
        for (int i = 0; i < len; i++)
        {
            while (!sta.empty() && nums[sta.top()] <= nums[i])
                sta.pop();
            if (!sta.empty() && prev_min[sta.top()] < nums[i]) // 3 > 2 and 1 < 2
                return true;
            sta.emplace(i);
            prev_min.emplace_back(min(prev_min.back(), nums[i]));
        }
        return false;
    }
};

// @lc code=end
