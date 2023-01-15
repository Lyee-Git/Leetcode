/*
 * @lc app=leetcode.cn id=1584 lang=cpp
 *
 * [1584] 连接所有点的最小费用
 */
#include<limits.h>
#include<vector>
#include<queue>
#include<math.h>
using namespace std;
// @lc code=start
class Solution {
public:
    int prim(vector<vector<int> >& points, int start) {
        int n = points.size();
        if (n == 0) return 0;
        int res = 0;

        // 将points转化成邻接表
        vector<vector<int> > g(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                g[i].push_back(j);
                g[j].push_back(i);
            }
        }
        
        // 记录V[i]到Vnew的最近距离
        vector<int> lowcost(n, INT_MAX);
        // 记录V[i]是否加入到了Vnew
        vector<int> visited(n, -1);

        // 格式：<距离, 下标>
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<>> pq;
        pq.push(make_pair(0, start));
        
        while (!pq.empty()) {
            auto [dist, i] = pq.top();
            pq.pop();
            if (visited[i] == 0) continue;
            visited[i] = 0;
            res += dist;

            for (int k = 0; k < g[i].size(); k++) {
                int j = g[i][k];
                int w = abs(points[i][0] - points[j][0]) + abs(points[i][1] - points[j][1]);
                if (visited[j] == -1 && lowcost[j] > w) {
                    lowcost[j] = w;
                    pq.push(make_pair(w, j));
                }
            }
        }
        return res;

    }
    int minCostConnectPoints(vector<vector<int>>& points) {
        return prim(points, 0);  
    }
};
// @lc code=end

