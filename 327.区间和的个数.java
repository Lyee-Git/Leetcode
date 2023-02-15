/*
 * @lc app=leetcode.cn id=327 lang=java
 *
 * [327] 区间和的个数
 */
import java.util.*;
// @lc code=start
class Solution {
    int low = 0, high = 0, count = 0;
    long[] temp;
    public int countRangeSum(int[] nums, int lower, int upper) {
        this.low = lower;
        this.high = upper;
        int n = nums.length;
        long[] preSum = new long[n + 1];
        this.temp = new long[n + 1];
        preSum[0] = 0;
        for (int i = 0; i < n; i++)
            preSum[i + 1] = preSum[i] + nums[i];
        sort(preSum, 0, n);
        return count;
    }

    private void sort(long[] arr, int lo, int hi) {
        if (lo == hi)
            return;
        int mid = lo + (hi - lo) / 2;
        sort(arr, lo, mid);
        sort(arr, mid + 1, hi);
        merge(arr, lo, mid, hi);
    }

    private void merge(long[] arr, int lo, int mid, int hi) {
        // int n = arr.length;
        int start = mid + 1, end = mid + 1;
        for (int i = lo; i < mid + 1; i++) {
            while (start <= hi && arr[start] - arr[i] < this.low)
                start++;
            while (end <= hi && arr[end] - arr[i] <= this.high)
                end++;
            this.count += end - start; // [start, end)
        }
        for (int i = lo; i <= hi; i++)
            temp[i] = arr[i];
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i == mid + 1)
                arr[k] = temp[j++];
            else if (j == hi + 1) {
                arr[k] = temp[i++];
            }
            else if (temp[i] > temp[j]) {
                arr[k] = temp[j++];
            }
            else { // temp[i].val <= temp[j].val
                arr[k] = temp[i++];
            }
        }
    }
}
// @lc code=end

