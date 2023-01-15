
/*
 * @lc app=leetcode.cn id=710 lang=java
 *
 * [710] 黑名单中的随机数
 */
import java.util.*;

// @lc code=start
class Solution {
    Random random;
    HashMap<Integer, Integer> black;// 从黑名单数映射到(n - m, n)上的非黑名单数
    int bound;

    public Solution(int n, int[] blacklist) {
        random = new Random();
        black = new HashMap<>();
        bound = n - blacklist.length;
        for (int blacknum : blacklist) {
            black.put(blacknum, -1);
        }
        int last = n - 1;
        for (int b : blacklist) {
            if (b >= bound)
                continue;
            while (black.containsKey(last))
                last--;
            black.put(b, last);
            last--;
        }
    }

    public int pick() {
        int randomNum = random.nextInt(bound);
        if (black.containsKey(randomNum))
            return black.get(randomNum);
        else
            return randomNum;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(n, blacklist);
 * int param_1 = obj.pick();
 */
// @lc code=end
