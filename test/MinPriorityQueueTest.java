package test;

import priority.MinPriorityQueue;

public class MinPriorityQueueTest {

	public static void main(String[] args) {
		//�������ȶ���
		MinPriorityQueue<String> queue=new MinPriorityQueue<>(10);
		
		//�������д洢Ԫ��
		queue.insert("G");
		queue.insert("F");
		queue.insert("E");
		queue.insert("D");
		queue.insert("C");
		queue.insert("B");
		queue.insert("A");
		
		//ͨ��ѭ���Ӷ����л�ȡ��С��Ԫ��
		while(!queue.isEmpty()) {
			String min=queue.delMin();
			System.out.print(min+" ");
		}
				

	}

}
