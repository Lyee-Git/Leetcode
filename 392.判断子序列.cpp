// @before-stub-for-debug-begin
// #include <vector>
// #include <string>
// #include "commoncppproblem392.h"

// using namespace std;
// @before-stub-for-debug-end

/*
 * @lc app=leetcode.cn id=392 lang=cpp
 *
 * [392] 判断子序列
 */
#include<vector>
#include<iostream>
#include<limits.h>
#include<string>
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
        return nums[lo];
    }

    bool isSubsequence(string s, string t) {
        // A65 a97
        int m = s.size(), n = t.size();
        vector<vector<int>> index(59, vector<int>());
        for (int i = 0; i < n; i++) {
            index[t[i] - 'A'].emplace_back(i);
        }
        int j = 0;
        for (int i = 0; i < m; i++) {
            char c = s[i];
            if (index[c - 'A'].empty())
                return false;
            int search = left_bound(index[c - 'A'], j);
            if (search == -1)
                return false;
            j = search + 1;
        }
        return true;
    }
};
// @lc code=end

