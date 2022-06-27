class Solution {
    public boolean isValid(String s) {
        Stack<String> stack = new Stack<>(); 
        for (char c: s.toCharArray()){
            if (c == 'a'){
                stack.push("a");
            }
            else if (c == 'b'){
                if (stack.isEmpty() || !stack.peek().equals("a")) return false;
                if (stack.peek().equals("a")){
                    stack.pop(); 
                    stack.push("ab");
                }
            }
            else {
                if (stack.isEmpty() || !stack.peek().equals("ab")) return false;
                else {
                    stack.pop(); 
                }
                
            }
        }
        return stack.isEmpty(); 
    }
}