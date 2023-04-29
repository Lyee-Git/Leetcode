class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1) {
            return nums[0];
        }
        int n = nums.length;
        return Math.max(dp(nums, 0, n - 2), dp(nums, 1, n - 1));
    }

    public int dp(int[] nums, int start, int end) {
        int n = end - start + 1;
        if (n == 0)
            return 0;
        if (n == 1) {
            return nums[start];
        }
        int pre = nums[start];
        int cur = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i <= end; i++) {
            int next = Math.max(pre + nums[i], cur);
            pre = cur;
            cur = next;
        }
        return cur;
    }
}