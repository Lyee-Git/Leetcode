
/*
 * @lc app=leetcode.cn id=445 lang=java
 *
 * [445] 两数相加 II
 */
import java.util.*;

// @lc code=start
// class ListNode {
//     int val;
//     ListNode next;

//     ListNode() {
//     }

//     ListNode(int val) {
//         this.val = val;
//     }

//     ListNode(int val, ListNode next) {
//         this.val = val;
//         this.next = next;
//     }
// }

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>(), stack2 = new Stack<>();
        ListNode head1 = l1, head2 = l2;
        while (head1 != null) {
            stack1.push(head1.val);
            head1 = head1.next;
        }
        while (head2 != null) {
            stack2.push(head2.val);
            head2 = head2.next;
        }
        int carry = 0;
        ListNode succ = null;
        while (!stack1.empty() || !stack2.empty() || carry != 0) {
            int num1 = 0, num2 = 0;
            if (!stack1.isEmpty()) {
                num1 = stack1.pop();
            }
            if (!stack2.empty()) {
                num2 = stack2.pop();
            }
            int res = num1 + num2 + carry;
            ListNode cur = new ListNode(res % 10);
            cur.next = succ;
            succ = cur;
            carry = res / 10;
        }
        return succ;
    }
}
// @lc code=end
