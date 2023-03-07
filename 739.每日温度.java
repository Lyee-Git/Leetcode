/*
 * @lc app=leetcode.cn id=739 lang=java
 *
 * [739] 每日温度
 */
import java.util.*;
// @lc code=start
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] greaterIndex = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && temperatures[st.peek()] <= temperatures[i]) {
                st.pop();
            }
            greaterIndex[i] = st.empty() ? 0 : st.peek() - i;
            st.push(i);
        }
        return greaterIndex;
    }
}
// @lc code=end

