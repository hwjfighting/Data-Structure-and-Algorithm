package graph;

import linear.Stack;

public class DepthFirstOrder {
	//���������㣬ֵ��ʾ��ǰ�����Ƿ��Ѿ�������
	private boolean[] marked;
	//ʹ��ջ���洢��������
	private Stack<Integer> reversePost;
	
	//����һ����⻷�������ͼG���Ƿ��л�
	public DepthFirstOrder(Digraph G) {
		//��ʼ��marked����
		this.marked = new boolean[G.V()];
		//��ʼ��reverseջ
		this.reversePost = new Stack<Integer>();
		//����ͼ��ÿ�����㣬��ÿ��������Ϊ��ڣ����һ�������������
		for(int v = 0;v<G.V();v++) {
			if(!marked[v]) {
				dfs(G,v);
			}
		}
		
	}
	
	//������������������Ѷ�������
	private void dfs(Digraph G,int v) {
		//��ǵ�ǰv�Ѿ�������
		marked[v] = true;
		//ͨ��ѭ�������������v
		for (Integer w : G.adj(v)) {
			//�����ǰ����wû����������ݹ����dfs��������
			if(!marked[w]) {
				dfs(G,w);
			}
		}
		//�ö���v��ջ
		reversePost.push(v);
	}
	
	//��ȡ������������
	public Stack<Integer> reversePost(){
		return reversePost;
	}
	
	//

}
