class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) return false;
        int first = Integer.MAX_VALUE; 
        int second = Integer.MAX_VALUE; 
        int n = nums.length; 
        for (int i = 0; i < n; i++){
            if (nums[i] <= first) {first = nums[i];}
            else if (nums[i] <= second) {
                second = nums[i]; 
            }
            else if (nums[i] > second && second > first){
                return true;
            }
            
        }
        return false;
    }
}