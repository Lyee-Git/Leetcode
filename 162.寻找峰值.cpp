/*
 * @lc app=leetcode.cn id=162 lang=cpp
 *
 * [162] 寻找峰值
 */
#include<vector>
#include<algorithm>
#include<limits.h>
using namespace std;
// @lc code=start
class Solution {
public: 
    // int findPeak(vector<int>& nums, int lo, int hi)
    // {
    //     if (lo == hi)
    //         return lo;
    //     int mid = (lo + hi) >> 1;
    //     if ((mid == 0 || nums[mid - 1] < nums[mid]) && (mid == nums.size() - 1 || nums[mid] >nums[mid + 1]))
    //     {
    //         return mid;
    //     }
    //     else if (mid && nums[mid - 1] > nums[mid])
    //         return findPeak(nums, lo, mid - 1);
    //     else
    //         return findPeak(nums, mid + 1, hi);
    // }

    // int findPeakElement(vector<int>& nums) {
    //     return findPeak(nums, 0, nums.size() - 1);
    // }

    //Non-Recursive
    int findPeakElement(vector<int>& nums) {
        auto get = [&](int a) -> int{ //[&]: get value nums by reference
            if (a == -1 || a == nums.size())
                return INT_MIN;
            else return nums[a];
        };
         int left = 0, right = nums.size() - 1, ans = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (get(mid - 1) < get(mid) && get(mid) > get(mid + 1)) {
                ans = mid;
                break;
            }
            if (get(mid) < get(mid + 1)) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return ans;
    }
};
// @lc code=end

