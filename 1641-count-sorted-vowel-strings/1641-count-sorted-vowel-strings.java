class Solution {
    public int countVowelStrings(int n) {
        int[] t = fun(n); 
        int a = t[0] + t[1] + t[2] + t[3] + t[4]; 
        return a; 
    }
    public int[] fun(int n){
        if (n == 1){
            return new int[]{1, 1, 1, 1, 1}; 
        }
        int[] k = fun(n - 1); 
        int[] ans = new int[5]; 
        ans[0] = k[0] + k[1] + k[2] + k[3] + k[4];
        ans[1] = k[1] + k[2] + k[3] + k[4];
        ans[2] = k[2] + k[3] + k[4];
        ans[3] = k[3] + k[4];
        ans[4] = k[4];
        return ans; 
    }
}