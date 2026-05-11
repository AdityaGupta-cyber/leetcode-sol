class Solution {

    //perform binary search, return index or -1

    private int binarySearch(int nums[],int target){
        int i = 0;
        int j = nums.length - 1;

        while(i <= j){
            int mid = i + (j - i)/2;
            //if i is smaller than mid, the left part is sorted,
            //check if the number exists between the i & mid,
            //else for j

            if(nums[mid] == target) return mid;

            //left side is sorted;
            if(nums[i] <= nums[mid]){
                //element exists between the mid
                if(nums[i] <= target && target <= nums[mid]){
                        j = mid - 1;
                    }
                    else{
                        i = mid + 1;
                    }
            }

            //else if right side is sorted;
            else{
                if(nums[mid] < target && target <= nums[j]){
                    i = mid + 1;
                }
                else{
                    j = mid - 1;
                }
            }

        }

        return -1;
    }




    public int search(int[] nums, int target) {
        return binarySearch(nums,target);
    }
}