/*
 * @lc app=leetcode.cn id=29 lang=java
 *
 * [29] 两数相除
 */

// @lc code=start
class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == -1)
                return Integer.MAX_VALUE;
            if (divisor == 1)
                return Integer.MIN_VALUE;
        }
        boolean revFlag = false;
        if (dividend > 0) {
            dividend = -dividend;
            revFlag = !revFlag;
        }
        if (divisor > 0) {
            divisor = -divisor;
            revFlag = !revFlag;
        }
        // Find max value of z such that z * y(divisor) >= x(dividend) > (z + 1)*y
        int left = 1, right = Integer.MAX_VALUE, ans = 0;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (check(mid, divisor, dividend)) {
                ans = mid;
                if (ans == Integer.MAX_VALUE)
                    break;
                left = mid + 1;
            }
            else 
                right = mid - 1;
        }
        return revFlag ? -ans : ans;
    }

    // return z * y >= x, z >=0 , y x < 0
    public boolean check(int z, int y, int x) {
        int result = 0, addVal = y;
        while (z != 0) {
            if ((z & 1) != 0) {
                if (result < x - addVal) {
                    return false;
                }
                result += addVal;
            }
            if (z > 1) {
                if (addVal < x - addVal) {
                    return false;
                }
                addVal += addVal;
            }
            z >>= 1;
        }
        return true;
    }
}
// @lc code=end
