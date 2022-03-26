class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int left_max_val = values[0]; 
        int n = values.length;
        int ans = 0; 
        for (int i = 1; i < n; i++){
            ans = Math.max(ans, left_max_val + values[i] - i);
            left_max_val = Math.max(left_max_val, values[i] + i);
            
        }
        return ans;
        
    }
}