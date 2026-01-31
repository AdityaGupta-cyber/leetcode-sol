class Solution {
    public int trap(int[] height) {
        int countBlocks = 0;
        int[] prefixMax = new int[height.length];
        int[] suffixMax = new int[height.length];

        //max to the left of the index;
        int maxLeft = 0;
        int maxRight = 0;
        for (int i = 0; i < height.length; i++) {
            maxLeft = Math.max(maxLeft, height[i]);
            prefixMax[i] = maxLeft;
        }
        //max to the right of the index;
        for (int i = height.length - 1; i >= 0; i--) {
            maxRight = Math.max(maxRight, height[i]);
            suffixMax[i] = maxRight;
        }

        for (int i = 0; i < height.length; i++) {
            int minHeight = Math.min(prefixMax[i], suffixMax[i]);
            countBlocks += minHeight - height[i];
        }

        return countBlocks;
    }
}