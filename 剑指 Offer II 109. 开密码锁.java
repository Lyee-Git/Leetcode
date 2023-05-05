
// 剑指 Offer II 108. 单词演变
// @lc code=start
// deadends = ["0201","0101","0102","1212","2002"], target = "0202" ans = 6
// "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"
import java.util.*;

class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> deads = new HashSet<>();
        for (String dead : deadends) {
            deads.add(dead);
        }
        Set<String> setBegin = new HashSet<>();
        setBegin.add("0000");
        Set<String> setEnd = new HashSet<>();
        setEnd.add(target);
        int step = 0;
        Set<String> visited = new HashSet<>();
        while (!setBegin.isEmpty() && !setEnd.isEmpty()) {
            if (setBegin.size() > setEnd.size()) {
                Set<String> temp = setBegin;
                setBegin = setEnd;
                setEnd = temp;
            }
            Set<String> temp = new HashSet<>();
            for (String s : setBegin) {
                visited.add(s);
                if (deads.contains(s)) {
                    continue;
                }
                if (setEnd.contains(s)) {
                    return step;
                }
                for (int i = 0; i < 4; i++) {
                    String added = addOne(s.toCharArray(), i);
                    if (!visited.contains(added)) {
                        // visited.add(added);
                        temp.add(added);
                    }
                    String minus = minusOne(s.toCharArray(), i);
                    if (!visited.contains(minus)) {
                        // visited.add(minus); //
                        // 错误处理：由于我们两个堆只用了一个visited，若此时就加入visited，则一个密码永远无法同时出现在setBegin和setEnd中
                        temp.add(minus);
                    }
                }
            }
            step++;
            setBegin = setEnd;
            setEnd = temp;
        }
        return -1;
    }

    public String addOne(char[] word, int idx) {
        if (word[idx] == '9') {
            word[idx] = '0';
        } else {
            word[idx] += 1;
        }
        return new String(word);
    }

    public String minusOne(char[] word, int idx) {
        if (word[idx] == '0') {
            word[idx] = '9';
        } else {
            word[idx] -= 1;
        }
        return new String(word);
    }

    // public static void main(String[] args) {
    // Main main = new Main();
    // String[] deadends = new String[] { "0201", "0101", "0102", "1212", "2002" };
    // main.openLock(deadends, "0202");
    // }
}
