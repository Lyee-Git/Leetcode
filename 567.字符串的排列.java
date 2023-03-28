
/*
 * @lc app=leetcode.cn id=567 lang=java
 *
 * [567] 字符串的排列
 */
import java.util.*;

// @lc code=start
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> need = new HashMap<>(), window = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0, validNum = 0;
        while (right < s2.length()) {
            char cur = s2.charAt(right);
            right++;
            if (need.containsKey(cur)) {
                window.put(cur, window.getOrDefault(cur, 0) + 1);
                if (need.get(cur).equals(window.get(cur)))
                    validNum++;
                if (validNum == need.size())
                    return true;
            }
            while (right - left >= s1.length()) {
                char shrink = s2.charAt(left);
                if (need.containsKey(shrink)) {
                    // Use equals method when comparing two Integer objects
                    // Only return right answer for -128~127 when using "==" with Integer cache
                    if (window.get(shrink).equals(need.get(shrink))) {
                        validNum--;
                    }
                    window.put(shrink, window.get(shrink) - 1);
                }
                left++;
            }
        }
        return false;
    }
}
// @lc code=end
