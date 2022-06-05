class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int[][] df = new int[m][n];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                df[i][j] = Integer.MAX_VALUE;
            }
        }
        df[0][0] = 0; 
        PriorityQueue<int[]> pq =  new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2){
                return o1[2] - o2[2];
            }
        });
        
        pq.add(new int[]{0, 0, 0});
        int[] hori = new int[]{0, 0, -1, 1};
        int[] verti = new int[]{-1, 1, 0, 0};
        while (!pq.isEmpty()){
            int[] k = pq.poll(); 
            int x = k[0];
            int y = k[1];
            int eff = k[2];
            if (eff > df[x][y]) continue;
            for (int i = 0; i < 4; i++){
                int a1 = x + hori[i];
                int a2 = y + verti[i];
                
                if (!(a1 <0 || a1 >= m || a2 < 0 || a2 >= n)){
                    int up = df[a1][a2];
                    up = Math.max(df[x][y], Math.abs(heights[a1][a2] - heights[x][y]));
                    if (up < df[a1][a2]){       
                        df[a1][a2] = up;
                        pq.add(new int[]{a1, a2, up});
                    }
                }
            }
            
        }
        return df[m - 1][n - 1];
    }
}