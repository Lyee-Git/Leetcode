
/*
 * @lc app=leetcode.cn id=785 lang=java
 *
 * [785] 判断二分图
 */
import java.util.*;

// @lc code=start
class Solution {
    int n;
    boolean[] color;
    boolean[] visited;
    boolean result;
    int[][] graph;

    public boolean isBipartite(int[][] graph) {
        this.n = graph.length;
        this.color = new boolean[n];
        this.visited = new boolean[n];
        this.graph = graph;
        this.result = true;
        for (int i = 0; i < n; i++) {
            if (!result) 
                break;
            if (visited[i] == false) {
                dfs(i);
            }
        }
        return result;
    }

    private void dfs(int u) {
        if (visited[u]) {
            return;
        }
        visited[u] = true;
        for (int v : graph[u]) {
            if (!result)
                return;
            if (visited[v]) {
                if (color[v] == color[u]) {
                    result = false;
                    return;
                }
            } else {
                color[v] = !color[u];
                dfs(v);
            }
        }
    }
}
// @lc code=end
