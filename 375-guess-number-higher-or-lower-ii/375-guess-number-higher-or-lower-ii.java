class Solution {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) Arrays.fill(dp[i], -1);
        return fun(dp, 1, n);
        
    }
    public int fun(int[][] dp, int min, int max){
        if (max <= min) return 0; 
        
        int ans = Integer.MAX_VALUE; 
        
        if (dp[min][max] != -1) return dp[min][max];
        
        for (int i = min; i <= max; i++){
            int low = i + fun(dp, i + 1, max);
            int high = i + fun(dp, min, i - 1);
            ans = Math.min(ans, Math.max(low, high));    
        }
        dp[min][max] = ans; 
        return ans; 
    }
}