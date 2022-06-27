class Solution {
    public int maxSumMinProduct(int[] nums) {
        int n = nums.length;
        int[] prevSmallerOrEqual = new int[n];
        int[] nextSmaller = new int[n];
        Arrays.fill(prevSmallerOrEqual , -1);
        Arrays.fill(nextSmaller , n);
        
        long[] prefix = new long[n];
        prefix[0] = nums[0];
        for(int i = 1; i < n; i++){
            prefix[i] = nums[i] + prefix[i-1];
        }
        
        Deque<Integer> stack = new ArrayDeque<>();
        
        for(int i = 0; i < n; i++){
            while(!stack.isEmpty() && nums[stack.peekLast()] > nums[i]){
                nextSmaller[stack.peekLast()] = i;
                stack.pollLast();
            }
            stack.addLast(i);
        }
        
        while(!stack.isEmpty()) stack.pollLast();
        
        for(int i = n-1; i >= 0; i--){
            while(!stack.isEmpty() && nums[stack.peekLast()] >= nums[i]){
                prevSmallerOrEqual[stack.peekLast()] = i;
                stack.pollLast();
            }
            stack.addLast(i);
        }
        
        System.out.println(Arrays.toString(prefix));
        System.out.println(Arrays.toString(prevSmallerOrEqual));
        System.out.println(Arrays.toString(nextSmaller));
        
        int MOD = (int)1e9 + 7;
        long res = 0;
        
        for(int i = 0; i < n; i++){
            
            long a = prevSmallerOrEqual[i] == -1 ? 0: prefix[prevSmallerOrEqual[i]];
            long b = prefix[nextSmaller[i] - 1];
            
            long cur_Sum = b-a;
            res = Math.max(res, (cur_Sum * (long)nums[i] ));
        }
        
        
        return (int)(res % MOD);
        
    }
}