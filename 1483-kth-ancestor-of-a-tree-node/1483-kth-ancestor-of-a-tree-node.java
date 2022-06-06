class TreeAncestor {
    int[][] dp; 
    int n; 
    public TreeAncestor(int n, int[] parent) {
        this.n = n; 
        this.dp = new int[n][20];
        for (int i = 0; i < n; i++){ 
            dp[i][0] = parent[i];
        }       
        
        for (int i = 0; i < n; i++){
            for (int j = 1; j < 20; j++){
                int kk = dp[i][j - 1];
                if (kk != -1)
                dp[i][j] = dp[dp[i][j - 1]][j - 1];
                else dp[i][j] = -1; 
            }
        }
    }
    
    public int getKthAncestor(int node, int k) {
        
        for(int i=19;i>=0;i--){
            if(node==-1)break;
            if((k&(1<<i))!=0){
                node=dp[node][i];
            }
        }
        return node;
        
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */