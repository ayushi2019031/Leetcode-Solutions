class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        int l1 = Integer.toString(low).length(); 
        int l2 = Integer.toString(high).length(); 
        List<Integer> ans = new ArrayList<>();
        for (int i = l1; i <= l2; i++){
            ArrayList<Integer> aj = generate(i);
            for (int k: aj){ans.add(k);}
        }
        
        int s = 0; 
        List<Integer> fin = new ArrayList<>();
        for (int i = 0; i < ans.size(); i++){
            if (ans.get(i) >= low && ans.get(i) <= high){
                fin.add(ans.get(i));
            }
        }
        
        return fin; 
    }
    public ArrayList<Integer> generate(int l1){
        int[] arr = new int[l1];
        ArrayList<Integer> aj = new ArrayList<>(); 
        for (int i = 1; i <= 10 - l1; i++){
            StringBuilder ap = new StringBuilder(); 
            for (int j = i; j < i + l1; j++){
                ap.append(j);
            }
            aj.add(Integer.parseInt(ap.toString()));
        }
        return aj; 
    }
}