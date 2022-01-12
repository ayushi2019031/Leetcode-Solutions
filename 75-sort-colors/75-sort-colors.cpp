class Solution {
public:
    void sortColors(vector<int>& nums) {
        int lo = 0; int mid = 0; int hi = nums.size() - 1; 
        
        while (mid <= hi ){
        
            if (nums[mid] == 0){
                int k= nums[lo];
                nums[lo] = nums[mid]; 
                nums[mid] = k; 
                lo += 1; mid += 1; 
            }
            else if (nums[mid] == 2){
                nums[mid] = nums[hi]; 
                nums[hi] = 2; 
                
                hi -= 1; 
            }
            else {
                mid += 1; 
            }
        }
    }
};