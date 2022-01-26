class Solution {
    int time = 0; 
    int[] low;
    int[] tin; 
    boolean[] vis;
    ArrayList<Integer>[] adj;
    List<List<Integer>> ans; 
    public void dfs(int i, int p){
        vis[i] = true;
        tin[i] = time++; 
        low[i] = tin[i];
        for (int k: adj[i]){
            if (k == p){continue;}
             if (vis[k]){
             low[i] = Math.min(low[i], tin[k]);   
            }
            else {
                dfs(k, i);
                low[i] = Math.min(low[i], low[k]);
                if (low[k] > tin[i]){
                     List<Integer> kk = new ArrayList<>(); 
                    kk.add(i); kk.add(k); 
                    ans.add(kk); 
                }
            }
            
        }
    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
         low = new int[n];
         tin = new int[n]; 
         vis = new boolean[n];
        adj = new ArrayList[n];
        ans = new ArrayList<>(); 
        for (int i = 0; i < n; i++){
            adj[i] = new ArrayList<>(); 
        }
        for (List<Integer> k: connections){
            adj[k.get(0)].add(k.get(1));
            adj[k.get(1)].add(k.get(0));
        }
        for (int i = 0; i < n; i++){low[i] = -1;}
        for (int i = 0; i < n; i++){tin[i] = -1;}
        for (int i = 0; i < n; i++){
            if (!vis[i]){
                dfs(i, -1);
            }
        }
        return ans; 
    }
}