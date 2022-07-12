class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        ArrayList<Integer> list = new ArrayList<>(); 
        for (int i = 0; i < nums.length; i++){
            if (list.size() == 0) list.add(nums[i]);
            else if (nums[i] != list.get(list.size() - 1)) list.add(nums[i]);
        }
        nums = new int[list.size()];
        for (int i = 0; i < nums.length;i++){
            nums[i] = list.get(i);
        }
        System.out.println(Arrays.toString(nums));
         int max = 1; 
       Integer[] arr = new Integer[nums.length];
        int n = nums.length;
        if (n == 0) return 0; 
        // if (n == 1) return 1; 
        Arrays.fill(arr, 1);
        for (int i = 1; i < n; i++){
            if (nums[i] == nums[i - 1] + 1 ){
                arr[i] = arr[i - 1] + 1; 
               
            }
            else arr[i] = 1; 
             max = Math.max(arr[i], max);
        }
        return max; 
    }
}
