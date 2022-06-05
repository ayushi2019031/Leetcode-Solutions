class Node{
    char c; 
    int freq;
    public Node(char c, int freq){
        this.c = c; 
        this.freq = freq;
    }
}
class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> hash = new HashMap<>(); 
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            hash.put(c, hash.getOrDefault(c, 0) + 1);
        }
        ArrayList<Node> list = new ArrayList<>(); 
        for (char c: s.toCharArray()){
            list.add(new Node(c, hash.get(c)));
        }
        
        Collections.sort(list, new Comparator<Node>(){
            public int compare(Node o1, Node o2){
                int aj =  o2.freq - o1.freq;
                if (aj == 0) return o1.c - o2.c;
                return aj;
            }
        });
        
        StringBuilder strb = new StringBuilder(); 
        for (Node node: list){
            strb.append(Character.toString(node.c));
        }
        return strb.toString();
        
    }
}