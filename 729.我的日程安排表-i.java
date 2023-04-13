
/*
 * @lc app=leetcode.cn id=729 lang=java
 *
 * [729] 我的日程安排表 I
 */
import java.util.*;

// @lc code=start
class MyCalendar {
    class SegTree {
        int l, r, val;
        SegTree left, right;

        public SegTree(int l, int r, int val) {
            this.l = l;
            this.r = r;
            this.val = val;
        }
    }

    SegTree segTree;

    public MyCalendar() {
        segTree = new SegTree(0, (int) 1e9 - 1, 0);
    }

    public boolean book(int start, int end) {
        if (queryBooking(this.segTree, start, end - 1)) {
            addBooking(this.segTree, start, end - 1);
            return true;
        }
        return false;
    }

    public void addBooking(SegTree segTree, int start, int end) {
        int l = segTree.l, r = segTree.r;
        int mid = (l + r) / 2;
        if (l == start && r == end) {
            segTree.val++;
            // end of recursion
            if (l == r)
                return;
            if (segTree.left != null) {
                addBooking(segTree.left, start, mid);
            }
            if (segTree.right != null) {
                addBooking(segTree.right, mid + 1, end);
            }
        } else if (start > mid) {
            addBooking(segTree.right, start, end);
        } else if (end <= mid) {
            addBooking(segTree.left, start, end);
        } else {
            addBooking(segTree.left, start, mid);
            addBooking(segTree.right, mid + 1, end);
        }
    }

    public boolean queryBooking(SegTree segTree, int start, int end) {
        if (segTree.val > 0) {
            return false;
        }
        int l = segTree.l, r = segTree.r;
        int mid = (l + r) / 2;
        if (l == start && r == end) {
            return (segTree.left == null || queryBooking(segTree.left, l, mid))
                    && (segTree.right == null || queryBooking(segTree.right, mid + 1, r));
        } else if (end <= mid) {
            if (segTree.left == null) {
                segTree.left = new SegTree(l, mid, segTree.val);
            }
            return queryBooking(segTree.left, start, end);
        } else if (start > mid) {
            if (segTree.right == null) {
                segTree.right = new SegTree(mid + 1, r, segTree.val);
            }
            return queryBooking(segTree.right, start, end);
        } else {
            // [left, right] contains mid
            if (segTree.left == null) {
                segTree.left = new SegTree(l, mid, segTree.val);
            }
            if (segTree.right == null) {
                segTree.right = new SegTree(mid + 1, r, segTree.val);
            }
            return queryBooking(segTree.left, start, mid)
                    && queryBooking(segTree.right, mid + 1, end);
        }
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
// @lc code=end
