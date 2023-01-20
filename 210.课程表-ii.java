/*
 * @lc app=leetcode.cn id=210 lang=java
 *
 * [210] 课程表 II
 */
import java.util.*;
// @lc code=start
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        int[] res = new int[numCourses];
        int index = 0;
        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            edges.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;
        }
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            int out = q.poll();
            for (int e : edges.get(out)) {
                indegree[e]--;
                if (indegree[e] == 0) {
                    q.offer(e);
                }
            }
            res[index++] = out;
        }
        if (index != numCourses) 
            return new int[0];
        else return res;
    }
}
// @lc code=end

