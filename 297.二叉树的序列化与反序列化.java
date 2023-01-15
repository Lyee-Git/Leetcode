import java.util.Deque;
import java.util.LinkedList;
import java.lang.Integer;

/*
 * @lc app=leetcode.cn id=297 lang=java
 *
 * [297] 二叉树的序列化与反序列化
 */

// @lc code=start
class Codec {
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

    final String SEP = "/";
    final String NULL = "#";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder stringBuilder = new StringBuilder();
        if (root == null) {
            stringBuilder.append(NULL).append(SEP);
            return stringBuilder.toString();
        }
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stringBuilder.append(Integer.toString(root.val)).append(SEP);
                stack.push(root);
                root = root.left;
            }
            if (root == null)
                stringBuilder.append(NULL).append(SEP);
            root = stack.pop();
            root = root.right;
        }
        return stringBuilder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        LinkedList<String> nodes = new LinkedList<>();
        for (String node : data.split(SEP))
            nodes.addLast(node);
        return deserialize(nodes);
    }

    private TreeNode deserialize(LinkedList<String> nodes) {
        if (nodes.isEmpty())
            return null;
        String node = nodes.removeFirst();
        if (node.equals(NULL)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(node));
        root.left = deserialize(nodes);
        root.right = deserialize(nodes);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
// @lc code=end
