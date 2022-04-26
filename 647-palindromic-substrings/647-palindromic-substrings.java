class Solution {
    public int countSubstrings(String s) {
        int n = s.length(); 
        int[][] dp = new int[n][n]; 
        int[][] ispal = new int[n][n]; 
        for (int i = 0; i < n; i++){dp[i][i] = 1; ispal[i][i] = 1; }
        for (int i = 0; i < n - 1; i++){
            if (s.charAt(i) == s.charAt(i + 1)){dp[i][i + 1] = 3; ispal[i][i + 1] = 1; }
            else {dp[i][i + 1] = 2; }
        }
        
        for (int k = 2; k < n; k++){
            for (int i = 0; i + k < n; i++){
                dp[i][i + k] = dp[i + 1][i + k] + dp[i][i + k - 1] - dp[i + 1][i + k - 1];
                
                if (s.charAt(i) == s.charAt(i + k) && ispal[i + 1][i + k - 1] == 1){
                    ispal[i][i + k] = 1; 
                    dp[i][i + k] += 1; 
                }
                
                    
                 
                
            }
        }
        return dp[0][n - 1]; 
        
    }
}