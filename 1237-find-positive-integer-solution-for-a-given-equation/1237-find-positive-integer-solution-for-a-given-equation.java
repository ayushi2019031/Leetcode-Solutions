/*
 * // This is the custom function interface.
 * // You should not implement it, or speculate about its implementation
 * class CustomFunction {
 *     // Returns f(x, y) for any given positive integers x and y.
 *     // Note that f(x, y) is increasing with respect to both x and y.
 *     // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
 *     public int f(int x, int y);
 * };
 */

class Solution {
    int[][] dp = new int[1001][1001];
    CustomFunction customfunction; 
    int z; 
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        for (int i = 0; i < 1000; i++){
            for (int j = 0; j < 1000; j++){dp[i][j] = 0;}
        }
        this.customfunction = customfunction; 
        this.z = z; 
        help(0, 0); 
        List<List<Integer>> ans = new ArrayList<>(); 
        for (int i = 1; i <= 1000; i++){
            for (int j = 1; j <= 1000; j++){
               help(i, j); 
                if (dp[i][j] == 1){
                    List<Integer> list = new ArrayList<>(); 
                    list.add(i ); 
                    list.add(j); 
                    ans.add(list); 
                }
            }
        }
    
        return ans; 
    }
    public void help(int x, int y){
        if (x > 1000 || y > 1000 || x < 0 || y < 0) return ; 
        if (dp[x][y] != 0) return ;
        
        int t = customfunction.f(x, y); 
        
        if (t == z){
            dp[x][y] = 1; 
            customfunction.f(x, y+1); 
            customfunction.f(x + 1, y); 
        }
        else if ( t > z){
            dp[x][y] = -1; 
            customfunction.f(x, y - 1); 
            customfunction.f(x - 1, y); 
        }
        else if (t < z){
            dp[x][y] = -1; 
            customfunction.f(x, y+1); 
            customfunction.f(x + 1, y); 
        }
        
    }
}