package test;

import heap.Heap;

public class HeapTest {
	public static void main(String[] args) {
		//�����Ѷ���
		Heap<String> heap=new Heap<>(10);
		heap.insert("A");
		heap.insert("B");
		heap.insert("C");
		heap.insert("D");
		heap.insert("E");
		heap.insert("F");
		heap.insert("G");
		
		
		
		//ͨ��ѭ���Ӷ���ɾ������
		String result=null;
		while((result=heap.delMax())!=null) {
			System.out.print(result+" ");
		}
		

		
	}

}
