/*
 * @lc app=leetcode.cn id=410 lang=cpp
 *
 * [410] 分割数组的最大值
 */
#include<string>
#include<algorithm>
#include<vector>
#include<limits.h>
using namespace std;
// @lc code=start
class Solution {
    using ll = long long;
public:
    //DP解法：
    // int splitArray(vector<int>& nums, int m) {
    //     int n = nums.size();
    //     vector<ll> sum(n + 1, 0);
    //     for (int i = 0 ; i < n; i++)
    //         sum[i + 1] = sum[i] + nums[i];
    //     vector<vector<ll>> dp(n + 1, vector<ll>(m + 1, LLONG_MAX));
    //     dp[0][0] = 0;
    //     for (int i = 1; i <= n; i++) {
    //         for (int j = 1; j <= min(i, m); j++) {
    //             for (int k = 0; k < i; k++) {
    //                 dp[i][j] = min(dp[i][j], max(dp[k][j - 1], sum[i] - sum[k]));
    //             }
    //         }
    //     }
    //     return (int)dp[n][m];
    // }
    // 贪心+二分解法： 
    bool checkSum(vector<int> nums, int minSum, int m) {
        int sum = 0, cnt = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (sum + nums[i] > minSum) {
                sum = nums[i];
                cnt++;
            }
            else
                sum += nums[i];
        }
        cnt++;
        return cnt <= m;
    }


    int splitArray(vector<int>& nums, int m) {
        int left = 0, right = 0;
        for (int num : nums) {
            left = max(num, left);
            right += num;
        }
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (!checkSum(nums, mid, m))
                left = mid + 1;
            else 
                right = mid - 1;
        }
        return left;
    }
};
// @lc code=end

