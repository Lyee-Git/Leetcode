/*
 * @lc app=leetcode.cn id=144 lang=java
 *
 * [144] 二叉树的前序遍历
 */
import java.util.*;
// @lc code=start
/**
 */

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
    public List<Integer> preorderTraversal(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        if (root == null)
            return list;
        while (!stack.isEmpty() || root != null) {
            while(root != null) {
                list.add(root.val);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
        return list;
    }
}
// @lc code=end
