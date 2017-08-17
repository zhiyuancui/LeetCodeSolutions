package solutions;

public class SetMatrixZeroes {
	public void setZeroes(int[][] matrix) {
	    if(matrix == null)
	    {
		   return;
	    }
	   
	   boolean rowZero    = false;
	   boolean columnZero = false;
	   
	   
	   int row    = matrix.length;
	   int column = matrix[0].length;
	   
	   //check the row
	   for(int i = 0; i < row; i++)
	   {
		   if(matrix[i][0] == 0)
		   {
			   rowZero = true;
		   }
	   }
	   
	   //check the column
	   for(int i = 0; i < column; i++)
	   {
		   if(matrix[0][i] == 0)
		   {
			   columnZero = true;
		   }
	   }
	   
	   for(int i = 1; i < row; i++)
	   {
		   for(int j = 1; j< column; j++)
		   {
			   if(matrix[i][j] == 0)
			   {
				   matrix[i][0] = 0;
				   matrix[0][j] = 0;
			   }
		   }
	   }
	   
	   //Set Zeroes for row
	   for(int i = 1; i < row; i++)
	   {
		   if(matrix[i][0] == 0)
		   {
			   for(int j = 1; j < column; j++)
			   {
				   matrix[i][j] = 0;
			   }
		   }
	   }
	   
	   //Set Zeroes for column
		   for(int j = 1; j < column; j++)
		   {
			   if(matrix[0][j] == 0)
			   {
				   for(int i = 0; i < row; i++)
				   {
					   matrix[i][j] = 0;
				   }
			   }
		   }
		   
		   if(rowZero)
		   {
			   for(int i = 0; i < row; i++)
			   {
				   matrix[i][0] = 0;
			   }
		   }
		   if(columnZero)
		   {
			   for(int i = 0; i < column; i++)
			   {
				   matrix[0][i] = 0;
			   }
		   }
	
	    }
}
