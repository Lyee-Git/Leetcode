/*
 * @lc app=leetcode.cn id=21 lang=cpp
 *
 * [21] 合并两个有序链表
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
    ListNode* mergeTwoLists(ListNode* list1, ListNode* list2) {
        ListNode *dummy = new ListNode(-1), *p = dummy;
        ListNode *p1 = list1, *p2 = list2;
        while (p1 != nullptr || p2 != nullptr) {
            if (p1 != nullptr && p2 != nullptr) {
                if (p1->val <= p2->val) {
                    p->next = p1;
                    p1 = p1->next;
                    p = p->next;
                }
                else {
                    p->next = p2;
                    p2 = p2->next;
                    p = p->next;
                }
            }
            else if (p1 != nullptr) {
                p->next = p1;
                p1 = p1->next;
                p = p->next;
            }
            else {
                p->next = p2;
                p2 = p2->next;
                p = p->next;
            }
        }
        return dummy->next;
    }
};
// @lc code=end

