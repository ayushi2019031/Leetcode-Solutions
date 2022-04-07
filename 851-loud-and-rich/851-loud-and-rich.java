class Solution {
    Integer[] ans;
    ArrayList<Integer>[] adj;
    int[] quiet;
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        ans = new Integer[n];
        this.quiet = quiet;
        adj = new ArrayList[n];
        quiet = new int[n];
        for (int i = 0; i < n; i++){adj[i] = new ArrayList<>(); }
        
        for (int[] edge: richer){
            adj[edge[1]].add(edge[0]);
        }
        
        for (int i = 0; i < n; i++){
            if (ans[i] == null){
                dfs(i);
                System.out.println(i);
            }
        }
        int[] ans_ = new int[n];
        for (int i = 0; i < n; i++){
            ans_[i] = ans[i];
            
        }
        return ans_;
    }
    public int dfs(int i){
        ans[i] = i;
        for (int num: adj[i]){
            if (ans[num] == null){
                int indi = dfs(num);
                if (quiet[ans[indi]] < quiet[ans[i]]){
                    ans[i] = indi;
                }
            }
            else {
                if (quiet[ans[num]] < quiet[ans[i]]){
                    System.out.println("YAYYYYYYYY" + num);
                    ans[i] = ans[num];
                }
            }
        }
        return ans[i];
    }
}