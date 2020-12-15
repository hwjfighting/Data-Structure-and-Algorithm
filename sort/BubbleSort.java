package sort;

public class BubbleSort {

	public static void main(String[] args) {
		int a[]= {25,12,9,8,2,36,58,45,20,5};
		sort(a);
		print(a);
		

	}
	public static void sort(int a[]) {
		//外层循环控制找出每一次的最大值
		for(int i=a.length-1;i>0;i--) {
			//内层循环控制两两之间的比较 
			for(int j=0;j<i;j++) {
				if(a[j]>a[j+1]) {
					swap(a,j,j+1);
				}
			}
		}
	}
	public static void swap(int a[],int i,int j) {
		int temp=a[i];
		a[i]=a[j];
		a[j]=temp;
		
	}
	public static void print(int a[]) {
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i]+" ");
		}
	}
}
