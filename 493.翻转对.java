/*
 * @lc app=leetcode.cn id=493 lang=java
 *
 * [493] 翻转对
 */
import java.util.ArrayList;
import java.util.List;
// @lc code=start
class Solution {
    int count = 0;
    int[] temp;
    public int reversePairs(int[] nums) {
        int n = nums.length;
        temp = new int[n];
        sort(nums, 0, n - 1);
        return count;
    }

    void sort(int[] nums, int lo, int hi) {
        if (lo == hi)
            return;
        int mid = lo + (hi - lo) / 2;
        sort(nums, lo, mid);
        sort(nums, mid + 1, hi);
        merge(nums, lo, mid, hi);
    }

    void merge(int[] nums, int lo, int mid, int hi) {
        for (int i = lo; i <= hi; i++) {
            temp[i] = nums[i];
        }
        int start = mid + 1, end = mid + 1;
        for (int i = lo; i < mid + 1; i++) {
            while (end <= hi && (long)2 * nums[end] < (long)nums[i])
                end++;
            count += end - start;
        }
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i == mid + 1)
                nums[k] = temp[j++];
            else if (j == hi + 1)
                nums[k] = temp[i++];
            else if (temp[i] <= temp[j])
                nums[k] = temp[i++];
            else
                nums[k] = temp[j++];
        }
    }
}
// @lc code=end

