/*
 * @lc app=leetcode.cn id=421 lang=java
 *
 * [421] 数组中两个数的最大异或值
 */

// @lc code=start
class Solution {
    class Trie {
        Trie left = null;
        Trie right = null;
    }

    Trie root = new Trie();
    // 0 <= nums[i] <= 231 - 1, highest significant bit is 31
    static final int HIGHBIT = 30; // Num of hsb

    public int findMaximumXOR(int[] nums) {
        int n = nums.length;
        int res = 0;
        for (int i = 1; i < n; i++) {
            add(root, nums[i - 1]);
            res = Math.max(res, currentMaximumXOR(nums[i]));
        }
        return res;
    }

    public int currentMaximumXOR(int j) {
        Trie p = root;
        int res = 0;
        for (int i = HIGHBIT; i >= 0; i--) {
            int bit = (j >> i) & 1;
            if (bit == 0) {
                if (p.right != null) {
                    p = p.right;
                    res = (res << 1) + 1;
                } else {
                    p = p.left;
                    res <<= 1;
                }
            } else {
                if (p.left != null) {
                    p = p.left;
                    res = (res << 1) + 1;
                } else {
                    p = p.right;
                    res <<= 1;
                }
            }
        }
        return res;
    }

    public void add(Trie root, int num) {
        Trie p = root;
        for (int i = HIGHBIT; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (bit == 0) {
                if (p.left == null)
                    p.left = new Trie();
                p = p.left;
            } else {
                if (p.right == null)
                    p.right = new Trie();
                p = p.right;
            }
        }
    }
}
// @lc code=end
