class Solution {
    Integer[][] maxele; 
    Integer[][] dp; 
    int[] arr; 
    public int mctFromLeafValues(int[] arr) {
        int n = arr.length; 
        this.maxele = new Integer[n][n];
        this.dp = new Integer[n][n]; 
        this.arr = arr; 
        for (int i = 0; i < n; i++){
            maxele[i][i] = arr[i]; 
            dp[i][i] = 0; 
        }
        return dp(0, n - 1); 
    }
    public int dp(int i, int j){
        if (i > j) return 0; 
        if (dp[i][j] != null) return dp[i][j]; 
        maxele[i][j] = arr[i];
        if (j == i + 1){
            maxele[i][j] = Math.max(arr[i], arr[j]);
            dp[i][j] = maxele[i][i]*maxele[j][j];
            return dp[i][j];
        }
        int ans = Integer.MAX_VALUE; 
        maxele[i][j] = arr[i]; 
        for (int k = i; k <j ; k++){
            int m1 = dp(i, k); 
            int m2 = dp(k + 1, j);
            System.out.println(m1 + " " + m2 + " " + maxele[i][k] + " " + maxele[k + 1][j]); 
            maxele[i][j] = Math.max(maxele[i][j], Math.max(maxele[i][k], maxele[k + 1][j]));
            ans = Math.min(ans, maxele[i][k]*maxele[k + 1][j]  + dp[i][k] + dp[k + 1][j]);
            
        }
        dp[i][j] = ans; 
        return ans; 
        
    }
    
}