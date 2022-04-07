class Solution {
    Integer[]  color; 
    ArrayList<Integer>[] adj;
    public boolean isBipartite(int[][] graph) {
        int n = graph.length; 
        adj = new ArrayList[n + 1];
        for (int i = 0; i < adj.length; i++){adj[i] = new ArrayList<>();}
        for (int i = 0; i < n; i++){
            for (int j = 0; j < graph[i].length; j++){
                adj[i].add(graph[i][j]);
                adj[graph[i][j]].add(i);
            }
        }
        
        color = new Integer[n];
        boolean flag = true;
        for (int i = 0; i < n; i++){
            if (color[i] == null){
                color[i] = 0; 
                flag = flag && dfs(i);
            }
        }
        // System.out.println(Arrays.toString(color));
        return flag;
    }
    public boolean dfs(int i){
        
        boolean f = true;
        for (int k: adj[i]){
            // System.out.println(k);
            if (color[k] != null){
                if (color[k] == color[i]){
                    return false;
                }
            }
            else {
                color[k] = 1 - color[i];
                System.out.println(color[k]);
                f = f && dfs(k);
            }
        }
        return f; 
    }
}