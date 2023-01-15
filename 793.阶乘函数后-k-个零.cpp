// @before-stub-for-debug-begin
// #include <vector>
// #include <string>
// #include "commoncppproblem793.h"

using namespace std;
// @before-stub-for-debug-end

/*
 * @lc app=leetcode.cn id=793 lang=cpp
 *
 * [793] 阶乘函数后 K 个零
 */
#include<vector>
#include<iostream>
#include<limits.h>
#include<stack>
#include<algorithm>
using namespace std;
using ll = long long;
// @lc code=start
class Solution {
public:
    long long numZeros(long fac) {
        long long result = 0, div = 5;
        while (div <= fac) {
            result += fac / div;
            div *= 5;
        }
        return result;
    }

    long long left_bound(int target) {
        long long lo = 0;
        long long hi = LONG_MAX;
        while (lo <= hi) {
            long long mid = (lo + hi) >> 1;
            if (numZeros(mid) < target)
                lo = mid + 1;
            else if (numZeros(mid) == target)
                hi = mid - 1;
            else 
                hi = mid - 1;
        }
        return lo;
     }

    long long right_bound(int target) {
        long long lo = 0;
        long long hi = LONG_MAX;
        while (lo <= hi) {
            long long mid = (lo + hi) >> 1;
            if (numZeros(mid) <= target)
                lo = mid + 1;
            else
                hi = mid - 1;
        }
        return hi;
    }

    int preimageSizeFZF(int k) {
        long long res = (right_bound(k) - left_bound(k) + 1);
        return res;
    }
};
// @lc code=end

