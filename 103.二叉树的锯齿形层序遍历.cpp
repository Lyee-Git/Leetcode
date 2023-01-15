/*
 * @lc app=leetcode.cn id=103 lang=cpp
 *
 * [103] 二叉树的锯齿形层序遍历
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 */
#include<vector>
#include<iostream>
#include<limits.h>
#include<deque>
#include<stack>
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
    vector<vector<int>> zigzagLevelOrder(TreeNode* root) {
        if (root == nullptr)
            return {};
        vector<vector<int>> res;
        // Double Stack
        stack<TreeNode*> q;
        q.push(root);
        bool inverse = true;
        while (!q.empty())
        {
            vector<int> level;
            stack<TreeNode*> p;
            int size = q.size();
            while (size--)
            {
                TreeNode *cur = q.top();
                q.pop();
                level.emplace_back(cur->val);
                if (inverse)
                {
                    if (cur->left)
                        p.push(cur->left);
                    if (cur->right)
                        p.push(cur->right);
                }
                else
                {
                    if (cur->right)
                        p.push(cur->right);
                    if (cur->left)
                        p.push(cur->left);
                }
            }
            q = p;
            inverse = !inverse;
            res.emplace_back(move(level));
        }
        return res;
    }
};
// @lc code=end

