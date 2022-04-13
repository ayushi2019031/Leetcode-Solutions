class Solution {
    HashSet<Integer> set = new HashSet<>(); 
    HashMap<Integer,Long> hash = new HashMap<>(); 
    int MOD = 1000000000 + 7;
    int[] arr;
    public int numFactoredBinaryTrees(int[] arr) {
        long ans = 0; 
        this.arr = arr;
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        for (int k: arr){
            set.add(k);
        }
        
        
        for (int i  = arr.length - 1; i >= 0; i--){
            
            ans = ((ans % MOD) + (fun(arr[i]) % MOD)) % MOD;
            
            ans = ans % MOD;
        }
        // System.out.println(hash);
        ans = ans % MOD;
        return  (int) ans; 
        
    }
    public long fun(int pos){
        if (hash.containsKey(pos)) return hash.get(pos);
        long ans = 1; 
        for (int i = 0; i < arr.length; i++){
            if (arr[i] >= pos) break;
            if (pos %  arr[i] == 0){
                int j = pos/arr[i];
                if (set.contains(arr[i]) && set.contains(j)){
                   ans +=  ( (fun(arr[i]) % MOD)*(fun(j) % MOD) ) % MOD;
                   // ans = ans % MOD; 
                    
                
                    // ans = ans % MOD; 
                }
            }
        }
        ans = ans % MOD;
        hash.put(pos, ans);
        return ans; 
    }
}