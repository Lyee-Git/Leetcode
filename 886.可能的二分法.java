
/*
 * @lc app=leetcode.cn id=886 lang=java
 *
 * [886] 可能的二分法
 */
import java.util.*;

// @lc code=start
class Solution {
    int n;
    boolean[] color;
    boolean[] visited;
    boolean result;
    LinkedList<Integer>[] graph;

    public boolean possibleBipartition(int n, int[][] dislikes) {
        this.n = n;
        this.color = new boolean[n + 1];
        this.visited = new boolean[n + 1];
        this.graph = new LinkedList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] dislike : dislikes) {
            graph[dislike[0]].add(dislike[1]);
            graph[dislike[1]].add(dislike[0]);
        }
        this.result = true;
        for (int i = 1; i <= n; i++) {
            if (!result)
                break;
            if (visited[i] == false) {
                dfs(i);
            }
        }
        return result;
    }

    void dfs(int u) {
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
