class Solution {
    public int minPairSum(int[] nums) {
        int n = nums.length; 
        Arrays.sort(nums);
        ArrayList<Integer> list = new ArrayList<>(); 
        
        for (int i = 0; i < (n/2); i++){
            list.add(nums[i] + nums[n - i - 1]);
        }
        Collections.sort(list);
        return list.get(list.size() - 1); 
    }
}