
/*
 * @lc app=leetcode.cn id=530 lang=java
 *
 * [530] 二叉搜索树的最小绝对差
 */
import java.util.*;
import java.math.*;

// @lc code=start
class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int getMinimumDifference(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        int minDiff = Integer.MAX_VALUE;
        TreeNode prev = null;
        while (root != null || !s.isEmpty()) {
            while (root != null) {
                s.push(root);
                root = root.left;
            }
            root = s.pop();
            // 中序位置
            if (prev != null) {
                minDiff = Math.min(minDiff, root.val - prev.val);
            }
            prev = root;
            root = root.right;
        }
        return minDiff;
    }
}
// @lc code=end
