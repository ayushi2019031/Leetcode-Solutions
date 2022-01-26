class Solution {
    public int leastInterval(char[] tasks, int k) {
        
            return  helper(tasks, k);
       
    }
    
    public int helper(char[] tasks,int k){
        PriorityQueue<Integer> pQ = new PriorityQueue<Integer>(new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return  -Integer.compare(o1, o2);
            }
        });
        k += 1;
        HashMap<Character, Integer> hmap = new HashMap<Character, Integer>();
        for (int i  = 0; i < tasks.length; i++){
            if (hmap.containsKey(tasks[i])){
                hmap.put(tasks[i], hmap.get(tasks[i]) + 1);
            }
            else{
                hmap.put(tasks[i], 1);
            }
        }
        Set set = hmap.entrySet();
      Iterator iterator = set.iterator();
        while (iterator.hasNext()){
              Map.Entry mentry = (Map.Entry)iterator.next();
            pQ.add((int)mentry.getValue());
        }
        int time = 0;
        while (pQ.size() != 0){
            ArrayList<Integer> ref = new ArrayList<Integer>(k);
            int i = 0;
            
            while ( i < k ){
                if (pQ.size() > 0){
                if (pQ.peek() > 1){ref.add( pQ.poll() - 1);}
                else{
                    pQ.poll();
                }
               
                           
            }
                
                 time += 1;
                if (pQ.size() == 0 && ref.size() == 0){
                    break;
                } 
                i++;
            }
            for (int l: ref){
                pQ.add(l);
            }
        }
        
       return time;
    }
}