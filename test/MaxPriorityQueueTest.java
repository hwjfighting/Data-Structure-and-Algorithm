package test;

import priority.MaxPriorityQueue;

public class MaxPriorityQueueTest {
	public static void main(String[] args) {
		//创键优先队列
		MaxPriorityQueue<String> queue=new MaxPriorityQueue<>(10);
		
		//往队列中存储元素
		queue.insert("A");
		queue.insert("B");
		queue.insert("C");
		queue.insert("D");
		queue.insert("E");
		queue.insert("F");
		queue.insert("G");
		
		//通过循环从对列中获取最大的元素
		while(!queue.isEmpty()) {
			String max=queue.delMax();
			System.out.print(max+" ");
		}
		
	}
}
