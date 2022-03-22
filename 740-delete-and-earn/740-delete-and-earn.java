class Solution {
    public int deleteAndEarn(int[] arr) {
        if (arr.length == 0){return 0;}
        Arrays.sort(arr);
        
        int[] ref = new int[10001];
        int[] dp = new int[10001];
        int i = 0; int j = 1;
        while (i < arr.length && j < arr.length){
            while (j < arr.length && arr[j] == arr[i]){
                j += 1;
            }
            ref[arr[i]] = j - i;
            i  = j ; j += 1;
        }
        if (j == arr.length && i == arr.length - 1){ref[arr[arr.length - 1]] += 1;} 
        for (int k = 0;  k < dp.length; k++){dp[k] = -1;}
        int ans = 0; 
        for (int k = 0; k <= arr[arr.length - 1]; k++){
            ans = Math.max(ans, fun(ref, dp, k));
        }
       // ans = fun(ref, dp, 0);
        return ans;
        }
    public int fun(int[] ref, int[] dp, int pos){
   //     System.out.println(Arrays.toString(ref));
        if (pos >= dp.length){return 0; }
        if (dp[pos] != -1){return dp[pos];}
        if (ref[pos] == 0){return 0;}
        int ans = 0; 
        for (int i = pos + 2; i < ref.length; i++){
            ans = Math.max(ans, fun(ref, dp, i));
        }
        ans += pos*ref[pos];
        dp[pos] = ans;
        return ans;
    }
    
}