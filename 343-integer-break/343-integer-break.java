class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        int max = 0; 
        
        return fun(dp, n);
    }
    public int fun(int[] dp,int pos){
        if (pos == 0) return 1; 
        if (dp[pos] != -1) return dp[pos];
        int ans = 1; 
        for (int i = 1; i < pos; i++){
         ans = Math.max(ans, (pos - i)*(fun(dp, i)));
         ans = Math.max(ans, (pos - i)*i);
        
        }
        dp[pos] = ans;
        return ans;
    }
    
}