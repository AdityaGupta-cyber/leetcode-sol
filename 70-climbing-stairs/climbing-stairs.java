class Solution {
    public int climbStairs(int n) {
        int[] arr = new int[n+1];
        for(int i = 0; i < arr.length;i++){
            arr[i] = -1;
        }
      return possibleWays(n,arr);
    }

    private int possibleWays(int n, int[] arr){
        
        if(n <= 2) return n;
        if(arr[n] != -1) return arr[n];
        
        arr[n] = possibleWays(n-1, arr) + possibleWays(n-2, arr);

        return arr[n];
    }
}