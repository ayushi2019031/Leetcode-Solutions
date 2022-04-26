class Solution {
    public int maxChunksToSorted(int[] arr) {
        Stack<Integer> stack = new Stack<>(); 
        int n = arr.length; 
        
        for (int i = 0; i < n; i++){
            int largest = arr[i]; 
            while (!stack.isEmpty() && stack.peek() > arr[i]){
                largest = Math.max(largest, stack.pop()); 
            }
            stack.push(largest); 
        }
        return stack.size(); 
    }
}