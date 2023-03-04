
/*
 * @lc app=leetcode.cn id=18 lang=java
 *
 * [18] 四数之和
 */
import java.util.*;

// @lc code=start
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return nSumTargat(nums, 4, 0, target);
    }

    List<List<Integer>> nSumTargat(int[] nums, int n, int start, long target) {
        List<List<Integer>> res = new LinkedList<>();
        int len = nums.length;
        if (len < n || n < 2)
            return res;
        if (n == 2) {
            int lo = start, hi = nums.length - 1;
            while (lo < hi) {
                long left = nums[lo], right = nums[hi];
                long sum = left + right;
                if (sum < target) {
                    while (lo < hi && nums[lo] == left)
                        lo++;
                } else if (sum > target) {
                    while (lo < hi && nums[hi] == right)
                        hi--;
                } else {
                    res.add(new LinkedList<>(Arrays.asList(nums[lo], nums[hi])));
                    while (lo < hi && nums[lo] == left)
                        lo++;
                    while (lo < hi && nums[hi] == right)
                        hi--;
                }
            }
        } else {
            for (int i = start; i < len; i++) {
                int selected = nums[i];
                List<List<Integer>> tuples = nSumTargat(nums, n - 1, i + 1, (long) target - selected);
                for (List<Integer> tuple : tuples) {
                    tuple.add(selected);
                    res.add(tuple);
                }
                while (i < len - 1 && nums[i + 1] == selected)
                    i++;
            }
        }
        return res;
    }
}
// @lc code=end
