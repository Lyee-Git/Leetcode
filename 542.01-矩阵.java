
/*
 * @lc app=leetcode.cn id=542 lang=java
 *
 * [542] 01 矩阵
 */
import java.util.*;

// @lc code=start
class Solution {
    static final int[][] dirs = new int[][] { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };

    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] dist = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[] { i, j });
                    visited[i][j] = true;
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1];
            for (int[] dir : dirs) {
                int neighX = x + dir[0], neighY = y + dir[1];
                if (neighX >= 0 && neighX < m && neighY >= 0 &&
                        neighY < n && !visited[neighX][neighY]) {
                    visited[neighX][neighY] = true;
                    dist[neighX][neighY] = dist[x][y] + 1;
                    queue.offer(new int[] {neighX, neighY});
                }
            }
        }
        return dist;
    }
}
// @lc code=end
