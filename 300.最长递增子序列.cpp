// @before-stub-for-debug-begin
// #include <vector>
// #include <string>
// #include "commoncppproblem300.h"

// using namespace std;
// @before-stub-for-debug-end

/*
 * @lc app=leetcode.cn id=300 lang=cpp
 *
 * [300] 最长递增子序列
 */
#include<string>
#include<algorithm>
#include<vector>
using namespace std;
// @lc code=start
class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        int n = nums.size();
        if (n <= 1)
            return n;
        vector<int> MinTail;
        int res = 0;
        MinTail.emplace_back(nums[0]);
        for (int i = 1; i < n; i++) {
            if (nums[i] > MinTail[res]) {
                res++;
                MinTail.emplace_back(nums[i]);
            }
            else {
                int l = 0, r = res;
                while (l < r) {
                    int mid = (l + r) >> 1;
                    if (MinTail[mid] >= nums[i]) // First elem in MinTail that >= nums[i]
                        r = mid;
                    else 
                        l = mid + 1;
                }
                MinTail[l] = nums[i];
            }
        }
        return MinTail.size();
    }
};
// @lc code=end

