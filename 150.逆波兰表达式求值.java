
/*
 * @lc app=leetcode.cn id=150 lang=java
 *
 * [150] 逆波兰表达式求值
 */
import java.util.*;

// @lc code=start
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for (String token : tokens) {
            if (isNumber(token)) {
                st.push(Integer.parseInt(token));
            } else {
                int operand2 = st.pop();
                int operand1 = st.pop();
                switch (token) {
                    case "+":
                        st.push(operand1 + operand2);
                        break;
                    case "/":
                        st.push(operand1 / operand2);
                        break;
                    case "*":
                        st.push(operand1 * operand2);
                        break;
                    case "-":
                        st.push(operand1 - operand2);
                        break;
                    default:
                        break;
                }
            }
        }
        return st.pop();
    }

    boolean isNumber(String s) {
        return !s.equals("+") && !s.equals("-")
                && !s.equals("*") && !s.equals("/");
    }
}
// @lc code=end
