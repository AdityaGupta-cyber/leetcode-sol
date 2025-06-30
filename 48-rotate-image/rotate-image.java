class Solution {
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        for(int i = 0; i < len; i++){
            for(int j = i + 1; j < len; j++){
                    int temp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = temp;   
            }
        }

        //reverse every array in the matrix

        for(int i = 0; i < len; i++){
            int left = 0;
            int right = len - 1;

            while(left < right){
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
                
            }
        }
    }
}