/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 */
import java.util.*;
// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0;
        int lenSubStr = 0;
        while (right < s.length()) {
            char cur = s.charAt(right);
            right++;
            window.put(cur, window.getOrDefault(cur, 0) + 1);
            while (window.get(cur) > 1) {
                char shrink = s.charAt(left);
                left++;
                if (window.containsKey(shrink)) {
                    window.put(shrink, window.get(shrink) - 1);
                }
            }
            lenSubStr = Math.max(lenSubStr, right - left);
        }
        return lenSubStr;
    }
}
// @lc code=end

