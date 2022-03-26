class Solution {
    public int longestPalindromeSubseq(String s) {
        int n =s.length(); 
        char[] arr = s.toCharArray();
        int[][] dp = new int[n][n];
        
        for (int i = 0; i < n; i++) dp[i][i] = 1; 
        for (int i = 0; i < n; i ++){
            for (int j  = 0, k = i; k < n; j++, k++){
                if (i == 0) dp[j][k] = 1; 
                else if (i == 1){
                    if (arr[j] == arr[k]){
                        dp[j][k] = 2; 
                    }
                    else {dp[j][k] = 1;}
                }
                else{
               //     System.out.println(j + " " + k);
                    if (arr[j] == arr[k]){
                        dp[j][k] = Math.max(dp[j][k], 2 + dp[j + 1][k - 1]);
                    }
                    else{
                    dp[j][k] = Math.max(dp[j][k], dp[j + 1][k]);
                    dp[j][k] = Math.max(dp[j][k], dp[j ][k -1]);
                    }
                }
            }
        }
        return dp[0][n - 1];
    }
}