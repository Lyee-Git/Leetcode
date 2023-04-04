/*
 * @lc app=leetcode.cn id=242 lang=java
 *
 * [242] 有效的字母异位词
 */
import java.util.*;;
// @lc code=start
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        HashMap<Character, Integer> count = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            count.put(sChar, count.getOrDefault(sChar, 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            char tChar = t.charAt(i);
            count.put(tChar, count.getOrDefault(tChar, 0) - 1);
            if (count.get(tChar) < 0)
                return false;
        }
        return true;
    }
}
// @lc code=end

