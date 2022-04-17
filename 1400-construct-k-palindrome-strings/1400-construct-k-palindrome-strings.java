class Solution {
    public boolean canConstruct(String s, int k) {
        if (k > s.length()) return false; 
        HashMap<Character, Integer> hash = new HashMap<>(); 
        for (int i = 0; i < s.length(); i++){
            hash.put(s.charAt(i), hash.getOrDefault(s.charAt(i), 0) + 1);
        }
        List<Integer> list = new ArrayList<Integer>(hash.values()); 
        int tbt = 0; 
        for (int i = 0; i < list.size(); i++){
            tbt += (list.get(i) % 2); 
        }
        if (tbt <= k) return true; 
        return false; 
    }
}