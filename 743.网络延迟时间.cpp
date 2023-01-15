/*
 * @lc app=leetcode.cn id=743 lang=cpp
 *
 * [743] 网络延迟时间
 */
#include<string>
#include<algorithm>
#include<vector>
#include<queue>
#include<limits.h>
using namespace std;
// @lc code=start
class Solution {
public:
    using edge = pair<int, int>;
    vector<vector<edge>> graph;
    int Dijstra(int n, int k)
    {
        vector<int> minDist(n + 1, INT_MAX / 2);
        vector<int> visited(n + 1, 0);
        priority_queue<edge, vector<edge>, greater<edge>> heap;
        minDist[k] = 0;
        heap.emplace(0, k);
        while (!heap.empty()) {
            edge e = heap.top();
            heap.pop();
            int u = e.second;
            if (visited[u])
                continue;
            visited[u] = 1;
            for (int i = 0; i < graph[u].size(); i++) {
                int v = graph[u][i].second;
                int weight = graph[u][i].first;
                if (!visited[v] && minDist[u] + weight < minDist[v]) {
                    minDist[v] = minDist[u] + weight;
                    heap.emplace(minDist[v], v);
                }
            }
        }
        int res = -1;
        for (int i = 1; i <= n; i++) {
            int dist = minDist[i];
            if (dist == INT_MAX / 2) {
                res = -1;
                break;
            }
            if (dist > res && dist != 0)
                res = dist;
        }
        return res;
    }

    int networkDelayTime(vector<vector<int>>& times, int n, int k) {
        graph.resize(n + 1);
        for (auto& conn : times) {
            graph[conn[0]].emplace_back(make_pair(conn[2], conn[1]));
        }
        int result = Dijstra(n, k);
        return result;
    }
};
// @lc code=end

