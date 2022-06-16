class Solution {
     HashMap<Integer, int[]> hash = new HashMap<>();
    int[] subtree_size; 
    public int countHighestScoreNodes(int[] parents) {
         int n = parents.length;
        for (int i = 0; i <= n; i++){
            hash.put(i, new int[]{-1, -1});
        }
        subtree_size = new int[n]; 
        for (int i = 0; i < n; i++){
            if (!hash.containsKey(parents[i])){hash.put(parents[i], new int[]{-1, -1});}
            int[] arr = hash.get(parents[i]);
            if (arr[0] == -1){arr[0] = i;}
            else {arr[1] = i; }
        }
        long[] ans = new long[n]; 
        dfs(0);
        long total_size = subtree_size[0];
        for (int i = 0; i < n; i++){
            long k = 1; 
            if (hash.get(i)[0] != -1)
             k =  Math.max(subtree_size[hash.get(i)[0]], 1);
            if (hash.get(i)[1] != -1)
            k = k*Math.max(subtree_size[hash.get(i)[1]], 1);
            
            k = k*Math.max(total_size - subtree_size[i] , 1);
            if (parents[i] == -1 && hash.get(i)[0] == -1 && hash.get(i)[1] == -1){
                k = 0; 
            }
            ans[i] = k; 
        }
        System.out.println(Arrays.toString(ans));
        Arrays.sort(ans);
        int sii = 0; 
        
        int i = 0; int j = 0; 
        while ( i < n){
            j = i; 
            while (j < n && ans[j] == ans[i]){j += 1; }
            sii = j - i; 
            i = j; 
        }
        return sii; 
    }
    public int dfs(int s){
        if (s < 0) return 0; 
        System.out.println(s);
        int size = 1 + dfs(hash.get(s)[0]) +dfs(hash.get(s)[1]);
        subtree_size[s] = size; 
        return subtree_size[s];
    }
}