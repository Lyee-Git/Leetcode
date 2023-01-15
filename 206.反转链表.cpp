/*
 * @lc app=leetcode.cn id=206 lang=cpp
 *
 * [206] 反转链表
 */

#include<string>
#include<algorithm>
#include<vector>
using namespace std;
// @lc code=start
/**
 * Definition for singly-linked list.
 * 
 * */
struct ListNode {
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

class Solution {
public:
    ListNode* reverseList(ListNode* head) {
        ListNode *cur = head, *prev = nullptr;
        while (cur != nullptr) {
            ListNode *succ = cur->next;
            cur->next = prev;
            prev = cur;
            cur = succ;
        }
        return prev;
    }
};
// @lc code=end

