class Solution {
    int[][] graph;
    boolean[] vis; 
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        this.graph = graph; 
        int n = graph.length;
        this.vis = new boolean[n];
        List<List<Integer>> list = new ArrayList<List<Integer>>(); 
        fun(list, new ArrayList<Integer>(), 0, 0, n - 1);
        return list; 
    }
    public void fun(List<List<Integer>> list, ArrayList<Integer> curr, int pos, int s, int e){
        if (pos == e){
            curr.add(e);
            list.add(curr); 
            return; 
        }
        for (int k : graph[pos]){
            if (!vis[k]){
                curr.add(pos);
                fun(list, new ArrayList<Integer>(curr), k, s, e);
                curr.remove(curr.size() - 1);
            }
        }
        
    }
}