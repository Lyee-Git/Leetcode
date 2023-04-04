/*
 * @lc app=leetcode.cn id=25 lang=java
 *
 * [25] K 个一组翻转链表
 */

// @lc code=start
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
    private ListNode reverseBetween(ListNode head, ListNode tail) {
        if (head == tail) {
            return head;
        }
        ListNode newHead = reverseBetween(head.next, tail);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode tail = head;
        for (int i = 0; i < k - 1; i++) {
            if (tail == null) {
                return head;
            }
            tail = tail.next;
        }
        if (tail == null) {
            return head;
        }
        ListNode succ = tail.next;
        ListNode newHead = reverseBetween(head, tail);
        head.next = reverseKGroup(succ, k);
        return newHead;
    }
}
// @lc code=end
