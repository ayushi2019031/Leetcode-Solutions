class Solution {
    public int countSubstrings(String s, String t) {
        int slen = s.length(); 
        int tlen = t.length(); 
        
        int[][][] dp = new int[slen][tlen][2];
        
        for (int i = 0; i < slen; i++){
            for (int j = 0; j < tlen; j++){
                if (s.charAt(i) == t.charAt(j)){
                    dp[i][j][0] = 1; 
                }
                else {
                    dp[i][j][1] =1; 
                }
            }
        }
        
        for (int i = 1; i < slen; i++){
            for (int j = 1; j < tlen; j++){
                if (s.charAt(i) == t.charAt(j)){
                    dp[i][j][0] += dp[i - 1][j - 1][0]; 
                    dp[i][j][1] += dp[i - 1][j - 1][1]; 
                }
                else {
                    dp[i][j][1] += dp[i - 1][j - 1][0]; 
                }
            }
        }
        int ans = 0; 
        
        for (int i = 0; i < slen; i++){
            for (int j = 0; j < tlen; j++){
                ans += dp[i][j][1]; 
            }
        }
        return ans; 
        
    }
}