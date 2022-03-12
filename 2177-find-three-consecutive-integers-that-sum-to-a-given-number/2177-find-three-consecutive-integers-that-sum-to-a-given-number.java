class Solution {
    public long[] sumOfThree(long num) {
        num += 3; 
        if (num % 3 != 0) return new long[]{};
        long kk = num/3;
        return new long[]{kk - 2, kk - 1, kk};
    }
}