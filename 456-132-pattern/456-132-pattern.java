class Solution {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        int[] ele1 = new int[n];
        ele1[0] = nums[0];
        for (int i = 1; i < n; i++){
            ele1[i] = Math.min(ele1[i - 1], nums[i]);
        }
        
        int[] ele2 = new int[n];
        ele2[n-  1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--){
            ele2[i] = Math.min(ele2[i + 1], nums[i]);
        }
        int[] pge = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1;  i >= 0; i--){
            if (stack.isEmpty()){
                stack.push(i);
            }
            else {
                while (!stack.isEmpty() && nums[stack.peek()] < nums[i]){
                    pge[stack.peek()] = i;
                    stack.pop();
                }
                stack.push(i);
            }
        }
        while (!stack.isEmpty()){pge[stack.pop()] = -1;}
        
        for (int i = n - 1; i >= 0; i--){
            int r = pge[i];
            if (r == -1 || r == 0){continue;}
            int t3 = nums[r];
            int t2 = nums[i];
            int t1 = ele1[r - 1];
            if (t1 < t3 && t1 < t2) return true;
        }
        return false;
    }
}