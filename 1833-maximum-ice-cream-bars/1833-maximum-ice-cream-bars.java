class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs); 
        int len = costs.length; 
        int i = 0;
        int ans = 0; 
        while (i < len && coins >= 0){
            if (costs[i] <= coins){
                coins -= costs[i]; 
                ans += 1; 
            }
            i += 1; 
        }
        return ans; 
    }
}