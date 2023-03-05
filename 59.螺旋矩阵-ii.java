/*
 * @lc app=leetcode.cn id=59 lang=java
 *
 * [59] 螺旋矩阵 II
 */

// @lc code=start
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int number = 1;
        int upper_bound = 0, lower_bound = n - 1;
        int left_bound = 0, right_bound = n - 1;
        while (number <= n * n) {
            if (upper_bound <= lower_bound) {
                for (int i = left_bound; i <= right_bound; i++) {
                    matrix[upper_bound][i] = number++;
                }
                upper_bound++;
            }
            if (right_bound >= left_bound) {
                for (int i = upper_bound; i <= lower_bound; i++) {
                    matrix[i][right_bound] = number++;
                }
                right_bound--;
            }
            if (lower_bound >= upper_bound) {
                for (int i = right_bound; i >= left_bound; i--) {
                    matrix[lower_bound][i] = number++;
                }
                lower_bound--;
            }
            if (right_bound >= left_bound) {
                for (int i = lower_bound; i >= upper_bound; i--) {
                    matrix[i][left_bound] = number++;
                }
                left_bound++;
            }
        }
        return matrix;
    }
}
// @lc code=end
