import java.util.Arrays;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=1631 lang=java
 *
 * [1631] 最小体力消耗路径
 */

// @lc code=start
class Solution {
    int[][] dirs = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    public int minimumEffortPath(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        final int INF = Integer.MAX_VALUE / 2;
        int res = -1;
        int[][] minCost = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++)
            Arrays.fill(minCost[i], INF);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return a[2] - b[2];
        });
        pq.offer(new int[] { 0, 0, 0 });
        minCost[0][0] = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (visited[cur[0]][cur[1]])
                continue;
            visited[cur[0]][cur[1]] = true;
            if (cur[0] == m - 1 && cur[1] == n - 1)
                return minCost[cur[0]][cur[1]];
            for (int[] dir : dirs) {
                int nextX = cur[0] + dir[0];
                int nextY = cur[1] + dir[1];
                if (nextX < 0 || nextX >= m || nextY < 0
                        || nextY >= n || visited[nextX][nextY])
                    continue;
                int newCost = Math.abs(heights[cur[0]][cur[1]] - heights[nextX][nextY]);
                int maxCost = Math.max(newCost, minCost[cur[0]][cur[1]]);
                if (maxCost < minCost[nextX][nextY]) {
                    minCost[nextX][nextY] = maxCost;
                    pq.offer(new int[] { nextX, nextY, maxCost });
                }
            }
        }
        return res;
    }
}
// @lc code=end
