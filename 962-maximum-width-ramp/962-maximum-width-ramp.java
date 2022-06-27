class Solution {
    public int maxWidthRamp(int[] nums) {
        ArrayList<int[]> list= new ArrayList<>();
        int n = nums.length; 
        for (int i = 0; i < n; i++){
            list.add(new int[]{i, nums[i]});
        }
        Collections.sort(list, new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2){
                int a1 = o1[1] - o2[1];
                int a2 = o1[0] - o2[0];
                if (a1 != 0) return a1; 
                return a2; 
            }
        });
        int ans = 0; 
        int maxind = list.get(n- 1)[0]; 
        for (int i = n- 2; i >= 0; i--){
            ans = Math.max(maxind - list.get(i)[0], ans);
            maxind = Math.max(maxind, list.get(i)[0]);
        }
        return ans; 
    }
}