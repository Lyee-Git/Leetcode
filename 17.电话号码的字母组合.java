/*
 * @lc app=leetcode.cn id=17 lang=java
 *
 * [17] 电话号码的字母组合
 */
import java.util.*;
// @lc code=start
class Solution {
    List<String> res = new LinkedList<>();
    String[] mapping = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty())
            return res;
        backtrack(digits, 0, new StringBuilder());
        return res;
    }

    void backtrack(String digits, int start, StringBuilder sb) {
        if (sb.length() == digits.length())
            res.add(sb.toString());
        if (start >= 0 && start < digits.length()) {
            int digit = digits.charAt(start) - '0';
            for (char c : mapping[digit].toCharArray()) {
                sb.append(c);
                backtrack(digits, start + 1, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
// @lc code=end

