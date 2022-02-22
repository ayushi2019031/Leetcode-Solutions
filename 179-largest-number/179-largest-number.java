class Solution {
    private class LargerNumber implements Comparator<Integer>{
            @Override
            public int compare(Integer o1, Integer o2){
                String a = Integer.toString(o1);
                String b = Integer.toString(o2);
                String p1 = a + b;
                String p2 = b + a; 
                return p2.compareTo(p1);
            }
        }
        
    public String largestNumber(int[] nums) {
        
        ArrayList<Integer>[] buckets = new ArrayList[10]; 
        for (int i = 0; i < 10; i++) buckets[i] = new ArrayList<>();
        
        for (int i = 0; i < nums.length; i++){
            int k = nums[i];
            String tbt = Integer.toString(k);
            buckets[tbt.charAt(0) - '0'].add(k);
        }
        for (int i = 0; i < 10; i++) {Collections.sort(buckets[i], new LargerNumber()); }
        
        StringBuilder string = new StringBuilder();
        for (int i = 9; i >= 1; i--){
            for (int num: buckets[i]){
                string.append(Integer.toString(num));
            }
        }
        if (string.toString().length() == 0){if (buckets[0].size() > 0) string.append("0");}
        else {
            for (int i = 0; i < buckets[0].size(); i++) string.append("0");
        }
        return string.toString();
        
    }
}