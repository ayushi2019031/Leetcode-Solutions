class Solution {
    public int singleNumber(int[] nums) {
        int[] bitarray = new int[32];
        int n = nums.length;
        
        for (int i = 0; i < n; i++){
            int k = nums[i];
            int x  = 0;
            while (x < 32){
                bitarray[x] += (k >> x & 1);
                x += 1;
                }
        }
        int ans = 0; 
        for (int i = 0; i < 32; i++){
            if (bitarray[i] % 3 != 0){
                ans += (1 << i);
            }
        }
        return ans;
        
    }
}