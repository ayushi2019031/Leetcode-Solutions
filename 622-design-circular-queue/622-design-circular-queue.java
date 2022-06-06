class MyCircularQueue {
    int[] arr;
    int s = 0; 
    int e = -1; 
    int k; 
    int size = 0; 
    public MyCircularQueue(int k) {
        this.arr = new int[k];
        this.s = s; 
        this.e = e;
        this.k = k; 
    }
    
    public boolean enQueue(int value) {
        if (isFull()) return false;
        e += 1;
        e = e % k;
        arr[e ] = value; 
        
        size += 1;
        return true;
    }
    
    public boolean deQueue() {
        if (isEmpty()) return false;
        arr[s] = -1; 
        s += 1; 
        s = s % k;
        size -= 1; 
        return true;
    }
    public int Front() {
        if (isEmpty()) return -1; 
        return arr[s];
    }
    
    public int Rear() {
        if (isEmpty())return -1; 
        return arr[e];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == k; 
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */