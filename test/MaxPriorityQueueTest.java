package test;

import priority.MaxPriorityQueue;

public class MaxPriorityQueueTest {
	public static void main(String[] args) {
		//�������ȶ���
		MaxPriorityQueue<String> queue=new MaxPriorityQueue<>(10);
		
		//�������д洢Ԫ��
		queue.insert("A");
		queue.insert("B");
		queue.insert("C");
		queue.insert("D");
		queue.insert("E");
		queue.insert("F");
		queue.insert("G");
		
		//ͨ��ѭ���Ӷ����л�ȡ����Ԫ��
		while(!queue.isEmpty()) {
			String max=queue.delMax();
			System.out.print(max+" ");
		}
		
	}
}
