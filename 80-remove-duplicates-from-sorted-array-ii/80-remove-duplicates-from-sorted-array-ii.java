class Solution {
    public int removeDuplicates(int[] nums) {
        int ans = 0; 
        int n = nums.length; 
        int i = 0; int j = 0;  int extra = 0; 
        while (i < n- extra){
            System.out.println(Arrays.toString(nums));
            j = i; 
            while (j < n - extra && nums[j] == nums[i]){
                  j += 1;
            }
            System.out.println(i + " " + j + " " + (n - extra));
            if (j - i > 2){
                extra += (j - i - 2);
                startdeleting(nums, i + 2, j, extra);
                i = i + 2; 
            }
            else {
                ans += j - i ; 
                i = j; 
            }
        }
        return n - extra;
    }
    public void startdeleting(int[] nums,int start, int idx, int extra){
        while (idx < nums.length){
            nums[start] = nums[idx];
            start += 1;
            idx += 1;
        }
    }
}