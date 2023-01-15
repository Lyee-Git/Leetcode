/*
 * @lc app=leetcode.cn id=25 lang=cpp
 *
 * [25] K 个一组翻转链表
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
    // return head node of reversed list
    // Reverse elements between Listnode a & b. Notice that it's [a, b)
    ListNode *reverseBetween(ListNode *a, ListNode *b) {
        ListNode *pre = nullptr, *cur = a;
        while (cur != b) {
            ListNode *succ = cur->next;
            cur->next = pre;
            pre = cur;
            cur = succ;
        }
        return pre;
    }

    ListNode* reverseKGroup(ListNode* head, int k) {
        ListNode *p = head, *begin = head;
        for (int i = 0; i < k; i++) {
            if (p == nullptr)
                return head;
            p = p->next;
        }
        ListNode *reversed = reverseBetween(head, p);
        begin->next = reverseKGroup(p, k);
        return reversed;
    }
};
// @lc code=end

