class NumArray {
    int prefix[];
    public NumArray(int[] nums) {
        this.prefix = new int[nums.length];
        this.prefix[0] = nums[0];
        for(int i = 1;i < nums.length;i++){
            this.prefix[i] = nums[i] + prefix[i-1];
            System.out.print(prefix[i]+" ");
        }
    }
    
    public int sumRange(int left, int right) {
        if(left == 0) return prefix[right];
        int sum = prefix[right] - prefix[left-1];
        return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */