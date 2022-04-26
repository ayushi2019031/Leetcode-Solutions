class StockSpanner {
    Stack<Node> stack = new Stack<>(); 
    public StockSpanner() {
        
    }
    
    public int next(int price) {
        if (stack.size() == 0){
            stack.push(new Node(price, 1)); return 1; 
        }
        else {
            int aj = 0; 
            while (!stack.isEmpty() && stack.peek().val <= price){
                aj += stack.pop().ans; 
            } 
            stack.push(new Node(price, aj + 1)); 
            return aj + 1; 
        }
    }
}
class Node{
    int val; 
    int ans; 
    public Node(int val, int ans){this.val = val; this.ans = ans;}
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */