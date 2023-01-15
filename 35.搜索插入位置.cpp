/*
 * @lc app=leetcode.cn id=35 lang=cpp
 *
 * [35] 搜索插入位置
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
    //If not strict: Return the element >= target with lowest rank (Left bound)
    int searchInsert(vector<int>& nums, int target) {
        int lo = 0, hi = nums.size() - 1;
        while (lo <= hi) {
            int mid = (lo + hi) >> 1;
            if (nums[mid] < target)
                lo = mid + 1;
            else if (nums[mid] > target)
                hi = mid - 1;
            else
                hi = mid - 1;
        }
        return lo;

        //If strict: Return the element <= target with highest rank 
        //Or target with largest rank when target appears (Right bound)
        int lo = 0, hi = nums.size() - 1;
        while (lo <= hi) {
            int mid = (lo + hi) >> 1;
            if (nums[mid] < target)
                lo = mid + 1;
            else if (nums[mid] > target)
                hi = mid - 1;
            else
                lo = mid + 1;
        }
        return hi;
    }
};
// @lc code=end

