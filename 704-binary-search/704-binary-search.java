class Solution {
    public int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length - 1);
    }
    public int search(int[] nums, int target, int s, int e){
        if (s > e) return -1; 
        if (s == e){
            if (nums[s] == target) return s; 
            return -1; 
        }
        int mid = s + (e - s)/2;
        if (nums[mid] == target) return mid;
        if (nums[mid] < target) return search(nums, target, mid + 1, e);
        if (nums[mid] > target) return search(nums, target, s, mid - 1);
        return -1;
    }
}