class Solution {
    int[][] dp; 
    int[][] matrix;
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        dp = new int[n][n];
        this.matrix = matrix;
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++){
            ans = Math.min(ans, fun(0, i));
        }
        return ans; 
    }
    public int fun(int i, int j){
        if (i < 0 || j < 0 || i >= dp.length || j >= dp.length) return 0; 
        if (i == dp.length - 1) return matrix[i][j];
        if (dp[i][j] != -1) return dp[i][j];
        int ans = matrix[i][j]  + fun(i + 1, j);
        
        if (j > 0) ans = Math.min(ans, matrix[i][j] + fun(i + 1, j - 1));
        if (j < dp.length - 1)ans = Math.min(ans, matrix[i][j] + fun(i + 1, j + 1));
        
        dp[i][j] = ans;
        return ans;
    }
    
}