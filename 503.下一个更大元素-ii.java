
/*
 * @lc app=leetcode.cn id=503 lang=java
 *
 * [503] 下一个更大元素 II
 */
// 给定一个循环数组 nums（ nums[nums.length - 1]的下一个元素是 nums[0] ）
// 返回 nums 中每个元素的 下一个更大元素 。
//数字 x 的 下一个更大的元素 是按数组遍历顺序，
// 这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。
// @lc code=start
import java.util.*;

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        // 思路：扩容数组，复制一份数组元素插入在其后
        int n = nums.length;
        int[] greater = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 2 * n - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() <= nums[i % n]) {
                st.pop();
            }
            greater[i % n] = st.empty() ? -1 : st.peek();
            st.push(nums[i % n]);
        }
        return greater;
    }
}
// @lc code=end
