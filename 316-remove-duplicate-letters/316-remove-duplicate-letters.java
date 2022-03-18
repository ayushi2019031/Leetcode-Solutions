class Solution {
    public String removeDuplicateLetters(String s) {
        char[] arr = s.toCharArray(); 
        Stack<Integer> stack = new Stack<>(); 
        int[] ref = new int[26];
        int n = arr.length;
        for (int i = 0; i < n; i++){ref[arr[i] - 'a'] += 1;}
        boolean[] vis = new boolean[26];
      
        for (int i = 0 ; i < n; i++){
            if (vis[arr[i] - 'a']) {ref[arr[i] - 'a'] -= 1; continue;}
            if (stack.isEmpty()){
                stack.push(i);
                vis[arr[i] - 'a'] = true;
                // ref[arr[i] - 'a'] -= 1;
            }
            else {
                
                while (!stack.isEmpty() && arr[stack.peek()] > arr[i]){
                    
                    if (ref[arr[stack.peek()] - 'a'] > 0){
                       vis[ arr[stack.pop()] - 'a'] = false; 
                    }
                    else {
                        break;
                    }
                    
                }
                stack.push(i);
                // ref[arr[i] - 'a'] -= 1;
                vis[arr[i] - 'a'] = true;
                
            }
            ref[arr[i] - 'a'] -= 1;
        }
        StringBuilder aa = new StringBuilder(); 
        String ans = "";
        while (!stack.isEmpty()){ans += arr[stack.pop()];}
        aa.append(ans);
        aa.reverse();
        return aa.toString();
    }
}