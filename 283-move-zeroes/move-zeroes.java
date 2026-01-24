class Solution {
    public void moveZeroes(int[] nums) {    
        
        int lastZeroPosition = 0;
        for(int i = 0; i< nums.length; i++){
            if(nums[i]!=0){
                nums[lastZeroPosition++] = nums[i];
            }
        }

        while(lastZeroPosition < nums.length){
            nums[lastZeroPosition++] = 0;
        }
    }
}