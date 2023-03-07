
/*
 * @lc app=leetcode.cn id=496 lang=java
 *
 * [496] 下一个更大元素 I
 */
// nums1中数字 x的下一个更大元素是指 x在nums2中对应位置右侧的第一个比 x大的元素
// nums1是nums2 的子集
import java.util.*;

// @lc code=start
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums2.length;
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[nums1.length];
        HashMap<Integer, Integer> greaterMap = new HashMap<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.empty() && st.peek() <= nums2[i]) {
                st.pop();
            }
            int greater = st.empty() ? -1 : st.peek();
            greaterMap.put(nums2[i], greater);
            st.push(nums2[i]);
        }
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = greaterMap.get(nums1[i]);
        }
        return ans;
    }
}
// @lc code=end
