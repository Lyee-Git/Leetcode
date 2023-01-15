/*
 * @lc app=leetcode.cn id=947 lang=cpp
 *
 * [947] 移除最多的同行或同列石头
 */
#include<vector>
#include<iostream>
#include<limits.h>
#include<algorithm>
#include<unordered_map>
using namespace std;
// @lc code=start
class UnionFindSet
{
public:
    unordered_map<int, int> parent;
    int countCC;
    UnionFindSet(int n): countCC(0) {}
    void UnionSets(int a, int b)
    {
        int roota = Find(a), rootb = Find(b);
        if (roota == rootb)
            return;
        if (parent[roota] > parent[rootb])
            swap(roota, rootb);
        parent[roota] += parent[rootb];
        parent[rootb] = roota;
        countCC--;
    }

    int Find(int a)
    {
        if (!parent.count(a))
        {
            parent[a] = -1;
            countCC++;
        }
        int root, temp;
        for (root = a; parent[root] >= 0; root = parent[root]);
        while (a != root)
        {
            temp = parent[a];
            parent[a] = root;
            a = temp;
        }
        return root;
    }   
};

// Answer #1: UnionFind
// class Solution {
// public:
//     int removeStones(vector<vector<int>>& stones) {
//         int n = stones.size();
//         UnionFindSet UFSet(n);
//         for (auto& vec : stones)
//             UFSet.UnionSets(vec[0], vec[1] + 10001);
//         return n - UFSet.countCC;
//     }
// };

// Answer #2: DFS
// Bad Preformance spatially
class Solution {
public:
    void DFS(int i, vector<vector<int>>& edge, vector<int>& visited)
    {
        visited[i] = 1;
        for (auto j : edge[i])
        {
            if (!visited[j])
                DFS(j, edge, visited);
        }
    }

    int removeStones(vector<vector<int>>& stones) {
        int n = stones.size(), countCC = 0;
        vector<vector<int>> edge(n);
        unordered_map<int, vector<int>> link;
        for (int i = 0; i < n; i++)
        {
            link[stones[i][0]].emplace_back(i);
            link[stones[i][1] + 10001].emplace_back(i);
        }
        for (auto& [a, vec] : link)
        {
            int m = vec.size();
            for (int i = 1; i < m; i++)
            {
                edge[vec[i]].emplace_back(vec[i - 1]);
                edge[vec[i - 1]].emplace_back(vec[i]);
            }
        }
        vector<int> visited(n, 0);
        for (int i = 0; i < n; i++)
        {
            if (!visited[i])
            {
                countCC++;
                DFS(i, edge, visited);
            }
        }
        return n - countCC;
    }
};
// @lc code=end

