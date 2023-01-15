/*
 * @lc app=leetcode.cn id=83 lang=cpp
 *
 * [83] 删除排序链表中的重复元素
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
    ListNode* deleteDuplicates(ListNode* head) {
        if (head == nullptr)
            return head;
        ListNode *slow = head, *fast = head->next;
        while (fast != nullptr) {
            if (fast->val != slow->val) {
                slow->next = fast;
                slow = slow->next;
            }
            fast = fast->next;
        }
        // truncate tail part
        slow->next = nullptr;
        return head;
    }
};
// @lc code=end

