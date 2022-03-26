class Solution {
    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length; 
        Integer[][] dp = new Integer[n][n];
        
        fun(dp, nums, 0, n - 1);
        return dp[0][n - 1] >= 0;
    }
    public int fun(Integer[][] dp, int[] nums, int i, int j){
        if (i == j){dp[i][j] = nums[i]; return nums[i];}
        if (i > j) return 0; 
        if (dp[i][j] != null) return dp[i][j];
        
            int a  = nums[i] - fun(dp, nums, i + 1, j);
            int b = nums[j] - fun(dp, nums, i, j - 1 );
        
    dp[i][j] = Math.max(a, b);
        return dp[i][j];
    }
}