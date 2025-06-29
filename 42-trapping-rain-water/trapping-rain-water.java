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
        int n = height.length;
        int left = 0, right = n - 1;
        int leftMax = 0, rightMax = 0;
        int water = 0;

        while (left <= right) {
            if (height[left] <= height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    water += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    water += rightMax - height[right];
                }
                right--;
            }
        }

        return water;
    }
}