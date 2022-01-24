class Solution {
    public int minDistance(String word1, String word2) {
        int l1 = word1.length(); 
        int l2 = word2.length(); 
        int[][] grid = new int[l1 + 1][l2 + 1];
        for (int i = 1; i < l2 + 1; i++){
            grid[0][i] = i; 
        }
        for (int i = 1; i < l1 + 1; i++){
            grid[i][0] = i; 
        }
        for (int i = 1; i < l1 + 1; i++){
            for (int j = 1; j < l2 + 1; j++){
                char c1 = word1.charAt(i - 1);
                char c2 = word2.charAt(j - 1);
                grid[i][j] = Math.min(grid[i- 1][j - 1], Math.min(grid[i - 1][j], grid[i][j - 1])) + 1; 
                if (c1 == c2){
                    grid[i][j] = Math.min(grid[i][j], grid[i - 1][j - 1]);
                }
            }
        }
        return grid[l1][l2];
    }
}