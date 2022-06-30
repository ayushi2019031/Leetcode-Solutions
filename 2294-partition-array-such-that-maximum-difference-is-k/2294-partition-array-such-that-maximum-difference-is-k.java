class Solution {
    public int partitionArray(int[] nums, int k) {
       Arrays.sort(nums);
        int n = nums.length; int ans = 0; 
        int i = 0; int j = 0; 
        while (i < n){
            j = i; 
            while (j < n && nums[j] - nums[i] <= k){j++;}
            ans += 1; 
            i = j; 
            
        }
        return ans; 
    }
}