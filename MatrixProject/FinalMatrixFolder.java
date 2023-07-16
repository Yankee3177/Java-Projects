package CompScience;

import java.util.ArrayList;

public class FinalMatrixFolder {
	
	/*
	 * List converter method changes converts and integer array into
	 * an ArrayList of Integers.
	 */

	private ArrayList<ArrayList<Integer>> listConverter(Integer[][] pArr) {

		ArrayList<ArrayList<Integer>> outer = new ArrayList<>();//This creates am ArrayList
															//of arrayLists

		for (int row = 0; row < pArr.length; row++) {
			ArrayList<Integer> inner = new ArrayList<>();//this is the list that you'll use to add integers to each column
			for (int col = 0; col < pArr[row].length; col++) {
				
				inner.add(pArr[row][col]);//add the integers from the incoming arr into it's corresponding
										//index in the arrayList.
			}
			outer.add(inner);// add a new row
		}
		return outer;

	}

	/*
	 * The list converter method converts a 2d ArrayList of Integers into a 2d array
	 * of ints.
	 */

	private Integer[][] arrConverter(ArrayList<ArrayList<Integer>> pList) {
		Integer[][] arr2d = new Integer[pList.size()][];// rows of array will equal length of rows in the list
		/*
		 * this bottom for loop will set the length of each row in the array depending
		 * on the length of each row in the 2d list.
		 */
		for (int row = 0; row < arr2d.length; row++) {
			arr2d[row] = new Integer[pList.get(row).size()];
		}
		/*
		 * The bottom loop is to go through every index in the list and add it to its
		 * corresponding index in the 2d array.
		 */
		for (int row = 0; row < pList.size(); row++) {
			for (int col = 0; col < pList.get(row).size(); col++) {
				arr2d[row][col] = pList.get(row).get(col);
			}
		}
		return arr2d;
	}

	public ArrayList<ArrayList<Integer>> foldAlongDiagonal(ArrayList<ArrayList<Integer>> pList, int pFoldType) {

		Integer[][] firstConversion = foldDiagonal(arrConverter(pList), pFoldType);// call the fold Diagonal
																				/*
																				 * with the arrayList converted
																				 * and store the result in a variable so that
																				 * you can then convert that result
																				 * back into an arrayList.
																				 * By calling the list converter
																				 * you get the integer arrayList back.
																				 */
																				
		ArrayList<ArrayList<Integer>> result = listConverter(firstConversion); 
		

		return result;
	}

	/*
	 * The fold along horizontal has the same principle as the fold alongDiagonal
	 * the only difference is that you'll be calling the foldHorizontal method.
	 */
	public ArrayList<ArrayList<Integer>> foldAlongHorizontal(ArrayList<ArrayList<Integer>> pList) {

		Integer[][] firstConversion = foldHorizontal(arrConverter(pList));

		ArrayList<ArrayList<Integer>> result = listConverter(firstConversion);

		return result;

	}

	/*
	 * validNum is used to make sure that a valid number according to the rules is
	 * being inputed.If the number is not 0-3 then it'll return false
	 */
	private boolean validNum(int nums) {
		if (nums < 4 && nums >= 0)
			return true;

		return false;
	}

