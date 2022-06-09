class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        int ans = 0; 
        for (int k: left){
            ans = Math.max(ans, k);
        }
        for (int k: right){
            ans = Math.max(ans, n - k);
        }
        return ans; 
    }
}