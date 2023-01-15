/*
 * @lc app=leetcode.cn id=23 lang=cpp
 *
 * [23] 合并K个升序链表
 */

#include<string>
#include<algorithm>
#include<vector>
#include<queue>
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
    struct greater_ListNode {
        ListNode *node;
        greater_ListNode(ListNode *nd) : node(nd) {}
        bool operator< (const greater_ListNode &another) const {
            return node->val > another.node->val;
        }
    };

    ListNode* mergeKLists(vector<ListNode*>& lists) {
        ListNode *dummy = new ListNode(-1), *p = dummy;
        priority_queue<greater_ListNode> pq;
        for (auto listnode : lists)
            if (listnode != nullptr)
                pq.emplace(greater_ListNode(listnode));
        while (!pq.empty()) {
            ListNode *cur = pq.top().node;
            pq.pop();
            p->next = cur;
            p = p->next;
            if (cur->next != nullptr) {
                pq.emplace(greater_ListNode(cur->next));
            }
        }
        return dummy->next;
    }
};
// @lc code=end

