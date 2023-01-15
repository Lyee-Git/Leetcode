import java.util.Random;

/*
 * @lc app=leetcode.cn id=215 lang=java
 *
 * [215] 数组中的第K个最大元素
 */
// @lc code=start
class Solution {
    public Random random = new Random();

    public int quickSelect(int[] nums, int k, int lo, int hi) {
        int index = random.nextInt(hi - lo + 1) + lo;
        int pivot = nums[index];
        nums[index] = nums[lo];
        int i = lo, j = hi;
        while (i < j) {
            while (i < j) {
                if (nums[j] < pivot)
                    j--;
                else {
                    nums[i++] = nums[j];
                    break;
                }
            }
            while (i < j) {
                if (nums[i] > pivot)
                    i++;
                else {
                    nums[j--] = nums[i];
                    break;
                }
            }
        }
        nums[i] = pivot;
        if (i < k - 1)
            return quickSelect(nums, k, i + 1, hi);
        else if (i > k - 1)
            return quickSelect(nums, k, lo, i - 1);
        else
            return nums[i];
    }

    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, k, 0, nums.length - 1);
    }
}

// class Main {
// public Random random = new Random();

// public int quickSelect(int[] nums, int k, int lo, int hi) {
// int index = random.nextInt(hi - lo + 1) + lo;
// int pivot = nums[index];
// nums[index] = nums[lo];
// int i = lo, j = hi;
// while (i < j) {
// while (i < j) {
// if (nums[j] < pivot)
// j--;
// else {
// nums[i++] = nums[j];
// break;
// }
// }
// while (i < j) {
// if (nums[i] > pivot)
// i++;
// else {
// nums[j--] = nums[i];
// break;
// }
// }
// }
// nums[i] = pivot;
// if (i < k - 1)
// return quickSelect(nums, k, i + 1, hi);
// else if (i > k - 1)
// return quickSelect(nums, k, lo, i - 1);
// else
// return nums[i];
// }

// public static void main(String[] args) {
// // Create a new Solution instance
// Main main = new Main();
// // Create a test case
// int[] nums = { 3, 2, 1, 5, 6, 4 };
// // Get the answer
// int answer = main.quickSelect(nums, 2, 0, nums.length - 1);
// // Print the answer
// System.out.println(answer);
// }
// }
// @lc code=end
