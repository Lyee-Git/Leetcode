
/*
 * @lc app=leetcode.cn id=93 lang=java
 *
 * [93] 复原 IP 地址
 */
import java.util.*;

// @lc code=start
class Solution {
    // Time Complexity Analysis: O(3 ^ SEG_COUNT ×∣s∣)
    // 3 means Trinary Tree. Maximum levels of tree would be SEG_COUNT(4), which is
    // also max levels of recursion
    // Maximum 3 choices for each segment number
    // It takes O(|S|) to process each posiible result
    // Space complexity would be O(SEG_COUNT), num of levels of recursion
    public static final int SEGMENTNUM = 4;
    List<String> res;
    int[] segments;

    public List<String> restoreIpAddresses(String s) {
        res = new ArrayList<>();
        segments = new int[SEGMENTNUM];
        backtrack(s, 0, 0);
        return res;
    }

    public void backtrack(String s, int start, int segID) {
        if (segID == SEGMENTNUM) {
            if (start == s.length()) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < SEGMENTNUM; i++) {
                    String num = String.valueOf(segments[i]);
                    sb.append(num);
                    if (i != SEGMENTNUM - 1)
                        sb.append(".");
                }
                res.add(sb.toString());
            }
            return;
        }
        if (start == s.length())
            return;
        if (s.charAt(start) == '0') {
            segments[segID] = 0;
            backtrack(s, start + 1, segID + 1);
            return;
        }
        int numSegment = 0;
        for (int i = start; i < s.length(); i++) {
            numSegment = numSegment * 10 + s.charAt(i) - '0';
            if (numSegment <= 0xFF) {
                segments[segID] = numSegment;
                backtrack(s, i + 1, segID + 1);
            } else {
                break;
            }
        }
    }
}
// @lc code=end
