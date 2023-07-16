package CompScience;
import java.util.*;
public class MatrixMain1 {
	
	public static int[][] listConverter(ArrayList<ArrayList<Integer>>pList){
		int[][] arr2d = new int[pList.size()][];
		
		for (int row = 0; row < arr2d.length; row++) {
			arr2d[row] = new int[pList.get(row).size()];
		}
		for(int  row = 0; row < pList.size(); row++){
			for (int col = 0; col < pList.get(row).size(); col++) {
				arr2d[row][col] = pList.get(row).get(col);
			}
		}
		return arr2d;
	}
	
	public static void printList(ArrayList<ArrayList<Integer>> pList) {
		for(int i = 0; i < pList.size(); i ++) {
			for(int j = 0; j< pList.get(i).size(); j++) {
				System.out.print(pList.get(i).get(j) + " ") ;
			}
			System.out.println(" ");
		}
	}
	
	
	public static ArrayList<ArrayList<Integer>> arrConverter(int[][] pArr){
		
		Integer[][] integerArr = new Integer[pArr.length][];

		for (int i = 0; i < pArr.length; i++) {
			for(int j = 0; j< pArr[i].length; j++)
			integerArr[i][j] = Integer.valueOf(pArr[i][j]);
		}
		ArrayList<ArrayList<Integer>> outer = new ArrayList<>();
		
		for (int row = 0; row < pArr.length; row++) {
			ArrayList<Integer> inner = new ArrayList<>();
			for (int col = 0; col < pArr[row].length; col++) {
				inner.add(integerArr[row][col]);
			}
			outer.add(inner);
		}
		return outer;
		
	}

	public static void main(String[] args) {
		FinalMatrixFolder tester1 = new FinalMatrixFolder();
		MatrixCalc test = new MatrixCalc();
		
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		
		ArrayList<Integer> innerList = new ArrayList <Integer>();
		ArrayList<Integer> innerList1 = new ArrayList <Integer>();
		list.add(innerList);
		innerList.add(7);
		innerList.add(2);
		innerList.add(3);
		innerList.add(3);
		list.add(innerList1);
		innerList1.add(3);
		innerList1.add(4);
		innerList1.add(3);
		innerList1.add(2);
		list.add(innerList);
		list.add(innerList1);
		
		printList(list);
		
		
		
		
		
		
	//	int[][] test5 = listConverter(outerList);
	//	int[][] test1 = {{1,4,5},{1,3,4},{0,0,0},{4,4,3},{1,3,2},{1,2,3},{1,2,3}};
		
		//test.printMatrix(test5);
		ArrayList<ArrayList<Integer>> result = tester1.foldAlongHorizontal(list);

System.out.println();
		printList(result);
		
		
		
	}

}
