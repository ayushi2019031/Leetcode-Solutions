class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length; 
        if (n <= 2) return 0; 
        int[] ans = new int[n];
        ans[n - 1] = 0; 
        ans[n - 2] = 0;
        for (int i = n - 3; i >= 0; i--){
            if (nums[i + 2] - nums[i + 1] == nums[i + 1] - nums[i]){
                ans[i] = ans[i + 1] + 1; 
            }
        }
        int fin = 0; 
        for (int i = 0; i < n; i++) fin += ans[i];
        return fin; 
    }
}