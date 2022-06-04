class Solution {
    public int findIndex(int[] dp, int k){
        return bin(dp, k, 0, dp.length -1);
    }
    public int bin(int[] dp, int k, int s, int e){
        if (e < s) return -1; 
        int mid = (e + s)/2;
        
        if (dp[mid] < k){
            int r = bin(dp, k, mid + 1, e);
            if (r == -1) return mid;
            return r;
        }
        else {
            return bin(dp, k, s, mid - 1);
        }
    }
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        Arrays.sort(envelopes, new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2){
                int a1 = o1[0] - o2[0]; 
                if (a1 == 0) return -(o1[1] - o2[1]);
                return a1; 
            }
        });
        
        ArrayList<Integer> list = new ArrayList<>();
        int curr = envelopes[0][0]; list.add(envelopes[0][1]);
        
        for (int i = 1; i < n; i++){
                curr = envelopes[i][0]; 
                list.add(envelopes[i][1]);}
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n;i++){
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = -1;
        int len = list.size(); 
        System.out.println(list); 
        for (int i = 0; i < len; i++){
            
                int index = findIndex(dp, list.get(i));
                if (index != -1) dp[index + 1] = list.get(i);   
            
        }
        int ans = 0;  
        System.out.println(Arrays.toString(dp));
        for (int i = 0; i <= n; i++){
            if (dp[i] != Integer.MAX_VALUE){
                ans = i;  
            }
        }

        
        return ans; 
    }
}