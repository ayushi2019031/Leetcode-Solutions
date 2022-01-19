class Solution {
    public int firstMissingPositive(int[] nums) {
        for(int i=0; i<nums.length; i++){
            if(nums[i] <= 0) nums[i] = Integer.MAX_VALUE;
        }
        
        for(int num: nums){
            num = Math.abs(num);
            if(num>0 && num<=nums.length){
                nums[num-1] = nums[num-1] > 0 ? -nums[num-1] : nums[num-1];
            }
        }
        
        for(int i=0; i<nums.length; i++){
            if(nums[i]>0) return i+1;
        }
        return nums.length+1;
    }
}