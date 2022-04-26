class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>(); 
        int n = nums.length;
        int[] aj = new int[n]; Arrays.fill(aj, -1); 
        for (int i = 0; i < n; i++){
            if (stack.isEmpty()){
                stack.push(i);
            }
            else {
                while (!stack.isEmpty()&& nums[stack.peek()] < nums[i]){
                    aj[stack.pop()] = i; 
                }
                stack.push(i); 
            }
        }
        
        for (int i = 0; i < n; i++){
            
            if (stack.isEmpty()){
                stack.push(i);
            }
            else {
                while (!stack.isEmpty()&& nums[stack.peek()] < nums[i]){
                    aj[stack.pop()] = i; 
                }
                stack.push(i); 
            }
        }
        for (int i = 0; i < n; i++){
            if (aj[i] != -1){
                aj[i] = nums[aj[i]];
            }
        }
        
        return aj; 
    }
}