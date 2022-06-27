class Solution {
    public int minInsertions(String s) {
        Stack<Character> stack = new Stack<>(); 
        char[] arr = s.toCharArray();
        int ans = 0; 
        int i = 0; 
        while (i < arr.length){
            if (arr[i] == '('){
                stack.push('(');
                i += 1; 
            }
            else {
                if (i < arr.length - 1 && arr[i + 1] == ')'){
                    if (stack.isEmpty()) ans += 1; 
                    else stack.pop(); 
                    i += 2; 
                }
                else {
                    if (stack.isEmpty()) ans += 2; 
                     else
                     {stack.pop(); ans += 1;}
                    i += 1; 
                }
            }
        }
        while (!stack.isEmpty()){
            ans += 2; 
            stack.pop(); 
        }
        return ans; 
    }
}