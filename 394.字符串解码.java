
/*
 * @lc app=leetcode.cn id=394 lang=java
 *
 * [394] 字符串解码
 */
import java.util.*;

// @lc code=start
class Solution {
    public String decodeString(String s) {
        LinkedList<String> st = new LinkedList<>();
        char[] chars = s.toCharArray();
        int n = chars.length;
        for (int i = 0; i < n; i++) {
            char c = chars[i];
            if (Character.isDigit(c)) {
                StringBuilder sb = new StringBuilder();
                sb.append(c);
                while (Character.isDigit(chars[i + 1])) {
                    sb.append(chars[i + 1]);
                    i++;
                }
                st.addLast(sb.toString());
            } else if (Character.isLetter(c) || c == '[') {
                st.addLast(String.valueOf(c));
            } else {
                LinkedList<String> curList = new LinkedList<>();
                while (!st.isEmpty() && Character.isLetter(st.peekLast().charAt(0))) {
                    curList.addLast(st.removeLast());
                }
                Collections.reverse(curList);
                String curString = toString(curList);
                st.removeLast(); // "["
                int times = Integer.valueOf(st.removeLast());
                while (times-- > 0) {
                    st.addLast(curString);
                }
            }
        }
        return toString(st);
    }

    public String toString(LinkedList<String> list) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
        }
        return sb.toString();
    }

    // public String decodeString(String s) {
    // Stack<Character> st = new Stack<>();
    // for (char c : s.toCharArray()) {
    // if (c != ']') {
    // st.push(c);
    // } else {
    // StringBuilder sb = new StringBuilder();
    // while (!st.isEmpty() && Character.isLetter(st.peek())) {
    // sb.append(st.pop());
    // }
    // st.pop();
    // StringBuilder sbNum = new StringBuilder();
    // while (!st.isEmpty() && Character.isDigit(st.peek())) {
    // sbNum.insert(0, st.pop());
    // }
    // int times = Integer.parseInt(sbNum.toString());
    // while (times > 0) {
    // for (int i = sb.length() - 1; i >= 0; i--) {
    // st.push(sb.charAt(i));
    // }
    // times--;
    // }
    // }
    // }
    // StringBuilder sb = new StringBuilder();
    // while (!st.isEmpty()) {
    // sb.insert(0, st.pop());
    // }
    // return sb.toString();
    // }
}
// @lc code=end
