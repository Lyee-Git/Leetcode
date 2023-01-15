/*
 * @lc app=leetcode.cn id=79 lang=java
 *
 * [79] 单词搜索
 */

// @lc code=start
class Solution {
    final static int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    String s;
    char[][] board;
    boolean[][] visited;
    int m, n;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        m = board.length;
        n = board[0].length;
        s = word;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(i, j, 0))
                    return true;
            }
        }
        return false;
    }

    boolean dfs(int i, int j, int k) {
        if (board[i][j] != s.charAt(k)) {
            return false;
        }
        else if (k == s.length() - 1)
            return true;
        visited[i][j] = true;
        for (int[] direction : directions) {
            int h = i + direction[0], w = j + direction[1];
            if (h < 0 || h >= m || w < 0 || w >= n || visited[h][w]) {
                continue;
            }
            if (dfs(h, w, k + 1))
                return true;
        }
        visited[i][j] = false;
        return false;
    }
}
// @lc code=end
