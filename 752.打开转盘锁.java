
/*
 * @lc app=leetcode.cn id=752 lang=java
 *
 * [752] 打开转盘锁
 */
import java.util.*;

// @lc code=start
class Solution {
    public int openLock(String[] deadends, String target) {
        int res = 0;
        // 双向BFS
        Set<String> cur = new HashSet<>();
        Set<String> check = new HashSet<>();
        cur.add("0000");
        check.add(target);
        Set<String> deads = new HashSet<>();
        for (String s : deadends)
            deads.add(s);
        Set<String> visited = new HashSet<>();
        while (!cur.isEmpty() && !check.isEmpty()) {
            if (cur.size() > check.size()) {
                Set<String> temp = cur;
                cur = check;
                check = temp;
            }
            Set<String> temp = new HashSet<>();
            for (String s : cur) {
                visited.add(s);
                if (deads.contains(s))
                    continue;
                if (check.contains(s)) {
                    return res;
                }
                for (int i = 0; i < 4; i++) {
                    String plus = getPlus(s, i);
                    if (!visited.contains(plus)) 
                        temp.add(plus);
                    String minus = getMinus(s, i);
                    if (!visited.contains(minus)) 
                        temp.add(minus);
                }
            }
            res++;
            cur = check;
            check = temp;
        }
        return -1;
    }

    String getPlus(String s, int i) {
        char[] nums = s.toCharArray();
        if (nums[i] == '9')
            nums[i] = '0';
        else
            nums[i] += 1;
        return new String(nums);
    }

    String getMinus(String s, int i) {
        char[] nums = s.toCharArray();
        if (nums[i] == '0')
            nums[i] = '9';
        else
            nums[i] -= 1;
        return new String(nums);
    }
}
// @lc code=end
