class Solution {
    ArrayList<Integer>[] adj;
    public int maximalNetworkRank(int n, int[][] roads) {
        adj = new ArrayList[n];
        for (int i = 0; i < n; i++){adj[i] = new ArrayList<>(); }
        
        for (int i = 0; i < roads.length; i++){
            adj[roads[i][0]].add(roads[i][1]);
            adj[roads[i][1]].add(roads[i][0]);
        }
        int max = 0; 
        HashSet<String> set = new HashSet<>(); 
        for (int i = 0; i < roads.length; i++){
            int a = adj[roads[i][0]].size() +adj[roads[i][1]].size() - 1; 
            max = Math.max(max, a);
            String a1 = Integer.toString(roads[i][0]) + "_" + Integer.toString(roads[i][1]);
            String a2 = Integer.toString(roads[i][1]) + "_" + Integer.toString(roads[i][0]);
            set.add(a1); set.add(a2);
        }
        for (int i = 0; i < n; i++){
            for (int j = 0; j < i; j++){
                String a = i + "_" + j;
                if (!set.contains(a)){
                    max = Math.max(adj[i].size() + adj[j].size(), max);
                }
            }
        }
        return max; 
    }
}