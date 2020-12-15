package test;

import java.util.Arrays;

import heimaSort.Quick;

public class SortTest {
	public static void main(String args[]) {
		Integer a[]= {8,4,5,7,1,3,6,2};
//		Bubble.sort(a);
//		Shell.sort(a);
//		Selection.sort(a);
//		Insertion.sort(a);
//		Merge.sort(a);
		Quick.sort(a);
		System.out.println(Arrays.toString(a));
		
	}

}
