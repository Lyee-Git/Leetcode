// 想象⼀下你是个城市基建规划者，地图上有 N 座城市，它们按以 1 到 N 的次序编号。
// 给你⼀些可连接的选项 conections，其中每个选项 conections[i] = [city1, city2, cost] 表示
// 将城市 city1 和城市 city2 连接所要的成本为 cost（连接是双向的，也就是说城市 city1 和城市 city2
// 相连也同样意味着城市 city2 和城市 city1 相连）。
// 计算使得每对城市都连通的最⼩成本。如果根据已知条件⽆法完成该项任务，则请你返回 -1。

// 输⼊：N = 3, conections = [[1,2,5],[1,3,6],[2,3,1]]
// 输出：6 (5 + 1)
// 解释：
// 选出任意 2 条边都可以连接所有城市，我们从中选取成本最⼩的 2 条。
import java.util.*;

class Solution {
    // Kruskal
    public int minimumCost(int n, int[][] connections) {
        UF uf = new UF(n + 1);
        int mst = 0;
        Arrays.sort(connections, (a, b) -> {
            return a[2] - b[2];
        });
        for (int[] connection : connections) {
            int u = connection[0];
            int v = connection[1];
            if (uf.check(u, v))
                continue;
            mst += connection[2];
            uf.union(u, v);
        }
        return uf.count == 2 ? mst : -1; // 正常情况下0不参与连通，故2个连通分量
    }

    class UF {
        private int[] parents;
        private int[] size;
        public int count;

        public UF(int n) {
            this.count = n;
            parents = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parents[i] = i;
                size[i] = 1;
            }
        }

        public int find(int x) {
            while (x != parents[x]) {
                parents[x] = parents[parents[x]];
                x = parents[x];
            }
            return x;
        }

        public boolean check(int a, int b) {
            return find(a) == find(b);
        }

        public void union(int a, int b) {
            int p = find(a), q = find(b);
            if (p == q)
                return;
            if (size[p] < size[q]) {
                parents[p] = q;
                size[q] += size[p];
            } else {
                parents[q] = p;
                size[p] += size[q];
            }
            count--;
        }
    }
}