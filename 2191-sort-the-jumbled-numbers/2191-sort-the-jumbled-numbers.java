class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        HashMap<Integer, Integer> h1 = new HashMap<>(); 
        HashMap<Integer, Integer> h2 = new HashMap<>(); 
        int n = nums.length;
        for (int i = 0; i < 10; i++){
            h1.put(i, mapping[i]); h2.put(mapping[i], i);
        }
        String[] repl = new String[n];
        for (int i = 0; i < n; i++){
            repl[i] = convert1(nums[i], h1);
        }
        System.out.println(Arrays.toString(repl));
        Arrays.sort(repl, new Comparator<String>(){
            public int compare(String o1, String o2){
                int a1 = Integer.parseInt(o1);
                int a2 = Integer.parseInt(o2);
                return a1 - a2; 
            }
        });
        for (int i = 0; i <n; i++){
            nums[i] = Integer.parseInt(convert2(repl[i], h2));
        }
        return nums;
    }
    
    public String convert1(int a, HashMap<Integer, Integer> hash){
        String t = Integer.toString(a);
        StringBuilder strb = new StringBuilder(); 
        for (int i = 0; i < t.length(); i++){
            strb.append(hash.get(t.charAt(i) - '0'));
        }
        int kk = Integer.parseInt(strb.toString());
        return strb.toString(); 
    }
    
    public String convert2(String a, HashMap<Integer, Integer> hash){
        String t = a;
        StringBuilder strb = new StringBuilder(); 
        for (int i = 0; i < t.length(); i++){
            strb.append(hash.get(t.charAt(i) - '0'));
        }
        int kk = Integer.parseInt(strb.toString());
        return strb.toString(); 
    }
}