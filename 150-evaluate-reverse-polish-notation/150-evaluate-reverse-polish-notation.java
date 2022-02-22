class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>(); 
        for (int i = 0; i < tokens.length; i++){
            if (tokens[i].equals("+")){
                int a1 = stack.pop(); 
                int a2 = stack.pop();
                stack.push(a1 + a2);
            }
            else if (tokens[i].equals("-")){
                int a1 = stack.pop(); 
                int a2 = stack.pop();
                stack.push(a2 - a1);
            }
            else if (tokens[i].equals("*")){
                int a1 = stack.pop(); 
                int a2 = stack.pop();
                stack.push(a1* a2);
            }
            else if (tokens[i].equals("/")){
                int a1 = stack.pop(); 
                int a2 = stack.pop();
                stack.push(a2/a1);
            }
            else {stack.push(Integer.parseInt(tokens[i]));}
        }
        return stack.pop();
    }
}