class Solution {
    public int find(int[] par, int i){
        if (par[i] == i) return i; 
        return find(par, par[i]);
    }
    public void union(int[] par, int[] size, int i, int j){
        int a = find(par, i);
        int b = find(par, j);
        
        if (a == b) return;
        
        if (size[a] < size[b]){
            par[b] = a;
            size[a] += size[b];
            size[b] = 0;
        }
        else {
            par[a] = b;
            size[b] += size[a];
            size[a] = 0; 
        }
    }
    public int removeStones(int[][] stones) {
        int n = stones.length;
        int[] par = new int[stones.length];
        int[] size = new int[stones.length];
        for (int i = 0; i < n; i++) {par[i] = i; size[i] = 1; } 
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1])
                union(par, size, i, j);
            }
        }
        HashSet<Integer> set = new HashSet<>(); 
        for (int i = 0; i < n; i++){
            set.add(find(par, i));
        }
        int ans = 0; 
        for (int k: set){
            
            System.out.println(k);
            if (size[k] > 1)
            ans += size[k] - 1; 
        }
        return ans;
    }
}