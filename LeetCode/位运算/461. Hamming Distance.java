class Solution {
    public int hammingDistance(int x, int y) {
        int res = 0;
        int tmp = x ^ y;
        while(tmp != 0) {
            res++;
            tmp = tmp & (tmp - 1);
        }
        return res;
    }
}