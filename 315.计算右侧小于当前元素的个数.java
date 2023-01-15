import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=315 lang=java
 *
 * [315] 计算右侧小于当前元素的个数
 */

// @lc code=start
class Solution {
    private class pair {
        int val, index;
        pair(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }
    private pair[] temp;
    private int[] count;
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        pair[] arr = new pair[n];
        temp = new pair[n];
        count = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new pair(nums[i], i);
        }
        sort(arr, 0, n - 1);
        List<Integer> res = new ArrayList<>(n);
        for (int cnt : count)
            res.add(cnt);
        return res;
    }

    private void sort(pair[] arr, int lo, int hi) {
        if (lo == hi)
            return;
        int mid = lo + (hi - lo) / 2;
        sort(arr, lo, mid);
        sort(arr, mid + 1, hi);
        merge(arr, lo, mid, hi);
    }

    private void merge(pair[] arr, int lo, int mid, int hi) {
        int n = arr.length;
        for (int i = lo; i <= hi; i++)
            temp[i] = arr[i];
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i == mid + 1)
                arr[k] = temp[j++];
            else if (j == hi + 1) {
                arr[k] = temp[i++];
                count[arr[k].index] += j - mid - 1;
            }
            else if (temp[i].val > temp[j].val) {
                arr[k] = temp[j++];
            }
            else { // temp[i].val <= temp[j].val
                arr[k] = temp[i++];
                count[arr[k].index] += j - mid - 1;
            }
        }
    }

}
// @lc code=end

