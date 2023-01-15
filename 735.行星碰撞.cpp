/*
 * @lc app=leetcode.cn id=735 lang=cpp
 *
 * [735] 行星碰撞
 */
#include<stack>
#include<vector>
#include<iostream>
#include<algorithm>
#include<limits.h>
using namespace std;
// @lc code=start
class Solution {
public:
    void PrintInv(stack<int>& sta, vector<int>& res)
    {
        if (sta.empty()) return;
        else { int top = sta.top(); sta.pop(); PrintInv(sta, res); res.emplace_back(top); }
    }
    vector<int> asteroidCollision(vector<int>& asteroids) {
        int n = asteroids.size();
        stack<int> sta;
        sta.push(asteroids[0]);
        for (int i = 1; i < n; i++)
        {
            if (asteroids[i] < 0 && !sta.empty() && sta.top() > 0)
            {    
                while (!sta.empty() && sta.top() > 0 && sta.top() < -asteroids[i])
                    sta.pop();
                if (!sta.empty() && sta.top() == -asteroids[i])
                    sta.pop();
                else if (sta.empty() || sta.top() < 0)
                    sta.push(asteroids[i]);
            }
            else
                sta.push(asteroids[i]);
        }
        vector<int> res;
        PrintInv(sta, res);
        return res;
    }
};
// @lc code=end

