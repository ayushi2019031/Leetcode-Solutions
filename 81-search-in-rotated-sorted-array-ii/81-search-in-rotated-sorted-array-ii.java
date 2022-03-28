class Solution {
    public boolean search(int[] arr, int target) {
        if (arr.length == 1){return arr[0] == target;}
        int low = 0; int high = arr.length - 1;
        return bin(arr, target, 0, arr.length - 1);
    }
    public boolean bin(int[] arr, int target, int s, int e){
        if (s <= e){
            int id = (s + e)/2;
            if (arr[id] == target){return true;}
            return bin(arr, target, s, id - 1) ||  bin(arr, target, id + 1, e);
        }
        return false;
    }
}