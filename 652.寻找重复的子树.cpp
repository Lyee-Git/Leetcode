/*
 * @lc app=leetcode.cn id=652 lang=cpp
 *
 * [652] 寻找重复的子树
 */

// @lc code=start
/**
Definition for a binary tree node.
 */
#include<vector>
#include<iostream>
#include<unordered_map>
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
    vector<TreeNode*> res;
    int index = 1;
    unordered_map<string, int> node2idx;
    unordered_map<int, int> count;

    int DFS(TreeNode* root)
    {
        if (root == nullptr)
            return 0;
        string serial = to_string(root->val) +"," + to_string(DFS(root->left)) + "," + to_string(DFS(root->right));
        int cur_idx;
        if (node2idx.find(serial) == node2idx.end())
        {
            node2idx[serial] = index;
            index++;
        }
        cur_idx = node2idx[serial];
        if (count.find(cur_idx) == count.end())
            count.insert(make_pair(cur_idx, 1));
        else
            count[cur_idx]++;
        if (count[cur_idx] == 2)
            res.emplace_back(root);
        return cur_idx;
        /* Why using idx instead of string:
        * Hashcode(when using map): 
                    for once String: O(N) (string.length() <= (to_string(root->left) + to_string(root) + to_string(root->right)) = O(N));  
                    for all O(N ^ 2)
                    for once idx:    O(1) (longest INT_MAX 32); 
                    for all O(N)
        * handle serial concatenation: 
                    Same as Hashcode analysis
        */
    }

    vector<TreeNode*> findDuplicateSubtrees(TreeNode* root) {
        DFS(root);
        return res;
    }
};
// @lc code=end

