class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int i = 0; int j = 0; 
    int count = 1; 
        boolean[][] vis = new boolean[n][n];
        
        List<Integer> list = new ArrayList<>();int m = n; 
        while (count != n*n + 1){
            while (j < n && vis[i][j] == false ){
                System.out.println(i + " " + j);
                ans[i][j] = count;
                
                vis[i][j] = true; j += 1; 
                
                count += 1;
            }
            j -= 1; 
            i += 1; 
            while (i < m && vis[i][j] == false ){
                System.out.println(i + " " + j);
                  ans[i][j] = count;
                vis[i][j] = true; i += 1; 
                count += 1;
            }
            i -= 1; j -= 1; 
            while (j >= 0 && vis[i][j] == false && j>= 0){
                System.out.println(i + " " + j);
                  ans[i][j] = count;
                vis[i][j] = true; j -= 1; 
                count += 1;
            }
            j += 1; i -= 1; 
            while (i >= 0 && vis[i][j] == false && i>= 0){
                System.out.println(i + " " + j);
                  ans[i][j] = count;
                vis[i][j] = true; i -= 1; 
                count += 1;
            }
            i+= 1; j += 1; 
           
        }
         return ans; 
    
    }
    
}