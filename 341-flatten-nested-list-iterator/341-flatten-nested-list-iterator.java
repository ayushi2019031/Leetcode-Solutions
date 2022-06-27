/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    int pos = 0; 
    List<NestedInteger> nestedList;
    HashMap<Integer, NestedIterator> hash = new HashMap<>(); 
    NestedIterator newfella;
    Queue<Integer> q = new LinkedList<>(); 
    public NestedIterator(List<NestedInteger> nestedList) {
        this.nestedList = nestedList;
        while (hasNexthelp()){q.add(nexthelp());}

    }
    public Integer getpos(int pos){
        NestedInteger aj = nestedList.get(pos);
        NestedIterator newfella = new NestedIterator(aj.getList());
        
        if (aj.isInteger()) {pos += 1; return aj.getInteger();}
        else {
            return newfella.next();
            
        }
    }
    @Override
    public boolean hasNext(){
        return q.size() > 0 && q.peek() != null; 
    }
    @Override
    public Integer next(){
        
        return q.poll();
    }
    public Integer nexthelp(){
        System.out.println(pos);
        NestedInteger aj = nestedList.get(pos);
        
        if (aj.isInteger()) {pos += 1; return aj.getInteger();}
        else {
        if (!hash.containsKey(pos)){hash.put(pos, new NestedIterator(aj.getList()));}
        newfella = hash.get(pos);                             
        if (newfella.hasNext()) {return newfella.next();}
            else {
                pos += 1;
                if (hasNexthelp()) return nexthelp(); 
            }
            return aj.getInteger();
        }
        
    }

    // @Override
    public boolean hasNexthelp() {
        // pos += 1;
     if (pos < nestedList.size()) return true;
        return false;
    }
}

/**
 * Your estedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */