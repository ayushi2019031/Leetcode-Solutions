class Solution {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length; 
        int[][] dp = new int[n][2]; 
        //0 meaning down 1 meaning up
        for (int[] row: dp){
            Arrays.fill(row, 1);
        }
        dp[0][0] = dp[0][1] = 1; 
        for (int i = 1; i < n; i++){
            for (int j = 0; j < i; j++){
                if (nums[j] > nums[i]){
                    dp[i][0] = Math.max(dp[i][0], dp[j][1] + 1);
                }
                else if (nums[j] < nums[i]){
                    dp[i][1] = Math.max(dp[i][1], dp[j][0] + 1);
                }
            }
        }
        return Math.max(dp[n - 1][0], dp[n - 1][1]);
        
    }
}