/*
 * @lc app=leetcode.cn id=92 lang=cpp
 *
 * [92] 反转链表 II
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
    ListNode *succ = nullptr;
    ListNode* reverseN(ListNode *head, int n) {
        if (n == 1) {
            succ = head->next;
            return head;
        }
        ListNode *last = reverseN(head->next, n - 1);
        head->next->next = head;
        head->next = succ;
        return last;
    }

    ListNode* reverseBetween(ListNode* head, int left, int right) {
        if (left == 1)
            return reverseN(head, right);
        head->next = reverseBetween(head->next, left - 1, right - 1);
        return head;
    }
};
// @lc code=end

