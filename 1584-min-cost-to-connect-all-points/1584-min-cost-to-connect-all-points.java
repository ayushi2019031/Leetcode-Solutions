class Solution {
    ArrayList<int[]>[] adj; 
    int n; 
    int[][] points; 
    public int minCostConnectPoints(int[][] points) {
        this.n = points.length;
        adj = new ArrayList[n]; 
        this.points = points; 
        for (int i = 0; i < n; i++){adj[i] = new ArrayList<int[]>(); }
        
        return minimum_spanning_tree();
         
    }
    public int weight(int i, int next){
        return manhattan(points[i], points[next]); 
    }
    public int minimum_spanning_tree(){
        HashSet<Integer> mst = new HashSet<>();
        Integer[] dist = new Integer[n];
        dist[0] = 0;  
        for (int i = 1; i < n; i++){dist[i] = weight(0, i);}
        System.out.println(Arrays.toString(dist)); 
        int ans = 0; 
        while (mst.size() < n){ 
            int next = -1; 
            for (int i = 0; i < n; i++){
                if (!mst.contains(i)){
                    if (next == -1 || dist[i] < dist[next]){next = i; }
                }
            }
            mst.add(next); 
            ans += dist[next]; 
            for (int i = 0; i < n; i++){
                if (!mst.contains(i)){
                    dist[i] = Math.min(dist[i], weight(i, next)); 
                }
            }
            
        }
        return ans; 
        
    }
    public int manhattan(int[] a1, int[] a2){
        return Math.abs(a1[0] - a2[0]) + Math.abs(a1[1] - a2[1]);
    }
}