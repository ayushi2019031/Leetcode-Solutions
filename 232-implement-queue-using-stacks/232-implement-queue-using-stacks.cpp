class MyQueue {
public:
    stack<int> st1; 
    stack<int> st2;
    MyQueue() {
        
    }
    
    void push(int x) {
        st1.push(x);
        
    }
    
    int pop() {
        while (!st1.empty()){
            int k =st1.top(); 
            st2.push(k);
            st1.pop(); 
        }
        int p = st2.top();
        st2.pop();
        while (!st2.empty()){
            int r = st2.top(); 
            st1.push(r);st2.pop();
        }
        return p;
    }
    
    int peek() {
        while (!st1.empty()){
            int k =st1.top(); 
            st2.push(k);
            st1.pop(); 
        }
        int p = st2.top(); 
        while (!st2.empty()){
            int r = st2.top(); 
            st1.push(r);st2.pop();
        }
        return p;
        
    }
    
    bool empty() {
        return (st1.empty() && st2.empty());
    }
};

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue* obj = new MyQueue();
 * obj->push(x);
 * int param_2 = obj->pop();
 * int param_3 = obj->peek();
 * bool param_4 = obj->empty();
 */