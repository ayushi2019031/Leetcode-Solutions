class Solution {
    // long[] dp; 
    int MOD = 1000000000 + 7; 
    HashMap<Integer, int[]> hash;
    int[][] dp; 
    public int knightDialer(int n) {
        dp = new int[n + 1][10];
        int ans = 0;
        hash = new HashMap<>(); 
        hash.put(0, new int[]{4, 6});
        hash.put(1, new int[]{8, 6});
        hash.put(2, new int[]{7, 9});
        hash.put(3, new int[]{4, 8});
        hash.put(4, new int[]{0, 3, 9});
        hash.put(5, new int[]{});
        hash.put(6, new int[]{0, 7, 1});
        hash.put(7, new int[]{2, 6});
        hash.put(8, new int[]{1, 3});
        hash.put(9, new int[]{4, 2});
      
        for (int i =0; i <= n; i++){
            Arrays.fill(dp[i], -1);
        }
        for (int i = 0; i <= 9; i++){
            ans += fun(n - 1, i);
            ans = ans % MOD;
        }
        ans= ans% MOD;
        return ans;
        
        
    }
    public int fun(int n, int currpos){
        if (n == 0) return 1;
        if (n == 1) {
            return hash.get(currpos).length; 
        }
        if (dp[n][currpos] != -1) return dp[n][currpos];
        int[] list = hash.get(currpos);
        int ans= 0; 
        for (int k: list){
            ans += fun(n - 1, k);
            ans = ans % MOD;
        }
        ans = ans % MOD;
        dp[n][currpos] = ans;
        return ans;
    }
}