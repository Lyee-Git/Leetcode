
/*
 * @lc app=leetcode.cn id=392 lang=java
 *
 * [392] 判断子序列
 */
import java.util.*;

// @lc code=start
class Solution {
    int left_bound(ArrayList<Integer> arr, int target) {
        int left = 0, right = arr.size();
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (target > arr.get(mid)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (left == arr.size()) {
            return -1;
        }
        return left;
    }

    public boolean isSubsequence(String s, String t) {
        ArrayList<Integer>[] index = new ArrayList[26];
        int m = s.length(), n = t.length();
        int i = 0, j = 0;
        for (int k = 0; k < n; k++) {
            if (index[t.charAt(k) - 'a'] == null) {
                index[t.charAt(k) - 'a'] = new ArrayList<>();
            }
            index[t.charAt(k) - 'a'].add(k);
        }
        while (i < m && j < n) {
            char c = s.charAt(i);
            ArrayList<Integer> indexes = index[c - 'a'];
            if (indexes == null)
                return false;
            int target = left_bound(indexes, j);
            if (target != -1) {
                j = indexes.get(target) + 1;
                i++;
            } else {
                return false;
            }
        }
        return i == m;
    }
}
// @lc code=end
