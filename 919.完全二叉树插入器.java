
/*
 * @lc app=leetcode.cn id=919 lang=java
 *
 * [919] 完全二叉树插入器
 */
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

class CBTInserter {
    int cnt;
    TreeNode root;

    public CBTInserter(TreeNode root) {
        this.root = root;
        Queue<TreeNode> temp = new ArrayDeque<>();
        temp.offer(root);
        while (!temp.isEmpty()) {
            TreeNode node = temp.peek();
            cnt++;
            temp.poll();
            if (node.left != null) {
                temp.offer(node.left);
            }
            if (node.right != null) {
                temp.offer(node.right);
            }
        }
    }

    public int insert(int val) {
        TreeNode newInsert = new TreeNode(val);
        TreeNode cur = root;
        cnt++;
        int hsBit = 32 - 1 - Integer.numberOfLeadingZeros(cnt);
        for (int i = hsBit - 1; i >= 0; i--) {
            if (i == 0) {
                if ((cnt & 1) == 1) {
                    cur.right = newInsert;
                } else {
                    cur.left = newInsert;
                }
                break;
            }
            if ((cnt & (1 << i)) != 0) {
                cur = cur.right;
            } else {
                cur = cur.left;
            }
        }
        return cur.val;
    }

    public TreeNode get_root() {
        return this.root;
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(val);
 * TreeNode param_2 = obj.get_root();
 */
// @lc code=end
