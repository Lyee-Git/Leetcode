/*
 * @lc app=leetcode.cn id=51 lang=java
 *
 * [51] N 皇后
 */
import java.util.*;
// @lc code=start
class Solution {
    List<List<String>> res = new LinkedList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (char[] b : board)
            Arrays.fill(b, '.');
        backtrack(board, 0, n);
        return res;
    }

    private void backtrack(char[][] board, int row, int n) {
        if (row == n) {
            res.add(arr2List(board));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isValid(board, row, col, n)) {
                board[row][col] = 'Q';
                backtrack(board, row + 1, n);
                board[row][col] = '.';
            }
        }
    }

    boolean isValid(char[][] board, int row, int col, int n) {
        // 检查同列
        for (int i = 0 ; i < row; i++) {
            if (board[i][col] == 'Q')
                return false;
        }
        // 检查左上方
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0;  i--, j--) {
            if (board[i][j] == 'Q')
                return false;
        }
        // 检查右上方
        for (int i = row - 1, j = col + 1; i >= 0 && j < n;  i--, j++) {
            if (board[i][j] == 'Q')
                return false;
        }
        return true;
    }

    private List<String> arr2List(char[][] arr) {
        List<String> res = new ArrayList<>();
        for (char[] a : arr) {
            res.add(String.copyValueOf(a));
        }
        return res;
    }
}
// @lc code=end

