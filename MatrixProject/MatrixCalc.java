package CompScience;

public class MatrixCalc {

	public boolean equals(int[][] m1, int[][] m2) {
		if (m1.length != m2.length) {// return false when the 2d arrays don't have the same amount of
			return false; // rows.
		}

		for (int i = 0; i < m1.length; i++) {
			if (m1[i].length != m2[i].length) {// return false when the 2d arrays don't have the same
				return false; // amount of numbers in each row
			}
			for (int j = 0; j < m1[i].length; j++) {
				if (m1[i][j] != m2[i][j]) {// you're going to compare every number in the same indexes
					return false; // from both arrays and if they're not
									// equal return false.
				}
			}
		}
		return true;// if you make it here it means both 2d arrays are the same.
	}

	public void printMatrix(int[][] matrix) {// this is used to print a matrix
		for (int i = 0; i < matrix.length; i++) {// loops through the rows
			System.out.print("[");
			for (int j = 0; j < matrix[i].length; j++) {// goes through every number
				System.out.print(matrix[i][j]); // in row[i] and prints them out
				if (j != matrix[i].length - 1) {// as long as its not in the last index
					System.out.print(",");// print a comma.
				}
			}
			System.out.println("]");// after you're finished with the row, add a closing
									// bracket
		}
	}

	public int[][] fold(int[][] pMatrix) {
		if(pMatrix.length%2 == 0) return pMatrix;
		
		int rowSetter = 0;
		int secFoldSetter = pMatrix.length-1;
		
		for (int row = 0; row < pMatrix.length; row++) {
			for (int col = 0; col < pMatrix[row].length; col++) {
				
			if(row == pMatrix.length -1/2)	continue;
			
			pMatrix[secFoldSetter][col] += pMatrix[rowSetter][col];
			pMatrix[rowSetter][col] = 0;
				
				
				
			}
		}
		return pMatrix;

	}

}
