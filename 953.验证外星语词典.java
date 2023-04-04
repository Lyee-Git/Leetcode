/*
 * @lc app=leetcode.cn id=953 lang=java
 *
 * [953] 验证外星语词典
 */

// @lc code=start
class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] indexes = new int[26];
        int index = 0;
        for (int i = 0; i < order.length(); i++) {
            char c = order.charAt(i);
            indexes[c - 'a'] = index++;
        }
        String prev = words[0];
        for (int i = 1; i < words.length; i++) {
            String cur = words[i];
            if (cur.length() < prev.length() && prev.substring(0, cur.length()).equals(cur))
                return false;
            for (int j = 0; j < prev.length(); j++) {
                char curChar = cur.charAt(j), prevChar = prev.charAt(j);
                if (indexes[curChar - 'a'] > indexes[prevChar - 'a'])
                    break;
                if (indexes[curChar - 'a'] < indexes[prevChar - 'a'])
                    return false;
            }
            prev = cur;
        }
        return true;
    }
}
// @lc code=end

