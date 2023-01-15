import java.util.*;

/*
 * @lc app=leetcode.cn id=145 lang=java
 *
 * [145] 二叉树的后序遍历
 */

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

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        if (root == null)
            return res;
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.right != null && root.right != prev) {
                // 右子树还未遍历,后面还用得到root,因此需要再次入栈
                stack.push(root);
                root = root.right;
            } else {
                res.add(root.val);
                prev = root;
                // 避免再次遍历其左子树
                root = null;
            }
        }
        return res;
    }
}
// @lc code=end
