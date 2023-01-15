// @before-stub-for-debug-begin
// #include <vector>
// #include <string>
// #include "commoncppproblem354.h"

// using namespace std;
// @before-stub-for-debug-end

/*
 * @lc app=leetcode.cn id=354 lang=cpp
 *
 * [354] 俄罗斯套娃信封问题
 */
#include<vector>
#include<iostream>
#include<limits.h>
#include<stack>
#include<algorithm>
using namespace std;
// @lc code=start
class Solution {
public:
    int LIS(vector<int>& nums) {
        int res = 0, n = nums.size();
        vector<int> MinTail;
        MinTail.emplace_back(nums[0]);
        for (int i = 1; i < n; i++) {
            int x = nums[i], tail = MinTail[res];
            if (nums[i] > MinTail[res]) {
                res++;
                MinTail.emplace_back(nums[i]);
            }
            else {
                int lo = 0, hi = res;
                while (lo < hi) { // Search left bound: First element >= target
                    int mid = (lo + hi) >> 1;
                    if (MinTail[mid] < nums[i])
                        lo = mid + 1;
                    else
                        hi = mid;
                }
                MinTail[lo] = nums[i];
            }
        }
        return MinTail.size();
    }

    int maxEnvelopes(vector<vector<int>>& envelopes) {
        sort(envelopes.begin(), envelopes.end(), [](vector<int>& a, vector<int>& b) 
        { return a[0] < b[0] || (a[0] == b[0] && a[1] > b[1]); });
        int n = envelopes.size();
        vector<int> height(n);
        for (int i = 0; i < n; i++)
            height[i] = envelopes[i][1];
        return LIS(height);
    }
};
// @lc code=end

