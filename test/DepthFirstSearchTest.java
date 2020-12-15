package test;

import graph.DepthFirstSearch;
import graph.Graph;

public class DepthFirstSearchTest {

	public static void main(String[] args) {
		//׼��graph����
		Graph G=new Graph(13);
		
		G.addEdge(0, 5);
		G.addEdge(0, 1);
		G.addEdge(0, 2);
		G.addEdge(0, 6);
		G.addEdge(5, 3);
		G.addEdge(5, 4);
		G.addEdge(3, 4);
		G.addEdge(4, 6);
		
		G.addEdge(7, 8);
		
		G.addEdge(9, 11);
		G.addEdge(9, 10);
		G.addEdge(9, 12);
		G.addEdge(11,12);
		
		
		//׼�����������������
		DepthFirstSearch search=new DepthFirstSearch(G,0);
		
		//������ĳ��������ͨ�Ķ�������
		int count=search.count();
		System.out.println("�����0��ͨ�Ķ���������"+count);
		
		//����ĳ������������Ƿ���ͨ
		boolean marked1=search.marked(5);
		System.out.println("����5�붥��0�Ƿ���ͨ��"+marked1);
		boolean marked2=search.marked(11);
		System.out.println("����11�붥��0�Ƿ���ͨ��"+marked2);

	}

}
