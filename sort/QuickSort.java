package sort;
//��������
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
		int base=arr[left];//��׼��
		int i=left;//����i ָ�������
		int j=right;//����j ָ�����ұ�
		// ��i��jû������ʱ����ѭ���ڼ���
		while(i != j) {
			//j����������� ����������Ȼ�׼��С�ģ���ͣ��
			//������Ȼ�׼�������ڻ�׼�����ͼ�������
			while(arr[j] >= base && j>i) {
				j--;//j���������ƣ�
			}
			while(arr[i] <= base && i<j) {
				i++;//i���������ƣ���������Ȼ�׼����ģ���ͣ��
			}
			//i��j��ͣ�º󣬽���λ��i��j��ֵ
			int temp=arr[i];
			arr[i]=arr[j];
			arr[j]=temp;
			
		}
		//���������whileѭ��������������������ѭ��������ִ��
		//����������������������˵��i��j������
		//i��j������Ҫ�����������λ�õ����ͻ�׼��
		
		//��������λ�õ�Ԫ�ظ�����׼λ�õ�Ԫ��
		arr[left]=arr[i];
		//���ѻ�׼λ�õ�Ԫ�ظ�����λ��
		arr[i]=base;
		
		//����׼����ʱ�͹�λ�ˣ���ߵĶ�����С���ұ߶�������
		
		//���Ż�׼������ߣ�
		quickSort(arr,left,i-1);
		//���Ż�׼�����ұ�
		quickSort(arr,j+1,right);
		
		
	}

}
