/*
 * @lc app=leetcode.cn id=236 lang=cpp
 *
 * [236] 二叉树的最近公共祖先
 */

// @lc code=start
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
    bool DFS(TreeNode *root, TreeNode* p, TreeNode* q, TreeNode *& res){
        if (root == nullptr)
            return false;
        bool inLC = DFS(root->left, p, q, res); // p or q in left subtree of root
        bool inRC = DFS(root->right, p, q, res);
        bool Equal = root == p || root == q;
        if (Equal && (inLC || inRC) || inLC && inRC)
            res = root;
        return Equal || inRC || inLC;
    }

    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        TreeNode *res;
        DFS(root, p, q, res);
        return res;
    }
};
// @lc code=end

