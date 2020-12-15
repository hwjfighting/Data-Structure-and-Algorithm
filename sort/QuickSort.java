package sort;
//快速排序
public class QuickSort {

	public static void main(String[] args) {
		int arr[]= {9,3,5,6,8,45,12,36,5,46,9,5,8,3,6,4,510,96,23};
		quickSort(arr,0,arr.length-1);
		for(int i=0;i<arr.length-1;i++) {
			System.out.print(arr[i]+" ");
		}

	}
	public static void quickSort(int arr[],int left,int right) {
		if(left>right) {
			return;
		}
		int base=arr[left];//基准数
		int i=left;//变量i 指向最左边
		int j=right;//变量j 指向最右边
		// 当i和j没有相遇时，在循环内检索
		while(i != j) {
			//j从右往左检索 ，如果遇到比基准数小的，就停下
			//、如果比基准数大或等于基准数，就继续检索
			while(arr[j] >= base && j>i) {
				j--;//j从右往左移，
			}
			while(arr[i] <= base && i<j) {
				i++;//i从左往右移，如果遇到比基准数大的，就停下
			}
			//i和j都停下后，交换位置i和j的值
			int temp=arr[i];
			arr[i]=arr[j];
			arr[j]=temp;
			
		}
		//、如果上面while循环不成立，则会跳出这个循环。往下执行
		//、如果这个条件不成立，则说明i和j相遇了
		//i和j相遇后要交换这个相遇位置的数和基准数
		
		//、把相遇位置的元素赋给基准位置的元素
		arr[left]=arr[i];
		//、把基准位置的元素给相遇位置
		arr[i]=base;
		
		//、基准数此时就归位了，左边的都比它小，右边都比它大
		
		//、排基准数的左边，
		quickSort(arr,left,i-1);
		//、排基准数的右边
		quickSort(arr,j+1,right);
		
		
	}

}
