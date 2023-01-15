/*
 * @lc app=leetcode.cn id=560 lang=java
 *
 * [560] 和为 K 的子数组
 */
import java.util.HashMap;
// @lc code=start
// class Main {
//     public static void main(String[] args) {
//         // Create a new Solution instance
//         Solution solution = new Solution();
//         // Create a test case
//         String testCase = "()[]{}";
//         // Get the answer
//         boolean answer = solution.isValid(testCase);
//         // Print the answer
//         System.out.println(answer);
//     }
// }
class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length, res = 0, sum = 0;
        HashMap<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);
        for (int i = 1; i <= n; i++) {
            sum += nums[i - 1];
            if (preSum.containsKey(sum - k)) {
                res += preSum.getOrDefault(sum - k, 0);
            }
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}
// @lc code=end

