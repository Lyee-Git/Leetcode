/*
 * @lc app=leetcode.cn id=105 lang=cpp
 *
 * [105] 从前序与中序遍历序列构造二叉树
 */

/**
 * Definition for a binary tree node.
 */
#include<vector>
#include<iostream>
#include<limits.h>
#include<stack>
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
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        if (!preorder.size())
            return nullptr;
        stack<TreeNode*> preorderNodes;
        TreeNode* root = new TreeNode(preorder[0]);
        preorderNodes.push(root);
        int idx_inorder = 0;
        for (int i = 1; i < preorder.size(); i++)
        {
            int val_preorder = preorder[i];
            TreeNode* node = preorderNodes.top();
            if (node->val != inorder[idx_inorder])
            {
                node->left = new TreeNode(val_preorder);
                preorderNodes.push(node->left);
            }
            else
            {
                while (!preorderNodes.empty() && preorderNodes.top()->val == inorder[idx_inorder])
                {
                    node = preorderNodes.top();
                    preorderNodes.pop();
                    idx_inorder++;
                }
                node->right = new TreeNode(val_preorder);
                preorderNodes.push(node->right);
            }
        }
        return root;
    }
};
// @lc code=end

