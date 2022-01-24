class Solution {
    public boolean canFinish(int numCourses, int[][] prereqs) {
        int n = numCourses;
        ArrayList<Integer>[] adj = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++){
            adj[i] = new ArrayList<Integer>();
        }
        
        for (int i = 0; i < prereqs.length;i++){
            adj[prereqs[i][1]].add(prereqs[i][0]);
        }
        int[] color = new int[n + 1]; 
        
        for (int i = 0; i <= n; i++)
        {if (dfs(adj,   color, i)) return !true;}
        return true; 
    }
    public boolean dfs(ArrayList<Integer>[] adj, int[] color,  int s){
        color[s] = 1; 
        for (int k: adj[s]){
            if (color[k] == 0){
                boolean kk = dfs(adj,  color, k);
                if (kk) return kk;
            }
            else if (color[k] == 1){
                return true;
            }
            
        }
        color[s] = 2; 
        return false;
    }
    
}