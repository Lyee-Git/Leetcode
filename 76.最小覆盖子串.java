
/*
 * @lc app=leetcode.cn id=76 lang=java
 *
 * [76] 最小覆盖子串
 */
import java.util.*;

// @lc code=start
class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> need = new HashMap<>(),
                window = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0, validNum = 0;
        int subStrLen = Integer.MAX_VALUE, subStrStart = 0;
        while (right < s.length()) {
            char cur = s.charAt(right);
            right++;
            if (need.containsKey(cur)) {
                window.put(cur, window.getOrDefault(cur, 0) + 1);
                if (window.get(cur).equals(need.get(cur))) {
                    validNum++;
                }
            }
            while (validNum == need.size()) {
                if (right - left < subStrLen) {
                    subStrLen = right - left;
                    subStrStart = left;
                }
                char shrink = s.charAt(left);
                left++;
                if (need.containsKey(shrink)) {
                    if (window.get(shrink).equals(need.get(shrink))) {
                        validNum--;
                    }
                    window.put(shrink, window.get(shrink) - 1);
                }
            }
        }
        return subStrLen == Integer.MAX_VALUE ? "" : s.substring(subStrStart, subStrStart + subStrLen);
    }
}
// @lc code=end
