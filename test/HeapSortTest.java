package test;

import java.util.Arrays;

import heap.HeapSort;

public class HeapSortTest {
	public static void main(String[] args) {
		//����������
		String[] arr= {"S","O","R","T","E","X","A","M","P","L","E"};
		//ͨ��HeapSort�������е�Ԫ�ؽ�������
		HeapSort.sort(arr);
		//��ӡ�����������е�Ԫ��
		System.out.println(Arrays.toString(arr));
		
	}
}
