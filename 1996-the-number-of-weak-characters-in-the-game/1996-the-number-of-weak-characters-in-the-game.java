class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2){
                return o1[0] - o2[0];
            }
        });
        int ans = 0; 
        int len = properties.length;
        ArrayList<Integer> l1 = new ArrayList<>();    
        HashMap<Integer, Integer> hash = new HashMap<>();
        HashMap<Integer, Integer> indices = new HashMap<>(); 
        for (int i = 0; i < len; i++){
            System.out.print(Arrays.toString(properties[i]));
        

            if (l1.size() == 0){
                l1.add(properties[i][0]);
                hash.put(properties[i][0], properties[i][1]);
                indices.put(properties[i][0], 0);
            }
            else {
                if (l1.get(l1.size() - 1) == properties[i][0]){
                    int r = hash.get(properties[i][0]);
                    hash.put(properties[i][0], Math.max(properties[i][1], r));
                    
                }
                else{
                    l1.add(properties[i][0]);
                    hash.put(properties[i][0], properties[i][1]);
                    indices.put(properties[i][0], l1.size() - 1);
                    
                }
            }
        }
                    System.out.println("");
        System.out.println(hash);
        System.out.println(indices);
        System.out.println(l1);
        int max = 0; 
        for (int i = len - 1; i >= 0; i--){
            int r = indices.get(properties[i][0]);
            if (r == l1.size() -1){
                
            }
            else {
                int k = l1.get(r + 1);
                max = Math.max(max, hash.get(k));
                if (max > properties[i][1]){
                    ans += 1;
                }
            }
            // return ans;
        }
        
        
        return ans;
        
    }
}