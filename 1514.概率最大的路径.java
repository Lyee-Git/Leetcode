
/*
 * @lc app=leetcode.cn id=1514 lang=java
 *
 * [1514] 概率最大的路径
 */
import java.util.*;

// @lc code=start
class Solution {
    class State {
        int to;
        double prob;

        public State(int to, double prob) {
            this.to = to;
            this.prob = prob;
        }
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        LinkedList<State>[] graph = new LinkedList[n];
        double res = 0;
        for (int i = 0; i < n; i++)
            graph[i] = new LinkedList<>();
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            graph[edge[0]].addLast(new State(edge[1], succProb[i]));
            graph[edge[1]].addLast(new State(edge[0], succProb[i]));
        }
        boolean[] visited = new boolean[n];
        PriorityQueue<State> pq = new PriorityQueue<>((a, b) -> {
            return Double.compare(b.prob, a.prob);
        });
        double[] maxProb = new double[n];
        Arrays.fill(maxProb, -1);
        maxProb[start] = 1;
        pq.offer(new State(start, 1));
        while (!pq.isEmpty()) {
            State cur = pq.poll();
            int u = cur.to;
            if (visited[u])
                continue;
            visited[u] = false;
            if (u == end)
                return maxProb[u];
            for (State s : graph[u]) {
                int v = s.to;
                if (visited[v])
                    continue;
                double newProb = maxProb[u] * s.prob;
                if (newProb > maxProb[v]) {
                    maxProb[v] = newProb;
                    pq.offer(new State(v, newProb));
                }
            }
        }
        return res;
    }
}
// @lc code=end
