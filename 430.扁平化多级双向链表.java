import java.text.BreakIterator;

/*
 * @lc app=leetcode.cn id=430 lang=java
 *
 * [430] 扁平化多级双向链表
 */

// @lc code=start
/*
// Definition for a Node.
*/
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node prev, Node next, Node child) {
        this.val = val;
        this.prev = prev;
        this.next = next;
        this.child = child;
    }
};

class Solution {
    public Node flatten(Node head) {
        dfs(head);
        return head;
    }

    public Node dfs(Node node) {
        Node cur = node, last = null;
        while (cur != null) {
            if (cur.child == null) {
                if (cur.next == null) {
                    last = cur;
                    break;
                }
                cur = cur.next;
                continue;
            }
            Node lastChild = dfs(cur.child);
            Node succ = cur.next;
            cur.next = cur.child;
            cur.child.prev = cur;
            lastChild.next = succ;
            if (succ != null) {
                succ.prev = lastChild;
            }
            cur.child = null;
            cur = cur.next;
        }
        return last;
    }

    // public static void main(String[] args) {
    // Node l1 = new Node(1), l2 = new Node(2), l3 = new Node(3);
    // Node l4 = new Node(4), l5 = new Node(5), l6 = new Node(6), l7 = new Node(7);
    // l1.next = l2; l2.prev = l1; l3.prev = l2; l2.next = l3; l2.child = l4;
    // l4.next = l5; l5.prev = l4; l5.next = l6; l6.prev = l5; l5.child = l7;
    // Main main = new Main();
    // main.dfs(l1);
    // }
}
// @lc code=end
