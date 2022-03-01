class Solution {
    public int[] countBits(int num) {
        
        int[] array = new int[num + 1];
        double j_k =  Math.log(num)/Math.log(2);
        int j = (int) j_k;
        int tommy = 1;
        for (int i = 0; i < array.length; i++){
          array[i] = -1;  
        if (i == Math.pow(2, tommy) - 1 && tommy < num){
            array[i] = tommy;
            tommy += 1;
        }
        }
        array[0] = 0;
        if (num == 0){
        return array;
        }
        array[1] = 1;
        
        if (num == 1){
            return array;
        }
        array[2] = 1;
        if (num == 2){
            return array;
        }
        System.out.println(Arrays.toString(array));       
        for (int i = 1; i < array.length; i++){
            array[i] = helper(array, i);
        }
        return array;
    }
    public int helper(int[] array, int number){
        if (number < array.length && array[number] != -1){
            return array[number];
        }
        else if (number >= array.length){
            double tommy = (double) Math.log(number)/Math.log(2);
            int tom = (int) tommy;
            return tom + 1;
        }
        
        double j_k = (double) Math.log(number)/Math.log(2);
        int j = (int) j_k;
        int kk = (int) Math.pow(2, j + 1);
        int remain = kk -1 - number;
        
        array[number] = helper(array, kk - 1) - helper(array, remain);
        return array[number];
    }
}