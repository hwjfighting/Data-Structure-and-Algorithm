package graph;

import linear.Stack;

public class TopoLogical {
	//�������������
	private Stack<Integer> order;
	
	//���������������
	public TopoLogical(Digraph G) {
		//����һ��������򻷵Ķ���
		DirectedCycle cycle = new DirectedCycle(G);
		//�ж�Gͼ����û�л������û�л�������ж������򣬴���һ�������������
		if(!cycle.hasCycle()) {
			DepthFirstOrder depthFirstOrder = new DepthFirstOrder(G);
			order = depthFirstOrder.reversePost();
		}
	}
	
	//�ж�G�Ƿ��ֻ�
	private boolean isCycle() {
		return order == null;
	}
	
	//��ȡ������������ж���
	public Stack<Integer> order(){
		return order;
	}

}
