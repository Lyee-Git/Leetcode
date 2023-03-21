/*
 * @lc app=leetcode.cn id=50 lang=java
 *
 * [50] Pow(x, n)
 */

// @lc code=start
class Solution {
    public double myPow(double x, int n) {
        long N = (long) n;
        return N < 0 ? 1.0 / quickMul(x, -N) : quickMul(x, N);
    }

    private double quickMul(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
        double result = 1.0, mul = x;
        while (n > 0) {
            if ((n & 1) == 1) {
                result *= mul;
            }
            if (n > 1) {
                mul *= mul;
            }
            n >>= 1;
        }
        return result;
    }
}
// @lc code=end
