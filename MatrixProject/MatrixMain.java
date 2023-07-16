package CompScience;

public class MatrixMain {

	public static boolean comparisonChecker(int[][] pTest, int[][] pExpec, int testNum) {
		MatrixCalc tester = new MatrixCalc();

		// if (result1==expected1)... // Why does this not work!?!?!?
		// It doesn't work because you're comparing memory addresses instead
		// of the arrays
		if (!tester.equals(pTest, pExpec)) {// if false it means the arrays aren't the same
			System.out.println("\nTest #" + testNum + " failed.\n");

			return false;
		}

		return true;
	}

	public static void main(String[] args) {
		MatrixCalc test = new MatrixCalc();// test is the variable used to
											// point towards the MatrixCalc object

		boolean passedAll = true;// used to determine that all the test were
									// successful.

		// There are the test case and what the result should look like.
		int[][] test1 = { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };
		int[][] expected1 = { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };

		int[][] test2 = { { 1 }, { 0, 0, 0 }, { 0, 0, 0 } };
		int[][] expected2 = { { 1 }, { 0, 0, 0 }, { 0, 0, 0 } };

		int[][] test3 = { { 1, 2 }, { 3, 4 } };
		int[][] expected3 = { { 1, 5 }, { 0, 4 } };

		int[][] test4 = { { 1, 0, 0 }, { 1 }, { 0, 0, 0 } };
		int[][] expected4 = { { 1, 0, 0 }, { 1 }, { 0, 0, 0 } };

		int[][] test5 = { { 1, 3, 1 }, { 8, 4, 6 }, { 3, 4, 6 } };
		int[][] expected5 = { { 1, 11, 4 }, { 0, 4, 10 }, { 0, 0, 6 } };

		int[][] test6 = { { 1, 3, 1, 4 }, { 8, 4, 6, 2 }, { 3, 4, 6, 8 }, { 1, 3, 2, 6 } };
		int[][] expected6 = { { 1, 11, 4, 5 }, { 0, 4, 10, 5 }, { 0, 0, 6, 10 }, { 0, 0, 0, 6 } };

		int[][] result1 = test.fold(test1);// calling the fold method from MatrixCalc on test1
		System.out.println("The result for test 1 is: ");
		test.printMatrix(result1);// printing out the result using the method from MatrixCalc
		passedAll = comparisonChecker(result1, expected1, 1);// it compares the arrays and returns a boolean
																// for their comparison

		int[][] result2 = test.fold(test2);
		System.out.println("The result for test 2 is: ");
		test.printMatrix(result2);
		passedAll = comparisonChecker(result2, expected2, 2);

		int[][] result3 = test.fold(test3);
		System.out.println("The result for test 3 is: ");
		test.printMatrix(result3);
		passedAll = comparisonChecker(result3, expected3, 3);

		int[][] result4 = test.fold(test4);
		System.out.println("The result for test 4 is: ");
		test.printMatrix(result4);
		passedAll = comparisonChecker(result4, expected4, 4);

		int[][] result5 = test.fold(test5);
		System.out.println("\nThe result for test 5 is: ");
		test.printMatrix(result5);
		passedAll = comparisonChecker(result5, expected5, 5);

		int[][] result6 = test.fold(test6);
		System.out.println("The result for test 6 is: ");
		test.printMatrix(result6);
		passedAll = comparisonChecker(result6, expected6, 6);

		if (passedAll) {// if the variable is true when it gets here then it means that all the test
						// were successful
			System.out.println("\nYou passed all current tests!");
		} else {
			System.out.println("Test(s) failed.  Please fix.");// if not print out that the tests weren't successful
		}

		
		FinalMatrixFolder tester1 = new FinalMatrixFolder();
		
	}
}
