/*
 * @lc app=leetcode.cn id=921 lang=java
 *
 * [921] 使括号有效的最少添加
 */
import java.util.*;;
// @lc code=start
class Solution {
    public int minAddToMakeValid(String s) {
        int res = 0, leftCnt = 0;
        // 贪心
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                leftCnt++;
            else {
                if (leftCnt >= 1) {
                    leftCnt--;
                }
                else {
                    res++;
                }
            }
        }
        return res + leftCnt;
    }
}
// @lc code=end

