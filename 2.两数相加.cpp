/*
 * @lc app=leetcode.cn id=2 lang=cpp
 *
 * [2] 两数相加
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
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        ListNode *p1 = l1, *p2 = l2;
        ListNode *dummy = new ListNode(-1);
        ListNode *p = dummy;
        int carry = 0;
        while (p1 != nullptr || p2 != nullptr || carry > 0) {
            int cur_val = carry;
            if (p1 != nullptr) {
                cur_val += p1->val;
                p1 = p1->next;
            }
            if (p2 != nullptr) {
                cur_val += p2->val;
                p2 = p2->next;
            }
            carry = cur_val / 10;
            cur_val %= 10;
            ListNode *cur = new ListNode(cur_val);
            p->next = cur;
            p = p->next;
        }
        return dummy->next;
    }
};
// @lc code=end

