/*
 * @lc app=leetcode.cn id=653 lang=java
 *
 * [653] 两数之和 IV - 输入二叉搜索树
 */

// @lc code=start
import java.util.*;

class TreeNode {
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

class Solution {
    public boolean findTarget(TreeNode root, int k) {
        Stack<TreeNode> leftStack = new Stack<>();
        Stack<TreeNode> rightStack = new Stack<>();
        TreeNode left = root, right = root;
        while (left.left != null) {
            leftStack.push(left);
            left = left.left;
        }
        leftStack.push(left);
        while (right.right != null) {
            rightStack.push(right);
            right = right.right;
        }
        rightStack.push(right);
        while (left != right) {
            int curSum = left.val + right.val;
            if (curSum == k) {
                return true;
            } else if (curSum < k) {
                left = getLeft(leftStack, left);
            } else {
                right = getRight(rightStack, right);
            }
        }
        return false;
    }

    private TreeNode getLeft(Stack<TreeNode> leftStack, TreeNode left) {
        TreeNode res = leftStack.pop();
        left = res.right;
        while (left != null) {
            leftStack.push(left);
            left = left.left;
        }
        return res;
    }

    private TreeNode getRight(Stack<TreeNode> rightStack, TreeNode right) {
        TreeNode res = rightStack.pop();
        right = res.left;
        while (right != null) {
            rightStack.push(right);
            right = right.right;
        }
        return res;
    }
}
// @lc code=end
