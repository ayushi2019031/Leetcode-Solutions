class MinStack {
public:
    stack<long> st;
    long min;
    
    void push(int val) {
        if(st.size() == 0){
            st.push(val);
            min = val;
        } else if(val >= min){
            st.push(val);
        } else {
            long fake = 0LL + val + val - min; // store fake value
            st.push(fake);
            min = val;
        }
    }
    
    void pop() {
        if(st.top() >= min){
            st.pop();
        } else {
            min = 2 * min - st.top();
            st.pop();
        }
    }
    
    int top() {
        if(st.top() < min){
            return min;
        } else {
            return st.top();
        }
    }
    
    int getMin() {
        return min;
    }
};