/*
 * @lc app=leetcode.cn id=765 lang=java
 *
 * [765] 情侣牵手
 */

// @lc code=start
class Solution {
    public int minSwapsCouples(int[] row) {
        int n = row.length / 2;
        UF uf = new UF(n);
        // 每个连通域若有N对情侣处于交错搭配状态，则至少需要N - 1次交换
        // 故总共需要 n - m次交换，m为连通域数量
        for (int i = 0; i < 2 * n; i += 2) {
            uf.union(row[i] / 2, row[i + 1] / 2);
        }
        return n - uf.count;
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
// @lc code=end
