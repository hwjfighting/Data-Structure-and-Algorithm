package sort;

public class SelectionSort {

	public static void main(String[] args) {
		int a[]= {5,2,3,6,8,6,9,12,36,23};
		System.out.print("原始数组：");
		for(int i=0;i<a.length;i++) {
			a[i]=(int)(Math.random()*100);
			System.out.print(a[i]+" ");
			
		}
		System.out.println();
		select_sort(a);
		System.out.print("新数组：");
		for(int i=0;i<a.length;i++) {
			System.out.print(+a[i]+" ");
		}
		
	}
	public static void select_sort(int a[]){

		   for(int i=0;i<a.length-1;i++){

		       int minIndex = i;//暂时最小值下标
		       for(int j=i+1;j<a.length;j++){
		          if(a[j]<a[minIndex]){
		              minIndex = j;
		          }
		       }
		       if(minIndex != i){
		           int temp = a[i];
		           a[i] = a[minIndex];
		           a[minIndex] = temp;
		       }
		   }
		}
}