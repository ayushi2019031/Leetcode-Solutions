class Solution {
    public int orangesRotting(int[][] grid) {
         Queue<int[]> queue = new LinkedList<>(); 
         int n = grid.length; int m = grid[0].length; 
        boolean[][] vis = new boolean[n][m];
        int[][] ans = new int[n][m];
        for (int i = 0; i < n; i++){
            for (int j =0; j < m; j++){
                if (grid[i][j]== 2){
                    queue.add(new int[]{i, j});
                }
            }
        }
        int time = 0; 
        if (!queue.isEmpty()){time = 0;  queue.add(new int[]{-1, -1});}
       
         int[] x = new int[]{-1, +1, 0, 0};
        int[] y = new int[]{0, 0, -1, +1};
        
        
        while (!queue.isEmpty()){
            int[] k = queue.poll(); 
            System.out.println(k[0] + " " + k[1]);
            if (k[0] == -1 && k[1] == -1){
                if (queue.size() > 0){time += 1; queue.add(new int[]{-1, -1});} 
                if (queue.size() == 0) break;
                continue;
            }
            vis[k[0]][k[1]] = true;
            for (int i = 0; i < 4; i++){
                int a1 = k[0] + x[i]; int a2 = k[1] + y[i];
                if (a1 < 0 || a2 < 0 || a1 >= n || a2 >= m){continue;}
                else {
                    if (grid[a1][a2] == 1 && !vis[a1][a2] && ans[a1][a2] == 0){
                    queue.add(new int[]{a1, a2});
                        ans[a1][a2] = 1; 
                }        
            }
        }
    }
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (grid[i][j] == 1 && !vis[i][j]) return -1; 
            }
        }
        return time; 
    }
    
}