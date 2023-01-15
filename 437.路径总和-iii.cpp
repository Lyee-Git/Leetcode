// @before-stub-for-debug-begin
#include <vector>
#include <string>

using namespace std;
// @before-stub-for-debug-end

/*
 * @lc app=leetcode.cn id=437 lang=cpp
 *
 * [437] 路径总和 III
 */

// @lc code=start
#include<vector>
#include<iostream>
#include<limits.h>
#include<queue>
#include<unordered_map>
#include<hash_map>
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
    unordered_map<long long, int> prefix;
    int DFS(TreeNode* root, int targetSum, long long cur_prefix)
    {
        if (!root)
            return 0;
        int res = 0;
        cur_prefix += root->val;
        if (prefix.find(cur_prefix - targetSum) != prefix.end())   
        {
            res += prefix[cur_prefix - targetSum];
        }
        prefix[cur_prefix]++;
        res += DFS(root->left, targetSum, cur_prefix);
        res += DFS(root->right, targetSum, cur_prefix);
        prefix[cur_prefix]--;
        return res;
    }

    int pathSum(TreeNode* root, int targetSum) 
    {
        prefix[0] = 1; // if sum of path (from root to leaf) == targetSum then use prefix[0]
        return DFS(root, targetSum, 0);
    }
};
// @lc code=end

