
/*
 * @lc app=leetcode.cn id=84 lang=java
 *
 * [84] 柱状图中最大的矩形
 */
import java.util.*;

// @lc code=start
class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        if (n == 1)
            return heights[0];
        Stack<Integer> st = new Stack<>();
        // Array left and right stores index of nearest smaller pillar
        // in the left/right side of each element
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(right, n);
        for (int i = 0; i < n; i++) {
            int height = heights[i];
            while (!st.isEmpty() && heights[st.peek()] >= height) {
                int cur = st.pop();
                right[cur] = i;
            }
            left[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, heights[i] * (right[i] - left[i] - 1));
        }
        return res;
    }
}
// @lc code=end
