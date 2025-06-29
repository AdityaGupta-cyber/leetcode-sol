class Solution {
    public int[] twoSum(int[] nums, int target) {
        // int i = 0;
        int j = nums.length - 1;
        Map<Integer,Integer> targetMap = new HashMap<>();
        
        for(int i = 0;i <= j; i++){
            if(targetMap.containsKey(target -  nums[i])){
                return new int[]{i, targetMap.get(target - nums[i])};
            }
            targetMap.put(nums[i], i);
        }
        return new int [] {0,0};
    }
}
