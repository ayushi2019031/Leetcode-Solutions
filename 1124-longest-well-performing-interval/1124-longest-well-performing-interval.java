class Solution {
    public int longestWPI(int[] hours) {
        int n = hours.length; 
       int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            if (hours[i] > 8)
            arr[i] = 1;
            else arr[i] = -1; 
        }
        int[] pre = new int[n]; 
        pre[0] = arr[0]; 
        for (int i = 1; i < n; i++){
            pre[i] = pre[i - 1] + arr[i]; 
        }
        int ans = 0;
        for (int i = 0; i < n; i++){
            for (int j = 1; j <= i; j++){
                if (pre[i] - pre[j - 1] > 0){
                    ans = Math.max(ans, i - j + 1); 
                }
            }
        }
        for (int i = 0; i < n; i++){
            if (pre[i] > 0) ans = Math.max(ans, i + 1); 
        }
        return ans; 
    }
}