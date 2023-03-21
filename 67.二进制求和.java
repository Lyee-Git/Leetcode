/*
 * @lc app=leetcode.cn id=67 lang=java
 *
 * [67] 二进制求和
 */

// @lc code=start
class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int aLen = a.length(), bLen = b.length();
        int n = Math.max(aLen, bLen);
        int carry = 0;
        for (int i = 0; i < n; i++) {
            int aBit = i < aLen ? a.charAt(aLen - 1 - i) - '0' : 0;
            int bBit = i < bLen ? b.charAt(bLen - 1 - i) - '0' : 0;
            carry += aBit + bBit;
            sb.append((char) (carry % 2 + '0'));
            carry /= 2;
        }
        if (carry > 0)
            sb.append((char) (carry % 2 + '0'));
        sb.reverse();
        return sb.toString();
    }
}
// @lc code=end
