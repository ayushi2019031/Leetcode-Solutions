class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        HashMap<Integer,Integer> hash = new HashMap<>(); 
        int n = nums.length;
        int s = -1; 
        int max = 0; 
        int[] pre = new int[n];
        pre[0] = nums[0];
        for (int i = 1; i < n; i++){
            pre[i] = pre[i - 1] + nums[i];
        }
        for (int i = 0; i < n; i++){
            if (hash.containsKey(nums[i])){
                s = Math.max(hash.get(nums[i]), s);
                hash.put(nums[i], i);
                        if (s != -1)
                max = Math.max(pre[i] - pre[s], max);
                else max = Math.max(pre[i], max);
            }
            else {
                hash.put(nums[i], i);
                if (s != -1)
                max = Math.max(pre[i] - pre[s], max);
                else max = Math.max(pre[i], max);
                System.out.println(max);
            }
        }
        return max; 
    }
}