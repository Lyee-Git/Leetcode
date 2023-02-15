/*
 * @lc app=leetcode.cn id=354 lang=java
 *
 * [354] 俄罗斯套娃信封问题
 */
import java.util.*;
// @lc code=start
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (int[] a, int[] b) -> {
            return a[0] == b[0] ? b[1] - a[1] : a[0] - b[0];
        });
        int res = 1, n = envelopes.length;
        int[] top = new int[n];
        top[0] = envelopes[0][1];
        for (int i = 1; i < n; i++) {
            if (envelopes[i][1] <= top[res - 1]) {
                int lo = 0, hi = res;
                while (lo < hi) {
                    int mid = lo + (hi - lo) / 2;
                    if (top[mid] < envelopes[i][1])
                        lo = mid + 1;
                    else
                        hi = mid;
                }
                top[lo] = envelopes[i][1];
            } else {
                top[res] = envelopes[i][1];
                res++;
            }
        }
        return res;
    }
}
// @lc code=end

