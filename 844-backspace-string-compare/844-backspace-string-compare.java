class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> st1 = new Stack<>(); 
        
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (c == '#'){
                if (!st1.isEmpty()) st1.pop();
            }
            else {
                st1.push(c);
            }
        }
        
        Stack<Character> st2 = new Stack<>(); 
        
        for (int i = 0; i < t.length(); i++){
            char c = t.charAt(i);
            if (c == '#'){
                if (!st2.isEmpty()) st2.pop();
            }
            else {
                st2.push(c);
            }
        }
        boolean f = true;
        while (!st1.isEmpty() && !st2.isEmpty()){
            if (st1.pop() != st2.pop()) return false;
        }
        if (st1.isEmpty() && st2.isEmpty()) return true;
        return false;
    }
}