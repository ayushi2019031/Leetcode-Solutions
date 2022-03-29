class Solution {
    public int findDuplicate(int[] arr) {
        for (int i = 0; i < arr.length; i++){
            if (arr[Math.abs(arr[i]) - 1] >= 0){
                arr[Math.abs(arr[i]) - 1] *= -1;
            } 
            else{
                return Math.abs(arr[i]);
            }
        }
        return -1;
    }
}