class Solution {
    public boolean isValidSerialization(String pre) {
        Stack<String> stack = new Stack();

        if(pre.equals("#")) return true;
        int idx = 0, nxt = 0;
        
        while(idx < pre.length()) {

            while(nxt < pre.length() && pre.charAt(nxt) != ',') nxt++;

            String cur = pre.substring(idx, nxt);
            idx = ++nxt;
                
            if(!cur.equals("#"))
                stack.push(cur);
            else {
                       if (stack.isEmpty()) return false;
                    while(!stack.isEmpty() && stack.peek().equals("#")) {
                           stack.pop();
                       if (stack.isEmpty()) return false;                    
                           stack.pop();                    
                    }
                
                    if(idx < pre.length())
                    stack.push(cur);
            }
        }

        // stack.pop();
        
        return stack.isEmpty();
    }
}