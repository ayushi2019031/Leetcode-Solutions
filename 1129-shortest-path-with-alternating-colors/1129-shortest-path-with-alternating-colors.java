class Solution {
    ArrayList<Integer>[] adj_red;
    ArrayList<Integer>[] adj_blue;
    
    int[][] e_red; 
    int[][] e_blue;
    int n; 
    
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        this.e_red = redEdges; 
        this.e_blue = blueEdges; 
        this.n = n; 
        this.adj_red = new ArrayList[n]; 
        this.adj_blue = new ArrayList[n]; 
        
        for (int i = 0; i < n; i++){
            adj_red[i] = new ArrayList<Integer>();
            adj_blue[i] = new ArrayList<Integer>();
        }
        for (int[] edge: e_red){
            adj_red[edge[0]].add(edge[1]); 
        }
        for (int[] edge: e_blue){
            adj_blue[edge[0]].add(edge[1]); 
        }
        int[][] dist = new int[n][2];
        for (int i = 0; i < n; i++){
        Arrays.fill(dist[i], Integer.MAX_VALUE); 
        
        }
        Queue<int[]> q = new LinkedList<>(); 
        dist[0][0] = 0;
        dist[0][1] = 0; 
        q.add(new int[]{0, 0}); 
        q.add(new int[]{0, 1});
        boolean[][] visited = new boolean[n][2]; 
        int steps = 0; 
        while (!q.isEmpty()){
            int[] k_ = q.poll(); 
        
            // System.out.println(Arrays.toString(k_)); 
            int k = k_[0]; 
            int col = k_[1]; 
            visited[k][col] = true; 
            
            if (col == 0){
                for (int num: adj_red[k]){
                    if (!visited[num][1 - col]){
                        dist[num][1 - col] = Math.min(dist[num][1 - col], dist[k][col] + 1); 
                        q.add(new int[]{num, 1 - col}); 
                    }
                }
            }
            else {
                for (int num: adj_blue[k]){
                    if (!visited[num][1 - col]){
                        dist[num][1 - col] = Math.min(dist[num][1 - col], dist[k][col] + 1); 
                        q.add(new int[]{num, 1 - col}); 
                    }
                }
            }
        }
        int[] ans = new int[n]; 
        for (int i = 0; i < n; i++){
            if (dist[i][0] == Integer.MAX_VALUE && dist[i][1] == Integer.MAX_VALUE){
                ans[i] = -1; 
            }
            else {
                ans[i] = Math.min(dist[i][0], dist[i][1]);
            }
        }
        return ans; 
    }
    
    
    
}