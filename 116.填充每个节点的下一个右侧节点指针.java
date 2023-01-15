/*
 * @lc app=leetcode.cn id=116 lang=java
 *
 * [116] 填充每个节点的下一个右侧节点指针
 */

// @lc code=start

class Solution {
    public class Node {
        int val;
        Node left;
        Node right;
        Node next;

        Node() {
        }

        Node(int val) {
            this.val = val;
        }

        Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public Node connect(Node root) {
        // 递归解法
        // if (root == null)
        // return null;
        // connectTriTree(root.left, root.right);
        // return root;

        // O(1)空间复杂度解法
        if (root == null)
            return null;
        Node leftLevel = root;
        while (leftLevel.left != null) {
            Node p = leftLevel;
            while (p != null) {
                p.left.next = p.right;
                if (p.next != null) {
                    p.right.next = p.next.left;
                }
                p = p.next;
            }
            leftLevel = leftLevel.left;
        }
        return root;
    }

    // 把两个节点当成一个大节点，这样完美二叉树可以视作一个三叉树
    private void connectTriTree(Node first, Node second) {
        if (first == null || second == null)
            return;
        first.next = second;
        connectTriTree(first.left, first.right);
        connectTriTree(first.right, second.left);
        connectTriTree(second.left, second.right);
    }
}
// @lc code=end
