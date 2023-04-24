/*
 * @lc app=leetcode.cn id=148 lang=java
 *
 * [148] 排序链表
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
    public ListNode sortList(ListNode head) {
        if (head == null)
            return null;
        int len = 0;
        ListNode p = head;
        while (p != null) {
            p = p.next;
            len++;
        }
        int subLen = 1;
        ListNode dummy = new ListNode(-1, head);
        for (; subLen < len; subLen <<= 1) {
            ListNode cur = dummy.next, prev = dummy;
            while (cur != null) {
                ListNode p1 = cur;
                for (int i = 1; i < subLen && cur.next != null; i++) {
                    cur = cur.next;
                }
                // && cur.next != null保证了cur一定不为空(cur.next可能为空)
                // 否则此处取cur.next会出错
                ListNode p2 = cur.next;
                cur.next = null;
                cur = p2;
                for (int i = 1; i < subLen && cur != null; i++) {
                    cur = cur.next;
                }
                ListNode next = null;
                if (cur != null) {
                    next = cur.next;
                    cur.next = null;
                }
                ListNode merged = merge(p1, p2);
                prev.next = merged;
                while (prev.next != null)
                    prev = prev.next;
                cur = next;
            }
        }
        return dummy.next;
    }

    // Note that p1 and p2 should be finite (end with null after its length)
    private ListNode merge(ListNode p1, ListNode p2) {
        ListNode dummy = new ListNode(-1), head1 = p1, head2 = p2, p = dummy;
        while (head1 != null && head2 != null) {
            if (head1.val <= head2.val) {
                p.next = head1;
                head1 = head1.next;
            } else {
                p.next = head2;
                head2 = head2.next;
            }
            p = p.next;
        }
        if (head1 != null) {
            p.next = head1;
        }
        if (head2 != null) {
            p.next = head2;
        }
        return dummy.next;
    }

    // public static void main(String[] args) {
    // ListNode head = new ListNode(-1, new ListNode(0, new ListNode(3, new
    // ListNode(4, new ListNode(5)))));
    // Main m = new Main();
    // m.sortList(head);
    // }
}
// @lc code=end
