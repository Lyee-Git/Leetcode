/*
 * @lc app=leetcode.cn id=151 lang=java
 *
 * [151] 反转字符串中的单词
 */

// @lc code=start
class Solution {
    void reverse(StringBuilder sb, int lo, int hi) {
        while (lo < hi) {
            char temp = sb.charAt(lo);
            sb.setCharAt(lo, sb.charAt(hi));
            sb.setCharAt(hi, temp);
            lo++;
            hi--;
        }
    }

    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        // Trim
        int left = 0, right = s.length() - 1;
        while (left <= right && s.charAt(left) == ' ')
            left++;
        while (left <= right && s.charAt(right) == ' ')
            right--;
        for (int i = left; i <= right; i++) {
            if (s.charAt(i) != ' ')
                sb.append(s.charAt(i));
            else {
                if (sb.charAt(sb.length() - 1) != ' ')
                    sb.append(s.charAt(i));
            }
        }
        int len = sb.length();
        reverse(sb, 0, len - 1);
        // Reverse each word
        for (int i = 0; i < len; i++) {
            int lo = i, hi = lo;
            while (hi < len && sb.charAt(hi) != ' ')
                hi++;
            reverse(sb, lo, hi - 1);
            i = hi;
        }
        return sb.toString();
    }
}
// @lc code=end
