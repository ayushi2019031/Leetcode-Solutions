class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
         Stack<Integer> stack = new Stack<>(); 
        int i = 0; int j = 0; 
        
        for (int x: popped){
            if (i != pushed.length){
            while (stack.isEmpty() || stack.peek() != x){
                stack.push(pushed[i]);
                i += 1;
                if (i == pushed.length)break;
            }
            }
            if (stack.peek() != x) return false;
            stack.pop(); 
            
        }
        return true;
        
    }
}