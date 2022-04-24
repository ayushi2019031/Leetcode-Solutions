class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length; 
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MIN_VALUE); 
        return fun(dp, arr, 0, k); 
    }
    public int findMax(int[] arr, int i, int j){
        int max =0; 
        for (int k = i; k <= j; k++){
            max = Math.max(arr[k], max);
        }
        
        return max; 
    }
    public int fun(int[] dp, int[] arr, int pos, int k){
        int n = dp.length; 
        if (pos >= n) return 0;
        // if (k == 1) return findMax(arr, pos, n - 1)*(n - pos); 
        if (dp[pos] != Integer.MIN_VALUE) return dp[pos]; 
        
        int ans = 0;  
        for (int i = pos + 1; i < Math.min(n , pos + k + 1); i++){
         ans = Math.max(ans, findMax(arr, pos, i - 1)*(i - pos) + fun(dp, arr, i, k));    
        }
     if (n - pos <= k)   ans = Math.max(ans, findMax(arr, pos, n - 1)*(n - pos)); 
        dp[pos] = ans; 
        return ans; 
    }
}