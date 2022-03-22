class Solution {
    public String getSmallestString(int n, int k) {
           int x = (k - n) / 25;
    int y = (k - n) % 25;
    char[] result = new char[n];
    int i = 0;
    for (; i < n - x - 1; i ++)
      result[i] = 'a';
    if (x < n)
      result[i++] = (char)('a' + y);
    for (; i < n; i++)
      result[i] = 'z';

    return new String(result);
    }
}