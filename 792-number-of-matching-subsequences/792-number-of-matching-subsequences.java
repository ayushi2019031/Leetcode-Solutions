class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        if(words==null || words.length==0) return 0;
        
        HashMap<Character, Queue<String>> map=new HashMap<>();
        
        for(int i=0;i<s.length();i++){
            char x=s.charAt(i);
            
            map.putIfAbsent(x,new LinkedList<>());
        }
        
        for(String word : words){
            char x=word.charAt(0);
            
            if(map.containsKey(x)){
                map.get(x).add(word);
            }
        }
        
        int ans=0;
        
        for(int i=0;i<s.length();i++){
            char charStart=s.charAt(i);
            
            Queue<String> q= map.get(charStart);
            int size=q.size();
            
            for(int j=0;j<size;j++){
                String str=q.poll();
                
                if(str.substring(1).equals("")) ans++;
                else{
                    if(map.containsKey(str.charAt(1))) map.get(str.charAt(1)).add(str.substring(1));
                }
            }
        }
        return ans;
    }
}