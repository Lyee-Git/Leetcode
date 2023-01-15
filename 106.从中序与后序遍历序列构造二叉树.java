import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=106 lang=java
 *
 * [106] 从中序与后序遍历序列构造二叉树
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

    HashMap<Integer, Integer> valToIdx = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++)
            valToIdx.put(inorder[i], i);
        TreeNode root = construct(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
        return root;
    }

    private TreeNode construct(int[] inorder, int in_lo, int in_hi,
            int[] postorder, int post_lo, int post_hi) {
        if (in_lo > in_hi)
            return null;
        int rootVal = postorder[post_hi];
        int rootIdx = valToIdx.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        int leftSize = rootIdx - in_lo;
        root.left = construct(inorder, in_lo, rootIdx - 1, postorder, post_lo, post_lo + leftSize - 1);
        root.right = construct(inorder, rootIdx + 1, in_hi, postorder, post_lo + leftSize, post_hi - 1);
        return root;
    }
}
// @lc code=end
