
/*
 * @lc app=leetcode.cn id=895 lang=java
 *
 * [895] 最大频率栈
 */
import java.util.*;

// @lc code=start
class FreqStack {
    int maxFreq;
    HashMap<Integer, Integer> valToFreq;
    HashMap<Integer, ArrayDeque<Integer>> freqToVal;

    public FreqStack() {
        maxFreq = 0;
        valToFreq = new HashMap<>();
        freqToVal = new HashMap<>();
    }

    public void push(int val) {
        int freq = valToFreq.getOrDefault(val, 0) + 1;
        valToFreq.put(val, freq);
        if (freq > maxFreq)
            maxFreq = freq;
        freqToVal.putIfAbsent(freq, new ArrayDeque<>());
        freqToVal.get(freq).addLast(val);
    }

    public int pop() {
        ArrayDeque<Integer> maxStack = freqToVal.get(maxFreq);
        int popVal = maxStack.removeLast();
        int freq = valToFreq.get(popVal) - 1;
        valToFreq.put(popVal, freq);
        if (maxStack.isEmpty()) {
            maxFreq--; 
         }
        return popVal;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */
// @lc code=end
