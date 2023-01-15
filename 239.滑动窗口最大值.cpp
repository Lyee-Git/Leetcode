/*
 * @lc app=leetcode.cn id=239 lang=cpp
 *
 * [239] 滑动窗口最大值
 */
#include<string>
#include<algorithm>
#include<vector>
#include<deque>
#include<limits.h>
using namespace std;
// @lc code=start
class Solution {
private:
    class MonotonicQueue {
    private:
         deque<int> que;
         int min_elem = INT_MAX;
    public:
        void push(int n){
            while (!que.empty() && que.back() < n) {
                int back_elem = que.back();
                que.pop_back();
                min_elem = min(min_elem, back_elem);
            }
            que.emplace_back(n);
        }
        void pop(int n) {
            if (!que.empty() && que.front() == n)
                que.pop_front();
        }
        int maxElem() { return que.front(); }
        int minElem() { return min_elem; }
    };
public:
    vector<int> maxSlidingWindow(vector<int>& nums, int k) {
        MonotonicQueue q;
        vector<int> res;
        for (int i = 0; i < k; i++) {
            q.push(nums[i]);
        }
        res.emplace_back(q.maxElem());
        for (int i = k; i < nums.size(); i++) {
            q.push(nums[i]);
            q.pop(nums[i - k]);
            res.emplace_back(q.maxElem());
        }
        return res;
    }
};
// @lc code=end

