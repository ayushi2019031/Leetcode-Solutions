class Solution {
    public boolean isValid(int i, int j, int h, int v, int n, int m){
        boolean f = true;
        if (i + h < 0) return false;
        if (j + v < 0) return false;
        if (i + h >= n) return false;
        if (j + v >= m) return false;
        return true;
    }
    public void gameOfLife(int[][] board) {
        int n = board.length; int m = board[0].length;
        
        int[][] dp = new int[n][m];
        
        int[] hori = new int[]{0, 0, 1, -1, 1, 1, -1, -1};
        int[] verti = new int[]{1, -1, 0, 0, -1, 1, -1, 1 };
        
        for (int i = 0; i <n; i++){
            for (int j = 0; j < m; j++){
                int neigh = 0; 
                for (int k = 0; k < 8; k++){
                    
                    if (isValid(i, j, hori[k], verti[k], n, m)){
                        neigh += board[i + hori[k]][j + verti[k]];
                    }
                    
                }
                dp[i][j] = neigh; 
            }
        }
        
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (board[i][j] == 1){
                    if (dp[i][j] < 2 || dp[i][j] > 3){board[i][j] = 0; }
                }
                if (board[i][j] == 0){
                    if (dp[i][j] == 3){board[i][j] = 1; }
                }
                
            }
        }
    }
}