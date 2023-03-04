/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            String sing = palindrome(s, i, i);
            res = res.length() > sing.length() ? res : sing;
            String doub = palindrome(s, i, i + 1);
            res = res.length() > doub.length() ? res : doub;
        }
        return res;
    }

    String palindrome(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(r) == s.charAt(l)) {
            l--;
            r++;
        }
        return s.substring(l + 1, r);
    }
}
// @lc code=end

