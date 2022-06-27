class Solution {
    public int clumsy(int n) {
        
        Stack<Integer> stack = new Stack<>();
        char[] operations = new char[]{'*', '/','+', '-'};
        int index = 0;
        stack.push(n--);
        
        while(n>0){
            
            if(operations[index]=='*'){
                stack.push(stack.pop()*n--);
            }
            else if(operations[index] == '/'){
                stack.push((int)(stack.pop()/n--));
            }
            else if(operations[index] == '+')
                stack.push(n--);
            else
                stack.push(-1*n--);
            
            index = (index+1)%4;
        }
        
        int sum = 0;
        while(!stack.isEmpty())
            sum += stack.pop();
        
        return sum;
        
    }
}