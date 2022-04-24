class Solution {
    int[][] dp;
    public int solve(int n, int eggs){
        
        if (dp[n][eggs] != -1) return dp[n][eggs]; 
        if (n <= 1 || eggs == 1){
            return n; 
        }
        int mini = Integer.MAX_VALUE; 
        for (int i = 1; i < n; i++){
            mini = Math.min(mini, 1 + Math.max(solve(i - 1, eggs - 1), solve(n - i , eggs))); 
        }
        dp[n][eggs] = mini; 
        return mini; 
    }
    public int twoEggDrop(int n) {
        dp = new int[n + 1][3]; 
        for (int i = 0; i < n + 1; i++){Arrays.fill(dp[i], -1); }
        return solve(n, 2); 
    }
}