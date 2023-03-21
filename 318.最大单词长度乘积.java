
/*
 * @lc app=leetcode.cn id=318 lang=java
 *
 * [318] 最大单词长度乘积
 */
import java.util.*;

// @lc code=start
class Solution {
    public int maxProduct(String[] words) {
        Map<Integer, Integer> maskToLen = new HashMap<>();
        for (String word : words) {
            int mask = 0;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                mask |= 1 << (c - 'a');
            }
            if (!maskToLen.containsKey(mask)) {
                maskToLen.put(mask, word.length());
            } else if (word.length() > maskToLen.get(mask)) {
                maskToLen.put(mask, word.length());
            }
        }
        int maxProd = 0;
        // Traverse per "mask combination"
        for (int mask1 : maskToLen.keySet()) {
            int len1 = maskToLen.get(mask1);
            for (int mask2 : maskToLen.keySet()) {
                int len2 = maskToLen.get(mask2);
                if ((mask1 & mask2) == 0)
                    maxProd = Math.max(maxProd, len1 * len2);
            }
        }
        return maxProd;
    }
}
// @lc code=end
