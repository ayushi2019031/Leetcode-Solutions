class Node{
    int value;
    int label; 
    public Node(int value, int label){
        this.value = value;
        this.label = label;
    }
}
class Solution {
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        int n = values.length;
        Node[] arr = new Node[n];
        for (int i = 0; i < n; i++){
            arr[i] = new Node(values[i], labels[i]);
        }
        Arrays.sort(arr, new Comparator<Node>(){
            public int compare(Node o1, Node o2){
                int a1 = o2.value - o1.value;
                int a2 = o2.label - o1.label;
                if (a1 != 0) return a1; 
                return a2; 
            }
        });
        
        int sum = 0; 
        
        HashMap<Integer, Integer> hash = new HashMap<>(); 
        int i = 0; 
        while (i < n && numWanted > 0){
            if (!hash.containsKey(arr[i].label)) hash.put(arr[i].label, 0);
            
            if (hash.get(arr[i].label) + 1 <= useLimit){
                hash.put(arr[i].label, hash.get(arr[i].label) + 1);
                sum += arr[i].value;
                numWanted  -=1; 
            }
            i += 1;
        }
        
        return sum; 
    }
}