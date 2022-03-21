class Solution {
    public List<Integer> partitionLabels(String S) {
        int s = 0; 
        List<Integer> ans = new ArrayList<Integer>();
        HashMap<Character, Integer> last_hash = new HashMap<>();
        for (int i = S.length() - 1; i >= 0; i--){
            if (!last_hash.containsKey(S.charAt(i))){
                last_hash.put(S.charAt(i), i);
            }
        }
 //       int s = 0;
        while (s < S.length()){
         int ref = last_hash.get(S.charAt(s));
        for (int i = s; i <= last_hash.get(S.charAt(ref)); i++){
            ref = Math.max(ref, last_hash.get(S.charAt(i)));
        }
        ans.add(ref);
        s = ref + 1;
        }
        List<Integer> finally_ans = new ArrayList<Integer>();
        finally_ans.add(ans.get(0) + 1);
        for (int i = 1; i < ans.size(); i++){finally_ans.add(ans.get(i) - ans.get(i - 1));}
        return finally_ans;
    }
}