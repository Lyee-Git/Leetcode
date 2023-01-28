
/*
 * @lc app=leetcode.cn id=990 lang=java
 *
 * [990] 等式方程的可满足性
 */

// @lc code=start
class Solution {
    public boolean equationsPossible(String[] equations) {
        UF uf = new UF(26);
        for (String equation : equations) {
            int a = equation.charAt(0) - 'a';
            int b = equation.charAt(3) - 'a';
            if (equation.charAt(1) == '=') {
                uf.union(a, b);
            }
        }
        for (String equation : equations) {
            int a = equation.charAt(0) - 'a';
            int b = equation.charAt(3) - 'a';
            if (equation.charAt(1) == '!') {
                if (uf.check(a, b))
                    return false;
            }
        }
        return true;
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
