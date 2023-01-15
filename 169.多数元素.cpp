/*
 * @lc app=leetcode.cn id=169 lang=cpp
 *
 * [169] 多数元素
 */
#include<vector>
#include<iostream>
#include<limits.h>
#include<queue>
using namespace std;
// @lc code=start
class Solution {
public:
    int count_in_range(vector<int>& nums, int target, int lo, int hi) {
        int count = 0;
        for (int i = lo; i <= hi; ++i)
            if (nums[i] == target)
                ++count;
        return count;
    }

    int findMajority(vector<int>& nums, int lo, int hi)
    {
        if (lo == hi)
            return nums[lo];
        int mid = (lo + hi) >> 1;
        int left = findMajority(nums, lo, mid);
        int right = findMajority(nums, mid + 1, hi);
        if (count_in_range(nums, left, lo, hi) > (hi - lo + 1) / 2)
            return left;
        if (count_in_range(nums, right, lo, hi) > (hi - lo + 1) / 2)
            return right;
        return -1;
    }

    int majorityElement(vector<int>& nums) {
        //return findMajority(nums, 0, nums.size() - 1);

        // Answer #2: Moore Voting
        int candidate = -1;
        int count = 0;
        for (int num : nums) {
            if (num == candidate)
                ++count;
            else if (--count < 0) {
                candidate = num;
                count = 1;
            }
        }
        return candidate;
    }

};
// @lc code=end

