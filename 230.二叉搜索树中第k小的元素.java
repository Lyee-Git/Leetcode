
/*
 * @lc app=leetcode.cn id=230 lang=java
 *
 * [230] 二叉搜索树中第K小的元素
 */
import java.util.*;

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

    public int kthSmallest(TreeNode root, int k) {
        BST bst = new BST(root);
        return bst.kthSmallest(k);
    }

    class BST {
        TreeNode root;
        HashMap<TreeNode, Integer> size;

        public BST(TreeNode root) {
            this.root = root;
            this.size = new HashMap<>();
            countNum(root);
        }

        public int countNum(TreeNode node) {
            if (node == null)
                return 0;
            size.put(node, countNum(node.left) + countNum(node.right) + 1);
            return size.get(node);
        }

        public int kthSmallest(int k) {
            TreeNode node = this.root;
            while (node != null) {
                int leftSubTree = size.getOrDefault(node.left, 0);
                if (leftSubTree < k - 1) {
                    k -= leftSubTree + 1; // 左子树和node
                    node = node.right;
                } else if (leftSubTree > k - 1) {
                    node = node.left;
                } else
                    break;
            }
            return node.val;
        }
    }
}
// @lc code=end
