/*
 * @lc app=leetcode.cn id=60 lang=java
 *
 * [60] 排列序列
 */

// @lc code=start
class Solution {
    int[] factorial;
    boolean[] used;
    public static final int MAXN = 9;

    public String getPermutation(int n, int k) {
        factorial = new int[MAXN + 1];
        used = new boolean[n + 1];
        calculateFac(MAXN + 1);
        StringBuilder path = new StringBuilder();
        dfs(0, path, n, k);
        return path.toString();
    }

    public void dfs(int index, StringBuilder path, int n, int k) {
        if (index == n) {
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (used[i]) {
                continue;
            }
            int numPermutations = factorial[n - 1 - index];
            if (k > numPermutations) {
                k -= numPermutations;
                continue;
            }
            path.append(String.valueOf(i));
            used[i] = true;
            dfs(index + 1, path, n, k);
            return; // O(N*2), N*N, no backtracking here
        }
    }

    public void calculateFac(int n) {
        factorial[0] = 1;
        for (int i = 1; i < n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }
    }
}
// @lc code=end
