/*
 * @lc app=leetcode.cn id=590 lang=java
 *
 * [590] N 叉树的后序遍历
 */

// @lc code=start
/*
// Definition for a Node.
};
*/
import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

class Solution {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<Integer> postorder(Node root) {
        List<Integer> res = new LinkedList<>();
        HashMap<Node, Integer> nodeToIdx = new HashMap<>();
        Deque<Node> stack = new LinkedList<>();
        if (root == null)
            return res;
        Node node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                List<Node> children = node.children;
                if (children != null && children.size() > 0) {
                    // 第一次访问，加入map
                    nodeToIdx.put(node, 0);
                    node = children.get(0);
                } else
                    node = null; // 效果同break;
            }
            node = stack.peek();
            List<Node> children = node.children;
            int index = nodeToIdx.getOrDefault(node, -1) + 1;
            if (children == null || index >= children.size()) {
                res.add(node.val);
                stack.pop();
                nodeToIdx.remove(node);
                node = null; // 避免重复入栈再遍历
            } else {
                nodeToIdx.put(node, index);
                node = children.get(index);
            }
        }
        return res;
    }
}
// @lc code=end
