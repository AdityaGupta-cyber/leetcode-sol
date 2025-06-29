// class Solution {
//     public int trap(int[] height) {
//         //T.C -> O(n)
//         //start with array pre-processing and store the max value of left and right based on the current index in the array.
//         int[] leftMax = new int[height.length];
//         int[] rightMax = new int[height.length];
//         int count = 0;
//         preProcessArray(leftMax, rightMax,height);

//         for (int i = 0; i < height.length; i++) {
//             int block = Math.min(leftMax[i],rightMax[i]) - height[i];
//             if(block < 0) continue;
//             count += block;
//         }
//         return count;
//     }

//     public static void preProcessArray(int[] leftMax, int[] rightMax,int[] height) {
//         int left = 0;
//         int right = 0;
//         for (int i = 0; i < height.length; i++) {
//             if (left < height[i]) {
//                 left = height[i];
//                 leftMax[i] = height[i];
//             }
//             else{
//                 leftMax[i] = left;
//             }
//             if (right < height[(height.length - 1) - i]) {
//                 right = height[(height.length - 1) - i];
//                 rightMax[(height.length - 1) - i] = height[(height.length - 1) - i];
//             }
//             else{
//                 rightMax[(height.length - 1) - i] = right;
//             }
//         }

//     }
// }

class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0)
            return 0;
        int n = height.length;
        int leftMax = height[0];
        int rightMax = height[n - 1];

        int countBlocks = 0;

        int i = 1;
        int j = n - 2;

        while (i <= j) {
            if (leftMax <= rightMax) {
                leftMax = Math.max(leftMax, height[i]);
                countBlocks += (leftMax - height[i]);
                i++;
            } else {
                rightMax = Math.max(rightMax, height[j]);
                countBlocks += (rightMax - height[j]);
                j--;
            }
        }
        while (i <= j) {
            if (leftMax <= rightMax) {
                leftMax = Math.max(leftMax, height[i]);
                countBlocks += leftMax - height[i];
                i++;
            } else {
                rightMax = Math.max(rightMax, height[j]);
                countBlocks += rightMax - height[j];
                j--;
            }
        }
        return countBlocks;
    }
}