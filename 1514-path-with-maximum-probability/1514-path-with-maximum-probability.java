class Solution {
    ArrayList<double[]>[] adj;
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end)     {
        adj = new ArrayList[n];
        for (int i = 0; i < n; i++){adj[i] = new ArrayList<double[]>();}
        for (int i = 0; i < edges.length; i++){
            int[] k = edges[i];
            adj[k[0]].add(new double[]{k[1], succProb[i]});
            adj[k[1]].add(new double[]{k[0], succProb[i]});
        }
        
        Queue<double[]> q = new PriorityQueue<>((a, b) -> Double.compare(a[1], b[1])); 
        double[] dist = new double[n];
        Arrays.fill(dist, Double.MAX_VALUE);
        dist[start] = 1.0; 
        
        double esp = 1e-5;
        q.add(new double[]{start, dist[start]});
        while (!q.isEmpty()){
            double[] k = q.poll(); 
            int u = (int)k[0]; double d = k[1];
            
            if (Math.abs(dist[u] - d) > esp) continue;
            for (double[] next: adj[u]){
                int v = (int) next[0]; 
                double w = next[1];
                
                if (dist[u]/w < dist[v]){
                    dist[v] = dist[u]/w;
                    q.add(new double[]{v, dist[v]});
                }
            }
        }
        return 1.0/dist[end];
    }
    
}