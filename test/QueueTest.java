package test;

import linear.Queue;

public class QueueTest {
	public static void main(String[] args) {
		//创建队列对象
		Queue<String> q=new Queue<>();
		
		//测试队列中enqueue方法
		q.enqueue("a");
		q.enqueue("b");
		q.enqueue("c");
		q.enqueue("d");
		
		for (String string : q) {
			System.out.println(string);
		}
		
		System.out.println("=========");
		
		//测试队列中的dequeue方法
		String result=q.dequeue();
		System.out.println("出对列的元素是："+result);
		System.out.println(q.size());
	}
}
