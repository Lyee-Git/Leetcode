
/*
 * @lc app=leetcode.cn id=501 lang=java
 *
 * [501] 二叉搜索树中的众数
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

    public int[] findMode(TreeNode root) {
        if (root == null)
            return null;
        List<Integer> mode = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        int maxNum = 0, curNum = 0;
        TreeNode prev = null;
        while (root != null || !s.isEmpty()) {
            while (root != null) {
                s.push(root);
                root = root.left;
            }
            root = s.pop();
            // 中序位置
            if (prev == null) {
                maxNum = 1;
                curNum = 1;
                mode.add(root.val);
            } else {
                if (prev.val == root.val) {
                    curNum++;
                    if (curNum == maxNum) {
                        mode.add(root.val);
                    } else if (curNum > maxNum) {
                        mode.clear();
                        maxNum = curNum;
                        mode.add(root.val);
                    }
                } else {
                    curNum = 1;
                    if (curNum == maxNum) {
                        mode.add(root.val);
                    }
                }
            }
            prev = root;
            root = root.right;
        }
        int[] res = new int[mode.size()];
        for (int i = 0; i < mode.size(); i++)
            res[i] = mode.get(i);
        return res;
    }
}
// @lc code=end
