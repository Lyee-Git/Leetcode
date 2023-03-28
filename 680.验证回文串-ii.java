/*
 * @lc app=leetcode.cn id=680 lang=java
 *
 * [680] 验证回文串 II
 */

// @lc code=start
class Solution {
    public boolean validPalindrome(String s) {
        int lo = 0, hi = s.length() - 1;
        while (lo < hi) {
            if (s.charAt(hi) == s.charAt(lo)) {
                lo++;
                hi--;
            } else {
                return check(s, lo, hi - 1) || check(s, lo + 1, hi);
            }
        }
        return true;
    }

    private boolean check(String s, int lo , int hi) {
        while (lo < hi) {
            if (s.charAt(lo) == s.charAt(hi)) {
                lo++;
                hi--;
            } else {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end
