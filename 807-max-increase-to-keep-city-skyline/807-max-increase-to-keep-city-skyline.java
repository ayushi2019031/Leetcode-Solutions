class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int n = grid.length; 
        int[] maxinrows = new int[n];
        int[] maxincols = new int[n];
        
        for (int i = 0; i < n; i++){
            int maxi = -1; 
            for (int j =0; j < n; j++){
                maxi = Math.max(maxi, grid[i][j]);
            }
            maxinrows[i] = maxi;
        }
        for (int i = 0; i < n; i++){
            int maxi = -1; 
            for (int j =0; j < n; j++){
                maxi = Math.max(maxi, grid[j][i]);
            }
            maxincols[i] = maxi;
        }
        
        int ans  = 0; 
        
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                int t = Math.min(maxinrows[i], maxincols[j]);
                ans += Math.abs(grid[i][j] - t);
            }
        }
        return ans; 
    }
}