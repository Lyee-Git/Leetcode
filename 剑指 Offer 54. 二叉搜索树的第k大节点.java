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
    HashMap<TreeNode, Integer> count;

    public int kthLargest(TreeNode root, int k) {
        count = new HashMap<>();
        TreeNode node = root;
        countBST(root);
        while (node != null) {
            int countRight = count.getOrDefault(node.right, 0);
            if (countRight == k - 1) {
                break;
            } else if (countRight > k - 1) {
                node = node.right;
            } else {
                k -= countRight + 1;
                node = node.left;
            }
        }
        return node.val;
    }

    public int countBST(TreeNode node) {
        if (node == null)
            return 0;
        int countNum = countBST(node.left) + countBST(node.right) + 1;
        count.put(node, countNum);
        return countNum;
    }
}
