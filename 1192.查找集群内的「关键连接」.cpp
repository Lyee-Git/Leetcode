/*
 * @lc app=leetcode.cn id=1192 lang=cpp
 *
 * [1192] 查找集群内的「关键连接」
 */
#include <vector>
#include <algorithm>
using namespace std;
// @lc code=start
class Solution
{
public:
    int time = 1;
    vector<vector<int>> bridge;
    vector<int> discoverTime;
    vector<int> back;
    vector<int> father;
    vector<vector<int>> edge;
    void tarjan(int u)
    {
        discoverTime[u] = time++;
        back[u] = discoverTime[u];
        for (auto v : edge[u])
        {
            if (!discoverTime[v])
            {
                father[v] = u;
                tarjan(v);
                back[u] = min(back[u], back[v]);
                if (back[v] > discoverTime[u])
                    bridge.push_back({u, v});
            }
            else if (v != father[u])
                back[u] = min(back[u], discoverTime[v]);
        }
    }

    vector<vector<int>> criticalConnections(int n, vector<vector<int>> &connections)
    {
        discoverTime.resize(n);
        edge.resize(n);
        father.resize(n);
        back.resize(n);
        for (auto it : connections)
        {
            edge[it[0]].emplace_back(it[1]);
            edge[it[1]].emplace_back(it[0]);
        }
        tarjan(1);
        return bridge;
    }
};
// @lc code=end
