class Solution {
    ArrayList<Integer>[] adj;
    List<List<Integer>> res ;
    boolean[] visited;
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
         adj = new ArrayList[n ];
        for (int i = 0; i < n; i++ ) adj[i] = new ArrayList<Integer>(); 
        int len = edges.length;
        for (int i = 0; i < len; i++){adj[edges[i][1]].add(edges[i][0]);}
       res = new ArrayList<>();
        for (int i = 0; i < n; i++) res.add(new ArrayList<Integer>());
        visited = new boolean[n ];
        for (int i = 0; i < n; i++){
            if (!visited[i]) dfs(i);
        }
        
        return res;        
    }
    public void dfs(int i){
        visited[i] = true; 
        for (int k: adj[i]){
            if (!visited[k]){
                dfs(k);
            }
            for (int j: res.get(k)){
                res.get(i).add(j);
            }
            res.get(i).add(k);
        }
         res.set(i, res.get(i).stream().distinct().collect(Collectors.toList()));
        Collections.sort(res.get(i));
    }
}