package test;

import graph.Digraph;
import graph.TopoLogical;
import linear.Stack;

public class TopoLogicalTest {
	public static void main(String[] args) {
		//׼������ͼ
		Digraph digraph = new Digraph(6);
		digraph.addEdge(0, 2);
		digraph.addEdge(0, 3);
		digraph.addEdge(2, 4);
		digraph.addEdge(3, 4);
		digraph.addEdge(4, 5);
		digraph.addEdge(1, 3);
		
		//ͨ��TopoLogical���������ͼ�еĶ����������
		TopoLogical topological = new TopoLogical(digraph);
	
		//��ȡ������������н��д�ӡ
		Stack<Integer> order = topological.order();
		StringBuilder sb = new StringBuilder();
		for (Integer w : order) {
			sb.append(w+"->");
		}
		String str = sb.toString();
		int index = str.lastIndexOf("->");
		str = str.substring(0,index);
		System.out.println(str);
		
	}
}
