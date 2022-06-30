class Solution {
    public int minMoves2(int[] nums) {
     Arrays.sort(nums);
        int len = nums.length; 
        int index = len/2;
        int number = nums[index];
        int ans =0; 
        for (int i=0; i < len; i++){
            ans += Math.abs(number - nums[i]);
        }
        return ans; 
    }
}