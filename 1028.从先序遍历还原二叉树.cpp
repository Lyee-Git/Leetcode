/*
 * @lc app=leetcode.cn id=1028 lang=cpp
 *
 * [1028] 从先序遍历还原二叉树
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 */
#include<vector>
#include<iostream>
#include<limits.h>
#include<stack>
#include<string>
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
    TreeNode* recoverFromPreorder(string traversal) {
        int pos = 0;
        stack<TreeNode*> GoAlongLeftPath;
        while (pos < traversal.size())
        {
            int level = 0, num = 0;
            while (traversal[pos] == '-') {
                pos++; 
                level++;
            }
            while (pos < traversal.size() && isdigit(traversal[pos])) {
                num = num * 10 + traversal[pos] - '0';
                pos++;
            }
            if (level == GoAlongLeftPath.size()) {
                if (!level)
                    GoAlongLeftPath.push(new TreeNode(num));
                else
                {
                    TreeNode *cur = new TreeNode(num);
                    GoAlongLeftPath.top()->left = cur;
                    GoAlongLeftPath.push(cur);
                }
            }
            else {
                while (GoAlongLeftPath.size() != level)
                    GoAlongLeftPath.pop();
                TreeNode *cur = new TreeNode(num);
                GoAlongLeftPath.top()->right = cur;
                GoAlongLeftPath.push(cur);
            }
        }
        while (GoAlongLeftPath.size() > 1)
            GoAlongLeftPath.pop();
        return GoAlongLeftPath.top();
    }
};
// @lc code=end

