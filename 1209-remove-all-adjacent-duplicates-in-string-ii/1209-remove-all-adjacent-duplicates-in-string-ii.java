class Solution {
    public String removeDuplicates(String s, int k) {
        char[] string_ = s.toCharArray(); 
        int n = string_.length;
        Stack<String> stack = new Stack<>(); 
        
        for (int i = 0; i < n; i++){
            char c = string_[i];
            
            if (stack.isEmpty()){stack.push(Character.toString(c));}
            else {
                if (stack.peek().charAt(0) == c){
                    String aj = stack.pop(); 
                    String bj = aj + c; 
                    if (bj.length() < k){
                        stack.push(bj);
                    }
                }
                else {
                    stack.push(Character.toString(c));
                }
            }
        }
        StringBuilder strb = new StringBuilder(); 
        while (!stack.isEmpty()){strb.append(stack.pop());}
        return strb.reverse().toString(); 
    }
}