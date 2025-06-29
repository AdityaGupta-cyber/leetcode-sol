class Solution {
// brute force -  O(n * n)
    //l * b or height * breadth
    // check breadth between the pointers and the minimum of both the heights

    // public int maxArea(int[] height) {
    //     int area = 0;
    //     for(int i = 0; i< height.length; i++){
    //         for(int j = i; j < height.length; j++){
    //             int calculateHeight = Math.min(height[i],height[j]);
    //             area  = Math.max(area, (j - i) * calculateHeight);
    //         }
    //     }
    //     return area;
    // }


 // optimal - in linear time  using two  pointer 
 // two pointers on the extremes of the array and after calculation of the area the pointer which holds lesser height is moved to the next position
    public int maxArea(int[] height) {
        int area  = 0;
        int left  = 0;
        int right = height.length - 1;

        while(left < right){
            area =  Math.max(area,( right - left) * Math.min(height[left], height[right]));

            if( height[left] <= height[right])
            {
                left++;
            }
            else{
                right--;
            }
        }
        return area;
    }
}