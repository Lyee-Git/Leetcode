// @before-stub-for-debug-begin
// #include <vector>
// #include <string>
// #include "commoncppproblem1011.h"

using namespace std;
// @before-stub-for-debug-end

/*
 * @lc app=leetcode.cn id=1011 lang=cpp
 *
 * [1011] 在 D 天内送达包裹的能力
 */
#include<vector>
#include<iostream>
#include<unordered_map>
#include<string>
using namespace std;
// @lc code=start
class Solution {
public:
    int f_days(vector<int>& weights, int cap) {
        int capRemain = cap;
        int days = 0;
        for (int i = 0; i < weights.size();) {
            while (i < weights.size() && capRemain >= weights[i]) {
                capRemain -= weights[i]; // 注意一定按顺序装载包裹
                i++;
            }
            days++;
            capRemain = cap;
        }
        return days;
    }

    int shipWithinDays(vector<int>& weights, int days) {
        int left = 0, right = 0;
        for (int weight : weights) {
            left = max(left, weight); // 最小为包裹重量最小值
            right += weight; // 最大值为重量之和
        }
        while (left <= right) { // 二分求左边界即最小值
                int mid = (left + right) >> 1;
                if (f_days(weights, mid) > days)
                    left = mid + 1;
                else 
                    right = mid - 1;
        }
        return left;
    }
};
// @lc code=end

