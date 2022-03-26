class Solution {
    public int longestArithSeqLength(int[] nums) {
        int[] arr = nums;
       int n = nums.length;
        int[][] dp = new int[n][1001]; 
        for (int i = 0; i < n; i++){
            Arrays.fill(dp[i], 1);
        }
        dp[0][0] = 1; 
                int ans = 2;
        for (int i = 1; i < n; i++){
            for (int j = 0; j < i; j++){
                int diff = arr[i] - arr[j];
                dp[i][diff + 500]  = Math.max(dp[i][diff + 500], dp[j][diff + 500] + 1);
                dp[i][diff + 500]  = Math.max(dp[i][diff + 500], 1 + 1);
ans = Math.max(ans, dp[i][diff + 500]);
            }
            // System.out.println(dp[i][0] + " " + dp[i][1]);
        }
 
        for (int i = 0; i < 1001; i++) ans  = Math.max(ans, dp[n- 1][i]);
        return ans;
    }
}