	private Integer[][] foldDiagonal(Integer[][] pMatrix, int pFoldType) {
		Integer[][] nonValid = { { -13 } };

		if (!validNum(pFoldType))
			return nonValid;

		boolean isSquare = true;

		int rows = pMatrix.length;// Gives you the number of rows

		for (int i = 0; i < pMatrix.length; i++) {
			if (pMatrix[i].length != rows) {// Compare how many numbers are in each row
				isSquare = false; // to how many rows there are.If they don't equal then
				break; // the matrix is not square so don't continue with the loop.
			}

		}

		if (!isSquare)
			return pMatrix;// if it's not a square matrix just return the matrix that came as a parameter.

		if (pFoldType == 0) {

			for (int row = 0; row < pMatrix.length; row++) { // looping through the rows
				for (int col = 0; col < pMatrix[row].length; col++) {// looping through every index in row.

					if (row == col)// the numbers on the fold are the ones that the index of row equals index of
									// column
						continue;// so leave it the same and continue the loop

					pMatrix[col][row] += pMatrix[row][col];// add the current index to the opposite index
					pMatrix[row][col] = -5;// set current index to -5 so you can identify this index and turn it to 0

					if (pMatrix[row][col] == -5)// the index that needs to be set to 0 is identified
						pMatrix[row][col] = 0; // and is set to 0.

				}
			}
		}

		if (pFoldType == 1) {

			for (int row = 0; row < pMatrix.length; row++) { // looping through the rows
				for (int col = 0; col < pMatrix[row].length; col++) {// looping through every index in row.

					if (row == col)// the numbers on the fold are the ones that the index of row equals index of
									// column
						continue;// so leave it the same and continue the loop

					pMatrix[row][col] += pMatrix[col][row];// add the current index to the opposite index
					pMatrix[col][row] = -5;// set current index to -5 so you can identify this index and turn it to 0

					if (pMatrix[col][row] == -5)// the index that needs to be set to 0 is identified
						pMatrix[col][row] = 0; // and is set to 0.

				}
			}
		}
		/*
		 * When pFoldType = 2 || 3 the calculations are the same the only thing that
		 * changes is in what indexes you're going to start in. When fold # is 2, you
		 * want to add the upper to the lower and set the upper to 0; so that's why I
		 * started the loop from the bottom triangle and it's like I flipped the
		 * triangle.The same thing goes for 3 except I started the loop from the top.
		 */
		if (pFoldType == 2) {

			for (int row = pMatrix.length - 1; row >= 0; row--) { // looping through the rows
				for (int col = pMatrix[row].length - 1; col >= 0; col--) {// looping through every index in row.

					if (row + col == pMatrix.length - 1)// if you add the row and column index number
						continue; // and it equals the length of the array -1 then it's a fold

					if (pMatrix[row][col] == 0)
						continue;

					int lenDif = (pMatrix.length - 1) - (row + col); // to calculate the amount of numbers there are to
																		// make it to the fold number
					pMatrix[row][col] += pMatrix[row + lenDif][col + lenDif];// add the opposite number to the current
																				// number in the loop
					pMatrix[row + lenDif][col + lenDif] = 0;// and set that number you just added to 0;

				}

			}
		}
		if (pFoldType == 3) {

			Integer[][] newArr = new Integer[pMatrix.length][pMatrix.length];
			
			for (int row = 0; row < pMatrix.length; row++) {
				for (int col = 0; col < pMatrix.length; col++) {
					
					if (col == pMatrix.length - row - 1) { // if column equals the length - 1 - row then you're at a fold.
						newArr[row][col] = pMatrix[row][col];
					}
					if (col < pMatrix.length - 1 - row) {//add the current index to the length - 1 - column which is adding the opposites values.
						newArr[row][col] = pMatrix[row][col] + pMatrix[pMatrix.length - col - 1][pMatrix.length - row - 1];
					}
				}
			}
			/*
			 * After you finish creating the new array. some values are left in null
			 * because we didn't populate the whole array. For that we loop through
			 * the array again and if there's a null index then that index becomes 0.
			 */
			for (int row = 0; row < pMatrix.length; row++) {
				for (int col = 0; col < pMatrix.length; col++) {
					if(newArr[row][col] == null) newArr [row][col] = 0;
				}
			}
			
			return newArr;

		}
		return pMatrix;
	}

	private Integer[][] foldHorizontal(Integer[][] pMatrix) {

		if (pMatrix.length % 2 == 0)// if the amount of rows is an even number you
			return pMatrix; // can't fold the array horizontally.

		/*
		 * this boolean and for loop is used to determine if all the rows have the same
		 * amount of numbers. If they don't then that means that you won't be able to
		 * fold the array correctly.
		 */
		boolean sameRows = true;

		int rowLength = pMatrix[0].length;// Comparing the amount of numbers in
		for (int row = 1; row < pMatrix.length; row++) {// the first row to all the other rows

			if (pMatrix[row].length != rowLength) {
				sameRows = false;
				break;
			}
		}

		if (!sameRows)
			return pMatrix;

		int secFoldSetter = pMatrix.length - 1;// this var is used to set the opposite number to the number that's in
												// the
												// current index.
		int middle = (pMatrix.length - 1) / 2; // these are the numbers in the fold;the middle numbers.
		/*
		 * the for loop will only run up to the row before the middle. so the middle or
		 * the fold will never be read or manipulated. you'll add the number at the
		 * current index to the number that is opposite to it. Then you'll set the
		 * number that you just used to add to 0.
		 */
		for (int row = 0; row < middle; row++) {

			for (int col = 0; col < pMatrix[row].length; col++) {

				pMatrix[secFoldSetter][col] += pMatrix[row][col];
				pMatrix[row][col] = 0;

			}
			secFoldSetter--;// each time the col loop terminates
							// decrement by 1 so that you can
							// include all the rows starting from the last row
							// to the row after the middle row
		}

		return pMatrix;
	}
}
