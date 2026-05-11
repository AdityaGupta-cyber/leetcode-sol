class Solution {
    public int mySqrt(int x) {
        int i = 0;
        int j = x;
        int result = 0;

        while (i <= j) {
            int mid = i + (j - i) / 2;

            long sq = (long) mid * mid;

            if (sq == x) {
                return mid;
            }

            if (sq < x) {
                result = mid;
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }

        return result;
    }
}