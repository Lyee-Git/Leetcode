/*
 * @lc app=leetcode.cn id=1541 lang=java
 *
 * [1541] 平衡括号字符串的最少插入次数
 */
import java.util.*;
// @lc code=start
class Solution {
    public int minInsertions(String s) {
        int leftCnt = 0, res = 0;
        int index = 0;
        while (index < s.length()) {
            if (s.charAt(index) == '(') {
                leftCnt++;
                index++;
            }
            else {
                if (index < s.length() - 1 && s.charAt(index + 1) == ')') {
                    index += 2;
                    leftCnt--;
                    if (leftCnt == -1) {
                        leftCnt = 0;
                        res++;
                    }
                }
                else {
                    leftCnt--;
                    if (leftCnt == -1) {
                        leftCnt = 0;
                        res++;
                    }
                    index++;
                    res++;
                }
            }
        }
        return res + leftCnt * 2;
    }
}
// @lc code=end

