class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        
        int[] suffix = new int[len];
        int[] prefix = new int[len];
        prefix[0]= nums[0];suffix[len - 1]= nums[len - 1];
        for (int i = 1; i < len; i++){prefix[i] = nums[i]*prefix[i - 1];}
        for (int i = len - 2; i >= 0; i--){suffix[i] = nums[i]*suffix[i + 1];}
        int[] ans = new int[len];
        ans[0] = suffix[1];
        ans[len - 1] = prefix[len - 2];
        for (int i = 1; i < len - 1; i++){
            ans[i] = suffix[i + 1]*prefix[i - 1];
        }
        return ans;
    }
}