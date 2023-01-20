
/*
 * @lc app=leetcode.cn id=797 lang=java
 *
 * [797] 所有可能的路径
 */
import java.util.*;

// @lc code=start
class Solution {
    int n;
    int[][] graph;
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        n = graph.length;
        this.graph = graph;
        LinkedList<Integer> path = new LinkedList<>();
        dfs(0, path);
        return res;
    }

    void dfs(int start, LinkedList<Integer> path) {
        path.addLast(start);
        if (start == n - 1) {
            res.add(new LinkedList<>(path));
        }
        for (int end : graph[start]) {
            dfs(end, path);
        }
        path.removeLast();
    }
}
// @lc code=end
