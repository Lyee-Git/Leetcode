/*
 * @lc app=leetcode.cn id=111 lang=cpp
 *
 * [111] 二叉树的最小深度
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
// struct TreeNode {
//       int val;
//       TreeNode *left;
//       TreeNode *right;
//       TreeNode() : val(0), left(nullptr), right(nullptr) {}
//       TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
//       TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
//   };
class Solution {
public:
//DFS:
    int minDepth(TreeNode* root) {
        if (root == nullptr)
            return 0;
        if (root->left == nullptr && root->right == nullptr)
            return 1;
        int min_depth, left = INT_MAX, right = INT_MAX;
        if (root->left)
            left = minDepth(root->left);
        if (root->right)
            right = minDepth(root->right);
        return min(left, right) + 1;
    }
    
//BFS:
    // int minDepth(TreeNode *root) {
    //     if (root == nullptr) {
    //         return 0;
    //     }
    //     queue<TreeNode*> que;
    //     que.emplace(root);
    //     int ans = 1;
    //     while (!que.empty()) {
    //         int size = que.size();
    //         while (size--)
    //         {
    //             TreeNode *node = que.front();
    //             que.pop();
    //             if (node->left == nullptr && node->right == nullptr) {
    //                 return ans;
    //             }
    //             if (node->left != nullptr) {
    //                 que.emplace(node->left);
    //             }
    //             if (node->right != nullptr) {
    //                 que.emplace(node->right);
    //             }
    //         }
    //         ans++;
    //     }
    //     return 0;
    // }
};
// @lc code=end

