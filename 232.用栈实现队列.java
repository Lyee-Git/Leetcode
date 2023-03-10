/*
 * @lc app=leetcode.cn id=232 lang=java
 *
 * [232] 用栈实现队列
 */
import java.util.*;
// @lc code=start
class MyQueue {
    private Stack<Integer> in;
    private Stack<Integer> out;
    int head_elem;
    public MyQueue() {
        in = new Stack<>();
        out = new Stack<>();
    }
    
    public void push(int x) {
        if (in.empty())
            head_elem = x;
        in.push(x);
    }
    
    public int pop() {
        if (!out.empty())
            return out.pop();
        else {
            while (!in.empty()) {
                out.push(in.pop());
            }
            return out.pop();
        }
    }
    
    public int peek() {
        if (out.empty() && !in.empty())
            return head_elem;
        else if (!out.empty()) 
            return out.peek();
        else
            return -1;
    }
    
    public boolean empty() {
        return in.empty() && out.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
// @lc code=end

