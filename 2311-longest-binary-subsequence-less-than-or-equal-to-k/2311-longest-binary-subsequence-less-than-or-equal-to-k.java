class Solution {
    public int longestSubsequence(String s, int k) {
        int left = 0, right = 0;
        int maxLen = k > 0 ? 1: 0;
        long[][] dp = new long[s.length()][s.length()  + 1];
        dp[0][0] = 0;
        dp[0][1] = s.charAt(0) - '0';

        for(int i = 1; i < s.length(); ++i) {
            int cur = s.charAt(i) - '0';
           for(int j = 1; j <= i + 1; ++j) {
               dp[i][j] = dp[i-1][j-1] * 2 + cur;
               if(j <= i && dp[i-1][j] >= 0) {
                   dp[i][j] = Math.min(dp[i][j], dp[i-1][j]);
               }
               
               if(dp[i][j] <= k) {
                   maxLen = Math.max(maxLen, j);
               }
               
               if(dp[i][j] >= Integer.MAX_VALUE) {
                   dp[i][j] = Integer.MAX_VALUE;
               }
           } 
        }
        
        return maxLen;
    }
}