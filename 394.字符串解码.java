/*
 * @lc app=leetcode.cn id=394 lang=java
 *
 * [394] 字符串解码
 */
import java.util.*;
// @lc code=start
class Solution {
    public String decodeString(String s) {
        Stack<Character> st = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c != ']') {
                st.push(c);
            } else {
                StringBuilder sb = new StringBuilder();
                while (!st.isEmpty() && Character.isLetter(st.peek())) {
                    sb.append(st.pop());
                }
                st.pop();
                StringBuilder sbNum = new StringBuilder();
                while (!st.isEmpty() && Character.isDigit(st.peek())) {
                    sbNum.insert(0, st.pop());
                }
                int times = Integer.parseInt(sbNum.toString());
                while (times > 0) {
                    for (int i = sb.length() - 1; i >= 0; i--) {
                        st.push(sb.charAt(i));
                    }
                    times--;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.insert(0, st.pop());
        }
        return sb.toString();
    }
}
// @lc code=end

