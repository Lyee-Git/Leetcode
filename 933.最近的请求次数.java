
/*
 * @lc app=leetcode.cn id=933 lang=java
 *
 * [933] 最近的请求次数
 */
import java.util.*;

// @lc code=start
class RecentCounter {
    Queue<Integer> queue;

    public RecentCounter() {
        queue = new ArrayDeque<Integer>();
    }

    public int ping(int t) {
        while (!queue.isEmpty() && t - queue.peek() > 3000) {
            queue.poll();
        }
        queue.offer(t);
        return queue.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
// @lc code=end
