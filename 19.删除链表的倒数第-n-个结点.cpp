/*
 * @lc app=leetcode.cn id=19 lang=cpp
 *
 * [19] 删除链表的倒数第 N 个结点
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
    ListNode *FindReverseNth(ListNode *dummy, int n) {
        ListNode *p1 = dummy, *p2 = dummy;
        for (int i = 0; i < n; i++) {
            p1 = p1->next; // p1 has no: n
        }
        while (p1 != nullptr) { // p1和p2一起向前移动 num + 1 - n次
            p1 = p1->next;
            p2 = p2->next; // p2编号为num + 1 - n, 恰为倒数第n个
        }
    }

    ListNode* removeNthFromEnd(ListNode* head, int n) {
        ListNode *dummy = new ListNode(-1);
        dummy->next = head;
        ListNode *p1 = dummy, *p2 = dummy;
        // 获得倒数 n + 1个节点
        for (int i = 0; i < n + 1; i++) {
            p1 = p1->next; 
        }
        while (p1 != nullptr) {
            p1 = p1->next;
            p2 = p2->next;
        }
        p2->next = p2->next->next;
        return dummy->next;
    }
};
// @lc code=end

