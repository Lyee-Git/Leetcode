/*
 * @lc app=leetcode.cn id=92 lang=java
 *
 * [92] 反转链表 II
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
    ListNode next = null;

    private ListNode reverseN(ListNode head, int N) {
        if (N == 1) {
            next = head.next;
            return head;
        }
        ListNode newHead = reverseN(head.next, N - 1);
        head.next.next = head;
        head.next = next;
        return newHead;
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == 1) {
            return reverseN(head, right);
        } else {
            head.next = reverseBetween(head.next, left - 1, right - 1);
            return head;
        }
    }
}
// @lc code=end
