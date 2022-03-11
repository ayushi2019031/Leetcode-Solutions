class Solution {
    public long minimalKSum(int[] nums, int k) {
        Arrays.sort(nums);
        // System.out.println(Arrays.toString(nums));
        long ans = 0; 
        long s = 1; long e = nums[0] - 1; 
        long counter = 0; 
        for (int i = 0; i < nums.length; i++){
            if (counter == k) break;
            e = Math.min(nums[i] - 1, s + k - counter - 1);
            
            if (e >= s) ans += ((e*(e + 1))/2) - ((s*(s - 1))/2);
           if (e >= s) counter += e - s + 1; 
            System.out.println(s + " " + e);
                s = nums[i] + 1; 
            e = s; 
            
            
        }
        if (counter < k){
            s = nums[nums.length - 1] + 1; e = s+ k - counter - 1; 
            ans += ((e*(e + 1))/2) - ((s*(s - 1))/2);
        }
        return ans;
    }
}