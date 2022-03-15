class Solution {
    public int addDigits(int num) {
        if (num >= 0 && num <= 9) return num;
        String k = Integer.toString(num);
        int ans = 0; 
        for (int i = 0; i < k.length(); i++) ans += k.charAt(i) - '0';
        return addDigits(ans);
    }
}