class Solution {
    public int findNthDigit(int n) {
         int digitLvl = 1;
        long cnts = 9;
        while (n - digitLvl * cnts > 0) {
            n -= digitLvl * cnts;
            digitLvl++;
            cnts *= 10;
        }
        int startN = (int)Math.pow(10, digitLvl - 1);
        int finalN = startN + (n - 1) / digitLvl;
        int whichDigit = (n - 1) % digitLvl;
        return String.valueOf(finalN).charAt(whichDigit) - '0';
    }
}