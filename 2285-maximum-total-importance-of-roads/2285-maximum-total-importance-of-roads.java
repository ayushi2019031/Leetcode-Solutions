class Solution {
    public long maximumImportance(int n, int[][] roads) {
        long[] ref = new long[n];
        for (int[] road: roads){
            ref[road[0]] += 1;
            ref[road[1]] += 1;
        }
        
        Arrays.sort(ref);
        long ans = 0; 
        for (int i = 0; i < n; i++){
            ans += ref[i]*(i + 1);
        }
        return ans;
    }
}