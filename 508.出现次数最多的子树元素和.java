/*
 * @lc app=leetcode.cn id=508 lang=java
 *
 * [508] 出现次数最多的子树元素和
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 */
import java.util.*;

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

    HashMap<Integer, Integer> count = new HashMap<>();
    int maxCnt = 0;

    public int[] findFrequentTreeSum(TreeNode root) {
        dfs(root);
        List<Integer> maxTree = new ArrayList<>();
        for (Map.Entry<Integer, Integer> e : count.entrySet()) {
            if (e.getValue() > maxCnt) {
                maxCnt = e.getValue();
                maxTree.clear();
                maxTree.add(e.getKey());
            } else if (e.getValue() == maxCnt) {
                maxTree.add(e.getKey());
            }
        }
        int[] res = new int[maxTree.size()];
        int i = 0;
        for (int elem : maxTree) {
            res[i++] = elem;
        }
        return res;
    }

    int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = dfs(node.left);
        int right = dfs(node.right);
        int sum = left + right + node.val;
        count.put(sum, count.getOrDefault(sum, 0) + 1);
        return sum;
    }
}
// @lc code=end
