package test;

import priority.MinPriorityQueue;

public class MinPriorityQueueTest {

	public static void main(String[] args) {
		//创键优先队列
		MinPriorityQueue<String> queue=new MinPriorityQueue<>(10);
		
		//往队列中存储元素
		queue.insert("G");
		queue.insert("F");
		queue.insert("E");
		queue.insert("D");
		queue.insert("C");
		queue.insert("B");
		queue.insert("A");
		
		//通过循环从对列中获取最小的元素
		while(!queue.isEmpty()) {
			String min=queue.delMin();
			System.out.print(min+" ");
		}
				

	}

}
