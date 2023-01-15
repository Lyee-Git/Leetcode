/*
 * @lc app=leetcode.cn id=23 lang=java
 *
 * [23] 合并K个升序链表
 */
import java.util.*;
// @lc code=start
/**
 * Definition for singly-linked list.
 * 
 */
class Solution {
    // siftUp in Priority Queue
    // private static <T> void siftUpUsingComparator(
    //     int k, T x, Object[] es, Comparator<? super T> cmp) {
    //     while (k > 0) {
    //         int parent = (k - 1) >>> 1;
    //         Object e = es[parent];
    //         if (cmp.compare(x, (T) e) >= 0)
    //             break;
    //         es[k] = e;
    //         k = parent;
    //     }
    //     es[k] = x;
    // }

    
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0)
            return null;
        ListNode dummy = new ListNode(-1), p = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>
        (lists.length, (ListNode a, ListNode b) -> (a.val - b.val));
        for (ListNode head : lists) {
            if (head != null)
                pq.add(head);
        }
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            p.next = node;
            p = p.next;
            if (node.next != null)
                pq.add(node.next);
        }
        return dummy.next;
    }
}
// @lc code=end

