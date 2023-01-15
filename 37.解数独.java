/*
 * @lc app=leetcode.cn id=37 lang=java
 *
 * [37] 解数独
 */

// @lc code=start
class Solution {
    int m = 9, n = 9;
    public void solveSudoku(char[][] board) {
        backtrack(board, 0, 0);
    }

    boolean backtrack(char[][] board, int r, int c) {
        if (r == m)
            return true;
        if (c == n) {
            return backtrack(board, r + 1, 0);
        }
        if (board[r][c] != '.') {
            return backtrack(board, r, c + 1);
        }

        for (char num = '1'; num <= '9'; num++) {
            if (isValid(board, r, c, num)) {
                board[r][c] = num;
                if (backtrack(board, r, c + 1))
                    return true;
                board[r][c] = '.';
            }
        }
        return false;
    }

    boolean isValid(char[][] board, int r, int c, char num) {
        for (int i = 0; i < 9; i++) {
            if (board[r][i] == num)
                return false;
            if (board[i][c] == num)
                return false;
            if (board[r / 3 * 3 + i / 3][c / 3 * 3 + i % 3] == num)
                return false;
        }
        return true;
    }
}
// @lc code=end

