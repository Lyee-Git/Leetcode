/*
 * @lc app=leetcode.cn id=147 lang=java
 *
 * [147] 对链表进行插入排序
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode lastSorted = head, cur = head.next;
        while (cur != null) {
            if (cur.val > lastSorted.val) {
                lastSorted.next = cur;
                lastSorted = cur;
            } else {
                ListNode p = dummy;
                while (cur.val > p.next.val) {
                    p = p.next;
                }
                lastSorted.next = cur.next;
                cur.next = p.next;
                p.next = cur;
            }
            cur = lastSorted.next;
        }
        return dummy.next;
    }
}
// @lc code=end
