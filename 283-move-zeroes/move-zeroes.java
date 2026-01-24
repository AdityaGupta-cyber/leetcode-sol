class Solution {
    public void moveZeroes(int[] nums) {    
        
        int lastZeroPosition = 0;
        for(int i = 0; i< nums.length; i++){
            if(nums[lastZeroPosition] != 0   && nums[i] == 0){
                    lastZeroPosition = i;  
                    continue;
            }

            //now that the lastZeroPosition is initialized with an index;
            //we check if the number is a non zero and if it is we swap and lastZeroPosition +=1;
            if(nums[i] == 0) continue;
                //swap values;
                int temp = nums[i];
                nums[i] = nums[lastZeroPosition];
                nums[lastZeroPosition] = temp;
                lastZeroPosition = lastZeroPosition +1;
        }
    }
}