
/*
 * @lc app=leetcode.cn id=787 lang=java
 *
 * [787] K 站中转内最便宜的航班
 */
import java.util.*;

// 状态的数量为 O(nk)
// @lc code=start
class Solution {
    int src, dst;
    HashMap<Integer, List<int[]>> inDegree;
    int[][] memo;

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        k++; // 最多经过 k 站中转的路线 -> k+1次航班
        this.src = src;
        this.dst = dst;
        this.inDegree = new HashMap<>();
        this.memo = new int[n][k + 1];
        for (int[] flight : flights) {
            int from = flight[0], to = flight[1];
            int price = flight[2];
            inDegree.putIfAbsent(to, new LinkedList<>());
            inDegree.get(to).add(new int[] { from, price });
        }
        for (int i = 0; i < n; i++)
            Arrays.fill(memo[i], -2);
        return dp(dst, k);
    }

    // 返回目的地为dst, 允许k次航班下的最小价格
    private int dp(int dst, int k) {
        if (dst == this.src)
            return 0;
        if (k == 0)
            return -1;
        if (memo[dst][k] != -2) {
            return memo[dst][k];
        }
        int cost = Integer.MAX_VALUE;
        if (inDegree.containsKey(dst)) {
            List<int[]> ins = inDegree.get(dst);
            for (int[] in : ins) {
                int from = in[0], price = in[1];
                int lastFlight = dp(from, k - 1);
                if (lastFlight != -1) {
                    cost = Math.min(cost, lastFlight + price);
                }
            }
        }
        memo[dst][k] = cost == Integer.MAX_VALUE ? -1 : cost;
        return memo[dst][k];
    }
}
// @lc code=end
