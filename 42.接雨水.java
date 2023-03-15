
/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] 接雨水
 */
import java.util.*;

// @lc code=start
class Solution {
    public int trap(int[] height) {
        // int lMax = 0, rMax = 0, left = 0, right = height.length - 1;
        // int res = 0;
        // while (left < right) {
        // lMax = Math.max(lMax, height[left]);
        // rMax = Math.max(rMax, height[right]);
        // if (lMax < rMax) {
        // res += lMax - height[left];
        // left++;
        // } else {
        // res += rMax - height[right];
        // right--;
        // }
        // }
        // return res;

        // Monotomous Stack
        int ans = 0;
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            while (!st.empty() && height[st.peek()] < height[i]) {
                int topHeight = height[st.pop()];
                if (st.isEmpty())
                    break;
                int left = st.peek(), leftHeight = height[left];
                int h = Math.min(leftHeight, height[i]) - topHeight;
                int width = i - left - 1;
                ans += h * width;
            }
            st.push(i);
        }
        return ans;
    }
}
// @lc code=end
