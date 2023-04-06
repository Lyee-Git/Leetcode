import java.util.*;

class Solution {
    public int maximalRectangle(String[] matrix) {
        if (matrix.length == 0 || matrix[0].length() == 0)
            return 0;
        int m = matrix.length, n = matrix[0].length();
        int[][] heights = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i].charAt(j) == '1') {
                    heights[i][j] = j == 0 ? 1 : heights[i][j - 1] + 1;
                }
            }
        }
        int res = 0;
        for (int j = 0; j < n; j++) {
            int[] left = new int[m];
            int[] right = new int[m];
            Arrays.fill(right, m);
            Stack<Integer> st = new Stack<>();
            for (int i = 0; i < m; i++) {
                int height = heights[i][j];
                while (!st.isEmpty() && heights[st.peek()][j] >= height) {
                    int cur = st.pop();
                    right[cur] = i;
                }
                left[i] = st.isEmpty() ? -1 : st.peek();
                st.push(i);
            }
            for (int i = 0; i < m; i++) {
                res = Math.max(res, heights[i][j] * (right[i] - left[i] - 1));
            }
        }
        return res;
    }
}