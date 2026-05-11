class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //select the row to search,
        //binary search that particular row.
        int m  = matrix.length - 1;

        for(int i = 0; i <= m;i++){
            //iterate through the rows that satisfy
            // start <= target <= end
            int start = 0;
            int end = matrix[i].length - 1;
            if(matrix[i][start] <= target && target <= matrix[i][end]){
                return binarySearch(matrix, target,i,end);
            }
        }
        return false;
    }

    private boolean binarySearch(int[][] matrix, int target,int m,int n){
        int i = 0;
        int j = n;
        while(i <= j){
            int mid = i + (j - i)/2;

            if(matrix[m][mid] == target) return true;
            if(matrix[m][mid] < target){
                i = mid + 1;
            }
            else{
                j = mid - 1;
            }
        }
        return false;
    }
}