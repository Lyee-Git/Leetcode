/*
 * @lc app=leetcode.cn id=1145 lang=cpp
 *
 * [1145] 二叉树着色游戏
 */
#include<iostream>
#include<vector>
#include<limits.h>
using namespace std;
// @lc code=start
struct TreeNode {
      int val;
      TreeNode *left;
      TreeNode *right;
      TreeNode() : val(0), left(nullptr), right(nullptr) {}
      TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
      TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
  };
class Solution {
private:
    int leftSum = 0;
    int rightSum = 0;

    int dfs(TreeNode* curr, int x)
    {
        if (curr != nullptr)
        {
            int left = dfs(curr->left, x);
            int right = dfs(curr->right, x);
            if (curr->val == x)
            {
                leftSum = left;
                rightSum = right;
            }
            return left + right + 1;
        }
        else
        {
            return 0;
        }
    }
public:
    bool btreeGameWinningMove(TreeNode* root, int n, int x) {
        dfs(root, x);
        int thirdSum = n - 1 - leftSum - rightSum;
        return (thirdSum > n/2) || (leftSum > n/2) || (rightSum > n/2);
    }
};
// @lc code=end

