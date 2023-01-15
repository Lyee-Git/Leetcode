/*
 * @lc app=leetcode.cn id=11 lang=cpp
 *
 * [11] 盛最多水的容器
 */
#include<iostream>
#include<vector>
#include<algorithm>
#include<limits.h>
using namespace std;
// @lc code=start
class Solution {
public:
    int maxArea(vector<int>& height) {
        int left = 0, right = height.size() - 1, width = right - left;
        int maxArea = width * min(height[left], height[right]);
        while (left < right)
        {
            if (height[left] < height[right]) {
                left++;
                width--;
                maxArea = max(maxArea, min(height[left], height[right]) * width);
            }
            else {
                right--;
                width--;
                maxArea = max(maxArea, min(height[left], height[right]) * width);
            }
        }
        return maxArea;
    }
};
// @lc code=end

