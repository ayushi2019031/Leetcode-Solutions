class FreqStack {
    HashMap<Integer, Integer> hash;
    HashMap<Integer, Stack<Integer>> ref; 
    int max_freq = 0; 
    public FreqStack() {
        hash = new HashMap<>(); 
        ref = new HashMap<>(); 
    }
    
    public void push(int val) {
        int f = hash.getOrDefault(val, 0) + 1; 
        hash.put(val, f);
        if (f > max_freq) max_freq = f; 
        if (!ref.containsKey(f)){
            ref.put(f, new Stack<Integer>());
        }
        ref.get(f).push(val);
    }
    
    public int pop() {
        int x = ref.get(max_freq).pop(); 
        hash.put(x, hash.get(x) - 1);
        if (ref.get(max_freq).size() == 0){
            max_freq -= 1; 
            // while (!ref.containsKey(max_freq)) max_freq -= 1;
        }
        return x; 
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */