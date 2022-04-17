class Solution {
    public int maximumScore(int a, int b, int c) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
            public int compare(Integer o1, Integer o2){
                return -Integer.compare(o1, o2); 
            }
        }); 
        pq.add(a); pq.add(b); pq.add(c); 
        int r = 0; 
        
        while (pq.size() >= 2){
            int aa = pq.poll(); 
            int bb = pq.poll(); 
            aa -=1; bb -= 1; 
            r += (1); 
             
            if (aa > 0) pq.add(aa); 
            if (bb > 0) pq.add(bb); 
            
        }
        return r; 
    }
}