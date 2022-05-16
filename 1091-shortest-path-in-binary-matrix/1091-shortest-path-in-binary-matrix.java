class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length; int n = grid[0].length; 
        if (grid[m - 1][n -1] == 1 || grid[0][0] == 1) return -1; 
       
        int[][] dist = new int[m][n];
        for (int i = 0; i < m; i++){Arrays.fill(dist[i], Integer.MAX_VALUE);}
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<>(){
            public int compare(int[] o1, int[] o2){
                return Integer.compare(dist[o1[0]][o1[1]], dist[o2[0]][o2[1]]);
            }
        });
        int[] arr1 = new int[]{1, 1, -1, -1, 1, -1, 0, 0};
        int[] arr2 = new int[]{-1, 1, -1, 1, 0, 0, 1, -1};
        pq.add(new int[]{0, 0});
        dist[0][0] = 0; 
        while (!pq.isEmpty()){
            int[] op = pq.poll();
          
            for (int i = 0; i < 8; i++){
                int s1 = op[0] + arr1[i];
                int s2 = op[1] + arr2[i];
                if (s1 >= 0 && s2 >= 0 && s1 < m && s2 < n  && grid[s1][s2] == 0){
                    dist[s1][s2] = Math.min(dist[s1][s2], dist[op[0]][op[1]] + 1);
                    pq.add(new int[]{s1, s2});
                    grid[s1][s2] = 1; 
                }
            }
        }
            if (dist[m - 1][n - 1] == Integer.MAX_VALUE) return -1;
        return dist[m - 1][n - 1] + 1;
        
    }
}