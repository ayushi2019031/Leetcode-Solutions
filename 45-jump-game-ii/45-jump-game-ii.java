class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        Integer[] dp = new Integer[n];
        return fun(dp, nums, 0, n);
    }
    public int fun(Integer[] dp, int[] nums, int pos, int n){
        // System.out.println(pos);
        if (pos >= n - 1) return 0;
        if (dp[pos] != null) return dp[pos];
        int mini = Integer.MAX_VALUE;
        // if (nums[pos] == 0){return Integer.MAX_VALUE;}
        for (int k = pos + 1; k <= pos + nums[pos]; k++){
            mini = Math.min(mini, fun(dp, nums, k, n));
        }
        if (mini == Integer.MAX_VALUE) return mini;
        mini += 1;
        dp[pos] = mini;
        // System.out.println(Arrays.toString(dp));
        return mini;
    }
}