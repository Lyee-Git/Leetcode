
/*
 * @lc app=leetcode.cn id=438 lang=java
 *
 * [438] 找到字符串中所有字母异位词
 */
import java.util.*;

// @lc code=start
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character, Integer> need = new HashMap<>(), window = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        List<Integer> res = new LinkedList<>();
        int left = 0, right = 0, validNum = 0;
        while (right < s.length()) {
            char cur = s.charAt(right);
            right++;
            if (need.containsKey(cur)) {
                window.put(cur, window.getOrDefault(cur, 0) + 1);
                if (window.get(cur).equals(need.get(cur)))
                    validNum++;
            }
            while (right - left == p.length()) {
                if (validNum == need.size()) {
                    res.add(left);
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
        return res;
    }
}
// @lc code=end
