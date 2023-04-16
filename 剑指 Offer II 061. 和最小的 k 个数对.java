import java.util.*;

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(k, (int[] a, int[] b) -> {
            return nums1[a[0]] + nums2[a[1]] - nums1[b[0]] - nums2[b[1]];
        });
        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            pq.offer(new int[] { i, 0 });
        }
        List<List<Integer>> res = new LinkedList<>();
        while (k > 0 && !pq.isEmpty()) {
            int[] top = pq.poll();
            List<Integer> cur = new LinkedList<>();
            cur.add(nums1[top[0]]);
            cur.add(nums2[top[1]]);
            res.add(cur);
            if (top[1] + 1 < nums2.length) {
                pq.offer(new int[] { top[0], top[1] + 1 });
            }
            k--;
        }
        return res;
    }
}
