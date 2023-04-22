import java.util.*;

class Solution {
    public Random random = new Random();

    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, k);
    }

    int quickSelect(int[] nums, int lo, int hi, int k) {
        int picked = random.nextInt(hi - lo + 1) + lo;
        int pivot = nums[picked];
        nums[picked] = nums[lo];
        int i = lo, j = hi;
        while (i < j) {
            while (i < j) {
                if (nums[j] < pivot) {
                    j--;
                } else {
                    nums[i++] = nums[j];
                    break;
                }
            }
            while (i < j) {
                if (nums[i] > pivot) {
                    i++;
                } else {
                    nums[j--] = nums[i];
                    break;
                }
            }
        }
        nums[i] = pivot;
        if (i == k - 1)
            return nums[i];
        else if (i < k - 1)
            return quickSelect(nums, i + 1, hi, k);
        else
            return quickSelect(nums, lo, i - 1, k);
    }
}