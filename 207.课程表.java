
/*
 * @lc app=leetcode.cn id=207 lang=java
 *
 * [207] 课程表
 */
import java.util.*;

// @lc code=start
class Solution {
    List<List<Integer>> edges;
    int[] visited;
    boolean valid = true;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            edges.get(pre[1]).add(pre[0]);
        }
        visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }
        return valid;
    }

    boolean dfs(int s) {
        visited[s] = 1;
        for (int e : edges.get(s)) {
            if (visited[e] == 1) {
                valid = false;
                return valid;
            }
            if (valid && visited[e] == 0) {
                dfs(e);
                if (valid == false) {
                    return valid;
                }
            }
        }
        visited[s] = 2;
        return valid;
    }
}
// @lc code=end
