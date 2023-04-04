import java.util.List;

/*
 * @lc app=leetcode.cn id=142 lang=java
 *
 * [142] 环形链表 II
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
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                ListNode p = head;
                while (p != slow) {
                    p = p.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }

    // public static void main(String[] args) {
    // ListNode head = new ListNode(3, new ListNode(2, new ListNode(0, new
    // ListNode(-4))));
    // ListNode target = head.next;
    // ListNode tail = head;
    // for (int i = 0; i < 3; i++)
    // tail = tail.next;
    // tail.next = target;
    // Main main = new Main();
    // main.detectCycle(head);
    // }
}
// @lc code=end
