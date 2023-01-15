
/*
 * @lc app=leetcode.cn id=698 lang=java
 *
 * [698] 划分为k个相等的子集
 */
import java.util.*;

// @lc code=start
class Solution {
    // 解法1： Backtrack
    int used;
    int target;
    HashMap<Integer, Boolean> dp = new HashMap<>();

    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (k > nums.length)
            return false;
        int sum = 0;
        for (int num : nums)
            sum += num;
        Arrays.sort(nums);
        if (sum % k != 0)
            return false;
        target = sum / k;
        used = 0;
        return backtrack(k, 0, nums, 0);
    }

    boolean backtrack(int k, int bucket, int[] nums, int start) {
        if (k == 0)
            return true;
        if (bucket == target) {
            boolean res = backtrack(k - 1, 0, nums, 0);
            dp.put(used, res);
            return res;
        }
        if (dp.containsKey(used))
            return dp.get(used);
        for (int i = start; i < nums.length; i++) {
            if (((used >> i) & 1) == 1)
                continue;
            if (bucket + nums[i] > target)
                continue;
            bucket += nums[i];
            used |= 1 << i;
            if (backtrack(k, bucket, nums, i + 1))
                return true;
            used ^= 1 << i;
            bucket -= nums[i];
            while (i + 1 < nums.length && nums[i + 1] == nums[i])
                i++;
        }
        return false;
    }

}
// @lc code=end
