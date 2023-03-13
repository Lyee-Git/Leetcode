
/*
 * @lc app=leetcode.cn id=155 lang=java
 *
 * [155] 最小栈
 */
import java.util.*;

// @lc code=start
class MinStack {
    // 在弹出时如何维护min？
    // 因为每次压入新的元素时，压入的都是与当前栈中最小值的差值（还未压入当前元素），故在弹出元素时，若弹出了当前最小值，因为栈中记录了当前元素与【之前】最小值的差值，
    // 故根据这个记录可以更新弹出元素后的最小值。
    Stack<Long> st;
    long min;

    public MinStack() {
        st = new Stack<>();
    }

    public void push(int val) {
        if (st.empty()) {
            st.push(0L);
            min = (long) val;
            return;
        }
        st.push((long) val - min);
        min = Math.min(min, val);
    }

    public void pop() {
        long diff = st.pop();
        if (diff >= 0)
            return;
        else {
            min = min - diff;
        }
    }

    public int top() {
        long diff = st.peek();
        if (diff >= 0) {
            return (int) (min + diff);
        } else {
            return (int) min;
        }
    }

    public int getMin() {
        return (int) min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
// @lc code=end
