class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // matrix - 2D -> each row is sorted in ascending order
        //each column is sorted, in asc

        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return false;
        }


        int totalRows = matrix.length;
        int totalCols = matrix[0].length;

        int currentRow = 0;
        int currentCol = totalCols - 1;

        while( currentRow < totalRows && currentCol >= 0 ){
            int currentValue =  matrix[currentRow][currentCol];

            if(currentValue == target) {
                return true;
            }

            else if( currentValue  > target){
                currentCol --; 
            }
            else {
                currentRow++;
            }

            }
      
        return false;
        }

    }