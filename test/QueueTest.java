package test;

import linear.Queue;

public class QueueTest {
	public static void main(String[] args) {
		//�������ж���
		Queue<String> q=new Queue<>();
		
		//���Զ�����enqueue����
		q.enqueue("a");
		q.enqueue("b");
		q.enqueue("c");
		q.enqueue("d");
		
		for (String string : q) {
			System.out.println(string);
		}
		
		System.out.println("=========");
		
		//���Զ����е�dequeue����
		String result=q.dequeue();
		System.out.println("�����е�Ԫ���ǣ�"+result);
		System.out.println(q.size());
	}
}
