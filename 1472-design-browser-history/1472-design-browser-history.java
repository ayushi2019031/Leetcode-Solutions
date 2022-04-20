class BrowserHistory {
    
    ArrayList<String> list = new ArrayList<>(); 
    int curr_index = 0; 
    String homepage; 
    public BrowserHistory(String homepage) {
        
        list.add(homepage);
        this.homepage = homepage; 
        
    }
    
    public void visit(String url) {
        while (list.size() - 1 > curr_index){
            list.remove(list.size() - 1); 
        }
        list.add(url); 
        curr_index = list.size() - 1; 
    }
    
    public String back(int steps) {
        int max_steps = Math.min(steps, curr_index + 1); 
        int u = curr_index - max_steps;
        curr_index = u; 
        if (curr_index  <0) {
            curr_index = 0; 
            return homepage; 
        }
        return list.get(u); 
    }
    
    public String forward(int steps) {
        int max_steps = Math.min(list.size() - curr_index, steps); 
        int u = curr_index + max_steps; 
        curr_index = u; 
        if (u >= list.size()){
            curr_index = list.size() - 1;
            return list.get(curr_index); 
        }
        return list.get(u); 
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */