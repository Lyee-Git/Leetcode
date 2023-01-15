/*
 * @lc app=leetcode.cn id=232 lang=cpp
 *
 * [232] 用栈实现队列
 */
#include<stack>
using namespace std;
// @lc code=start
class MyQueue {
//     MyQueue() {
//     }
    
//     void push(int x) {
//         while (!s.empty())
//         {
//             assistant.push(s.top());
//             s.pop();
//         }
//         s.push(x);
//         while (!assistant.empty())
//         {
//             s.push(assistant.top());
//             assistant.pop();
//         }
//         while (!assistant.empty())
//             assistant.pop();
//     }
    
//     int pop() {
//         int x = s.top();
//         s.pop();
//         return x;
//     }
    
//     int peek() {
//         return s.top();
//     }
    
//     bool empty() {
//         return s.empty();
//     }
// private:
//     stack<int> s;
//     stack<int> assistant;
public:
    MyQueue() {

    }
    
    void push(int x) {
        if (in.empty())
            front = x;
        in.emplace(x);
    }
    
    int pop() { // Only transfer elems from in to out if needed: Ammortized O(1)
        if (out.empty())
        {
            while (!in.empty())
            {
                out.emplace(in.top());
                in.pop();
            }
        }
        int x = out.top();
        out.pop();
        return x;
    }
    
    int peek() { //O(1)
        if (out.empty() && !in.empty())
            return front;
        else if (!out.empty())
            return out.top();
        else return -1;
    }
    
    bool empty() {
        return in.empty() && out.empty();
    }
private:
    int front; // Use front to handle PEEK invoking when out stack is empty
    // avoid unnecessary transfer
    stack<int> in;
    stack<int> out;
};

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue* obj = new MyQueue();
 * obj->push(x);
 * int param_2 = obj->pop();
 * int param_3 = obj->peek();
 * bool param_4 = obj->empty();
 */
// @lc code=end

