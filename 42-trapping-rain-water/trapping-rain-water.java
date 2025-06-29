class Solution {
    public int trap(int[] height) {
        //start with array pre-processing
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        int count = 0;
        preProcessArray(leftMax, rightMax,height);

        for (int i = 0; i < height.length; i++) {
            int block = Math.min(leftMax[i],rightMax[i]) - height[i];
            if(block < 0) continue;
            count += block;
        }
        return count;
    }

    public static void preProcessArray(int[] leftMax, int[] rightMax,int[] height) {
        int left = 0;
        int right = 0;
        for (int i = 0; i < height.length; i++) {
            if (left < height[i]) {
                left = height[i];
                leftMax[i] = height[i];
            }
            else{
                leftMax[i] = left;
            }
            if (right < height[(height.length - 1) - i]) {
                right = height[(height.length - 1) - i];
                rightMax[(height.length - 1) - i] = height[(height.length - 1) - i];
            }
            else{
                rightMax[(height.length - 1) - i] = right;
            }
        }

 
    }
}