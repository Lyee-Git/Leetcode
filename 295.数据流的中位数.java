/*
 * @lc app=leetcode.cn id=295 lang=java
 *
 * [295] 数据流的中位数
 */
import java.util.*;
// @lc code=start
class MedianFinder {
    PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;

    public MedianFinder() {
        min = new PriorityQueue<>();
        max = new PriorityQueue<>((Integer a, Integer b) -> { return b - a; });
    }
    
    public void addNum(int num) {
        if (max.isEmpty()) {
            max.offer(num);
            return;
        }
        if (num < max.peek())
            max.offer(num);
        else
            min.offer(num);
        if (max.size() > min.size() + 1)
            min.add(max.poll());
        if (min.size() > max.size() + 1)
            max.add(min.poll());
    }
    
    public double findMedian() {
        if (max.size() == min.size())
            return ((double) max.peek() + min.peek()) / 2;
        else if (max.size() > min.size())
            return max.peek();
        else return min.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
// @lc code=end

