
/*
 * @lc app=leetcode.cn id=54 lang=java
 *
 * [54] 螺旋矩阵
 */
import java.util.*;

// @lc code=start
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int upper_bound = 0, lower_bound = m - 1; 
        int left_bound = 0, right_bound = n - 1;
        List<Integer> res = new LinkedList<>();
        while (res.size() < m * n) {
            if (upper_bound <= lower_bound) {
                for (int i = left_bound; i <= right_bound; i++) {
                    res.add(matrix[upper_bound][i]);
                }
                upper_bound++;
            }
            if (right_bound >= left_bound) {
                for (int i = upper_bound; i <= lower_bound; i++) {
                    res.add(matrix[i][right_bound]);
                }
                right_bound--;
            }
            if (lower_bound >= upper_bound) {
                for (int i = right_bound; i >= left_bound; i--) {
                    res.add(matrix[lower_bound][i]);
                }
                lower_bound--;
            }
            if (right_bound >= left_bound) {
                for (int i = lower_bound; i >= upper_bound; i--) {
                    res.add(matrix[i][left_bound]);
                }
                left_bound++;
            }
        }
        return res;
    }
}
// @lc code=end
