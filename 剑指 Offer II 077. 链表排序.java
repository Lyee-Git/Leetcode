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
        int len = 0, subLen = 1;
        ListNode p = head, dummy = new ListNode(-1, head);
        while (head != null) {
            len++;
            head = head.next;
        }
        for (; subLen < len; subLen *= 2) {
            ListNode cur = dummy.next, prev = dummy;
            while (cur != null) {
                ListNode first = cur;
                for (int i = 1; i < subLen && cur.next != null; i++) {
                    cur = cur.next;
                }
                ListNode second = cur.next;
                cur.next = null;
                cur = second; // cur could be null here
                for (int i = 1; i < subLen && cur != null; i++) {
                    cur = cur.next;
                }
                if (cur != null) {
                    ListNode nextCur = cur.next;
                    cur.next = null;
                    cur = nextCur;
                } else {
                    cur = null;
                }
                ListNode merged = mergeList(first, second);
                prev.next = merged;
                while (prev.next != null) {
                    prev = prev.next;
                }
            }
        }
        return dummy.next;
    }

    public ListNode mergeList(ListNode p1, ListNode p2) {
        ListNode dummy = new ListNode(-1), cur = dummy;
        while (p1 != null || p2 != null) {
            if (p1 == null) {
                cur.next = p2;
                break;
            } else if (p2 == null) {
                cur.next = p1;
                break;
            } else if (p1.val < p2.val) {
                cur.next = p1;
                cur = cur.next;
                p1 = p1.next;
            } else {
                cur.next = p2;
                cur = cur.next;
                p2 = p2.next;
            }
        }
        return dummy.next;
    }
}