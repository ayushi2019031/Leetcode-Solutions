class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length ; 
        int interchange = -1;
        for (int i = n - 1; i >= 1; i--){
            if (nums[i] > nums[i - 1]){
                interchange = i; break;
            }
        }
        if (interchange == -1){
            Arrays.sort(nums); return;
        }
        int min = Integer.MAX_VALUE;
        int nid = interchange;
        for (int i = interchange; i < n; i++){
            if (nums[i] < min && nums[i] > nums[interchange - 1]){min = nums[i]; nid = i; }
        }
        swap(nums, interchange - 1, nid);
        Arrays.sort(nums, interchange, nums.length);
    }
    public void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b]; nums[b] = temp;
    }
}