class Solution {
    public int trap(int[] height) {
        int result = 0;
        int maxRight = 0;
        int maxLeft = 0;
        int i = 0;
        int j = height.length - 1;

        while (i <= j) {

            if (height[i] <= height[j]) {
                //check if the maxLeft is smaller than height[i]

                if (height[i] >= maxLeft)
                    maxLeft = height[i];

                else
                    result += maxLeft - height[i];
                i++;
            } else {
                if (height[j] >= maxRight)
                    maxRight = height[j];
                else
                    result += maxRight - height[j];
                j--;
            }
        }

        return result;

    }
}