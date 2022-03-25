class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        if (n == 1){
            List<Integer> list = new ArrayList<>(); 
            list.add(nums[0]); return list; 
        }
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        Arrays.sort(nums);
        int maxlen = 1; 
        for (int i = 1; i < n; i++){
            for (int j = 0; j < i; j++){
                if (nums[i] % nums[j] == 0){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    maxlen = Math.max(maxlen, dp[i]);
                }
            }
        }
        
        List<Integer> list = new ArrayList<>(); 
        int prev = -1; 
        for (int i = dp.length - 1; i >=0; i--){
            if (dp[i] == maxlen && (prev== -1 || prev % nums[i] == 0)){
                maxlen -= 1; 
                prev = nums[i];
                list.add(nums[i]);
            }
        }
        return list; 
    }
}