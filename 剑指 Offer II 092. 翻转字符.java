class Solution {
    public int minFlipsMonoIncr(String s) {
        int[] dp = new int[2];
        int n = s.length();
        for (char c : s.toCharArray()) {
            int newDp0 = c == '1' ? 1 : 0;
            int newDp1 = c == '0' ? 1 : 0;
            newDp0 += dp[0];
            newDp1 += Math.min(dp[0], dp[1]);
            dp[0] = newDp0;
            dp[1] = newDp1;
        }
        return Math.min(dp[0], dp[1]);
    }
}