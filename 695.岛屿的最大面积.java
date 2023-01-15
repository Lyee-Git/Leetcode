/*
 * @lc app=leetcode.cn id=695 lang=java
 *
 * [695] 岛屿的最大面积
 */

// @lc code=start
class Solution {
    int m, n;

    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        m = grid.length;
        n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    res = Math.max(dfs(grid, i, j), res);
                }
            }
        }
        return res;
    }

    int dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == 0)
            return 0;
        grid[i][j] = 0;
        return dfs(grid, i, j + 1) +
                dfs(grid, i, j - 1) +
                dfs(grid, i - 1, j) +
                dfs(grid, i + 1, j) + 1;
    }
}
// @lc code=end
