class Solution {
    public int maximumScore(int[] nums, int k) {
        Stack<Integer> stack  = new Stack<>(); 
        int n = nums.length;
        int[] nse = new int[n];
        int[] pse = new int[n];
        
        for (int i = 0; i < n; i++){
            if (stack.isEmpty()){
                stack.push(i);
            }
            else {
                while (!stack.isEmpty() && nums[stack.peek()] > nums[i]){
                    nse[stack.pop()] = i; 
                }
                stack.push(i);
            }
        }
        while (!stack.isEmpty()) nse[stack.pop()] = n;
        
        for (int i = n - 1; i >= 0; i--){
            if (stack.isEmpty()){
                stack.push(i);
            }
            else {
                while (!stack.isEmpty() && nums[stack.peek()] > nums[i]){
                    pse[stack.pop()] = i; 
                }
                stack.push(i);
            }
        }
        while (!stack.isEmpty()) pse[stack.pop()] = -1;
        
        int max =0; 
        for (int i = 0; i < n; i++){
            if (nse[i] > k && pse[i] < k){
                max = Math.max(max, nums[i]*(nse[i] - pse[i] - 1));
            }
        }
        return max;
    }
}