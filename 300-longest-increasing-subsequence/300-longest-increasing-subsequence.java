class Solution {
    public int lengthOfLIS(int[] nums) {
        
        int len = 1;
        int[] dp = new int[nums.length];  
        dp[0] = nums[0];
        for(int i = 1; i<nums.length; i++)
        {
            if(nums[i]>dp[len-1])
            {
                dp[len++] = nums[i];
            }
            else
            {
                int index = binarySearch(dp, 0, len-1, nums[i]);      
                dp[index] = nums[i];  
            }
        }
        return len;          
    }
    
    public int binarySearch(int[] arr, int start, int end, int target)
    {      
        int index = Arrays.binarySearch(arr, start, end, target);   
        if(index<0)
        {
            index = -(index+1);
        }  
        return index;       
    }  
}





