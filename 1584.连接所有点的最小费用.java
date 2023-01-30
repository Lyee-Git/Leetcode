
/*
 * @lc app=leetcode.cn id=1584 lang=java
 *
 * [1584] 连接所有点的最小费用
 */
import java.util.*;

// @lc code=start
class Solution {
    LinkedList<int[]>[] graph;
    int n;

    public int minCostConnectPoints(int[][] points) {
        this.n = points.length;
        this.graph = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int weight = Math.abs(points[i][0] - points[j][0]) +
                        Math.abs(points[i][1] - points[j][1]);
                graph[i].addLast(new int[] { j, weight });
                graph[j].addLast(new int[] { i, weight });
            }
        }
        int mst = prim(0);
        return mst;
    }

    int prim(int start) {
        int mst = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return a[1] - b[1];
        });
        boolean[] inMST = new boolean[n];
        int[] lowCost = new int[n];
        for (int i = 0; i < n; i++)
            lowCost[i] = Integer.MAX_VALUE;
        pq.offer(new int[] { 0, 0 });
        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int to = top[0];
            if (inMST[to])
                continue;
            inMST[to] = true;
            mst += top[1];
            for (int i = 0; i < graph[to].size(); i++) {
                int[] w = graph[to].get(i);
                int cut = w[0];
                if (inMST[cut])
                    continue;
                if (w[1] < lowCost[cut]) {
                    lowCost[cut] = w[1];
                    pq.offer(w);
                }
            }
        }
        return mst;
    }
}
// @lc code=end
