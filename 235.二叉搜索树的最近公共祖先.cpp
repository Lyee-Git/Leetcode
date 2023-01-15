/*
 * @lc app=leetcode.cn id=235 lang=cpp
 *
 * [235] 二叉搜索树的最近公共祖先
 */

/**
 * Definition for a binary tree node.
 */
#include<vector>
#include<iostream>
#include<limits.h>
#include<queue>
#include<algorithm>
using namespace std;
struct TreeNode {
      int val;
      TreeNode *left;
      TreeNode *right;
      TreeNode() : val(0), left(nullptr), right(nullptr) {}
      TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
      TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
  };

class Solution {
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        TreeNode *LCA = root;
        while (true)
        {
            if (LCA->val > p->val && LCA->val > q->val)
                LCA = LCA->left;
            else if (LCA->val < p->val && LCA->val < q->val)
                LCA = LCA->right;
            else break;
        }
        return LCA;
    }
};
// @lc code=end

