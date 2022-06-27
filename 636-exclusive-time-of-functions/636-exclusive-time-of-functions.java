class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<int[]> stack = new Stack<>();
        int[] ans = new int[n]; 
        for (String string: logs){
            String[] arr = string.split(":", string.length());
            Integer id = Integer.parseInt(arr[0]);
            String status = arr[1];
            Integer time = Integer.parseInt(arr[2]);
            
            if (stack.isEmpty()){
                stack.push(new int[]{id, time});
            }
            else {
                if (status.equals("start")){
                    ans[stack.peek()[0]] += time - stack.peek()[1];
                    stack.push(new int[]{id, time});
                }
                else {
                    ans[id] += time - stack.pop()[1] + 1;  
                    
                    if (!stack.isEmpty()){
                        stack.peek()[1] = time + 1; 
                    }
                }
                
            }
            
        }
        return ans; 
    }
}