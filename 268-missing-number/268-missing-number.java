class Solution {
    public int missingNumber(int[] nums) {
        int xor1 = 0; 
        for (int i = 1; i <= nums.length; i++){
            xor1 = xor1^i;
        }
        int xor2 = nums[0];
        for (int i = 1; i < nums.length; i++){
            xor2 = xor2 ^ nums[i];
        }
        return xor1 ^xor2;
    }
}