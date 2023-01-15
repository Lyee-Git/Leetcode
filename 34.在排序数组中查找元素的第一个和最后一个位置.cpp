/*
 * @lc app=leetcode.cn id=34 lang=cpp
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
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
    int left_bound(vector<int>& nums, int target) {
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
        if (lo == nums.size())
            return -1;
        return nums[lo] == target ? lo : -1;
    }

    int right_bound(vector<int>& nums, int target) {
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
        if (hi < 0)
            return -1;
        else return nums[hi] == target ? hi : -1;
    }
    vector<int> searchRange(vector<int>& nums, int target) {
        return vector({left_bound(nums, target), right_bound(nums, target)});
    }
};
// @lc code=end

