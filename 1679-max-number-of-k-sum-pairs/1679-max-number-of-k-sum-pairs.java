class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0; int j = 0;
        ArrayList<Integer> list = new ArrayList<>(); 
        int n = nums.length;
        HashMap<Integer, Integer> hash = new HashMap<>(); 
        HashSet<Integer> visited = new HashSet<>(); 
        while (i < n){
            j = i; 
            list.add(nums[i]);
            while (j < n && nums[j] == nums[i]) j += 1;
            hash.put(nums[i], j - i);
            i = j; 
        }
        int ans = 0; 
        i = 0; 
        for (i = 0; i < list.size(); i++){
            int k1 = list.get(i);
            int k2 = k - list.get(i);
            
            if (k1 != k2 && !visited.contains(k1) && !visited.contains(k2) && hash.containsKey(k2)){
                ans += Math.min(hash.get(k1), hash.get(k2));
                visited.add(k1); visited.add(k2);
            }
            else if (k1 == k2 && !visited.contains(k1)){
                ans += (int) (Math.floor((double)hash.get(k1)/(double) 2.0));
                visited.add(k1);
            }
        }
        return ans;
    }
}