/*
 * @lc app=leetcode.cn id=113 lang=cpp
 *
 * [113] 路径总和 II
 */

// @lc code=start
#include<vector>
#include<iostream>
#include<limits.h>
#include<queue>
using namespace std;
/*
 * Definition for a binary tree node.
*/
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
    vector<vector<int>> res;
    vector<int> path;

    void DFS(TreeNode* root, int targetSum)
    {
        if (root == nullptr)
            return;
        if (root->left == nullptr && root->right == nullptr)
        {
            if (root->val == targetSum)
            {
                path.emplace_back(root->val);
                res.emplace_back(path);
                path.pop_back();
            }
            return;
        }
        else
        {
            path.emplace_back(root->val);
            if (root->left != nullptr)
            {
                DFS(root->left, targetSum - root->val);
            }
            if (root->right != nullptr)
            {
                DFS(root->right, targetSum - root->val);
            }
            path.pop_back();
        }
    }

    vector<vector<int>> pathSum(TreeNode* root, int targetSum) {
        // Method1 DFS:
        DFS(root, targetSum);
        return res;
    }
};
// @lc code=end

