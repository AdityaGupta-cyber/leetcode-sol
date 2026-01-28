class Solution {
    public int[] twoSum(int[] numbers, int target) {
        //two pointers
        int i = 0;
        int j = numbers.length - 1;

        while(i < j){

            if(numbers[i] + numbers[j] == target) return new int[]{i+1,j+1};
            
            if(numbers[i] + numbers[j] > target){
                j--;
                continue;
            }
            if( numbers[i] + numbers[j] < target){
                i++;
                 continue;
            }

        }

        return new int[]{1,1};
    }
}