class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        long[][] dp = new long[n][n]; 
        for (int i = 0; i < n; i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE); 
        }
        for (int i = 0; i < n; i++){
            dp[i][i] = 0; 
        }
        for (int i = 0; i < edges.length; i++){
            dp[edges[i][0]][edges[i][1]] = dp[edges[i][1]][edges[i][0]] =  edges[i][2]; 
        }
        
        for (int k = 0; k < n; k++){
            for (int i = 0; i < n; i++){
                for (int j = 0; j < n; j++){
                    if (dp[i][k] + dp[k][j] < dp[i][j]){
                        dp[i][j] = dp[i][k] + dp[k][j]; 
                    }
                }
            }
        }
        for (int i = 0; i < n; i++){
            System.out.println(Arrays.toString(dp[i]));
        }
        int ans = Integer.MAX_VALUE;
        int index = -1; 
        
        for (int i = 0; i < n;i++){
            int mm = 0; 
            for (int j = 0; j < n; j++){
                if (dp[i][j] <= distanceThreshold){mm += 1; }
            }
            if (mm <= ans){
                index = i; ans = mm; 
            }
        }
        return index; 
    }
}