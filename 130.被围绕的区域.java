
/*
 * @lc app=leetcode.cn id=130 lang=java
 *
 * [130] 被围绕的区域
 */
import java.util.*;

// @lc code=start
class Solution {
    int m, n;
    char[][] reserve;

    public void solve(char[][] board) {
        m = board.length;
        n = board[0].length;
        reserve = new char[m][n];
        for (int i = 0; i < m; i++) {
            dfs(board, i, 0);
            dfs(board, i, n - 1);
        }
        for (int j = 0; j < n; j++) {
            dfs(board, 0, j);
            dfs(board, m - 1, j);
        }
        for (char[] b : board) {
            Arrays.fill(b, 'X');
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (reserve[i][j] == 'O')
                    board[i][j] = 'O';
            }
        }
    }

    void dfs(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == 'X')
            return;
        reserve[i][j] = 'O';
        grid[i][j] = 'X';
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
    }
}
// @lc code=end
