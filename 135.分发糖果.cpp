/*
 * @lc app=leetcode.cn id=135 lang=cpp
 *
 * [135] 分发糖果
 */
#include<vector>
using namespace std;
// @lc code=start
class Solution {
public:
    int candy(vector<int>& ratings) {
        int last = 1, incre = 1, decre = 0, len = ratings.size();
        int sum_candy = last;
        for (int i = 1; i < len; i++)
        {
            if (ratings[i] > ratings[i - 1])
            {
                last++;
                sum_candy += last;
                decre = 0;
                incre = last;
                // Wrong Edition here: incre++;
                // When start a new increasing sequence, evaluate incre with 1;
            }
            else if (ratings[i] == ratings[i - 1])
            {
                last = 1;
                sum_candy += last;
                decre = 0;
                incre = 1;
            }
            else
            {
                decre++;
                if (incre == decre)
                    decre++;
                // Wrong edition here: sum_candy += last + decre
                // increment of sum_candy corresponds with decre: 1, 2, 3...
                // When incre == decre, count last element of incresing sequence as decreasing element
                sum_candy += decre;
                last = 1;
            }
        }
        return sum_candy;
    }
};
// @lc code=end

