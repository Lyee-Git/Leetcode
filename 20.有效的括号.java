/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 */
import java.util.*;
// @lc code=start
class Solution {
    public boolean isValid(String s) {
        HashMap<Character, Character> match = new HashMap<>() {{
            put (')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (match.containsValue(s.charAt(i)))
                st.push(s.charAt(i));
            else {
                if (st.empty() || st.pop() != match.get(s.charAt(i)))
                    return false;
            }
        }
        return st.empty();
    }
}
// @lc code=end

