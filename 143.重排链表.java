/*
 * @lc app=leetcode.cn id=143 lang=java
 *
 * [143] 重排链表
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
    public void reorderList(ListNode head) {
        if (head == null)
            return;
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // Reverse second half of list
        ListNode cur = slow.next, pre = null;
        slow.next = null;
        while (cur != null) {
            ListNode succ = cur.next;
            cur.next = pre;
            pre = cur;
            cur = succ;
        }
        // Merge two halves
        ListNode list1 = head, list2 = pre;
        while (list1 != null && list2 != null) {
            ListNode succ1 = list1.next, succ2 = list2.next;
            list1.next = list2;
            list2.next = succ1;
            list1 = succ1;
            list2 = succ2;
        }
    }
}
// @lc code=end
