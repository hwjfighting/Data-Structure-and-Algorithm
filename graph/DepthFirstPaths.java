package graph;

import linear.Stack;

public class DepthFirstPaths {
	//���������㣬ֵ��ʾ��ǰ�����Ƿ��Ѿ�������
	private boolean[] marked;
	//���
	private int s;
	//���������㣬ֵ��������s����ǰ����·���ϵ����һ������
	private int[] edgeTo;
	
	//�������������������ʹ��������������ҳ�Gͼ�����Ϊs������·��
	public DepthFirstPaths(Graph G,int s) {
		//��ʼ��marked����
		this.marked = new boolean[G.V()];
		//��ʼ�����
		this.s=s;
		//��ʼ��edgeTo����
		this.edgeTo=new int[G.V()];
		
		dfs(G,s);
	}
	
	//ʹ��������������ҳ�Gͼ��v������������ڶ���
	private void dfs(Graph G,int v) {
		//��v��ʾΪ������
		marked[v]=true;
		
		//��������v���ڽӱ��õ�ÿһ�����ڵĶ��㣬�����ݹ�����
		for (Integer w : G.adj(v)) {
			//�������wû�б�������������ݹ�����
			if(!marked[w]) {
				edgeTo[w]=v;//���ﶥ��w��·���ϵ����һ��������v
				dfs(G,w);
			}
			
		}
	}
	
	//�ж�w������s�����Ƿ����·��
	public boolean hasPathTo(int v) {
		return marked[v];
	}
	
	//�ҳ������s������v��·�������Ǹ�·�������Ķ��㣩
	public Stack<Integer> pathTo(int v){
		if(!hasPathTo(v)) {
			return null;
		}
		//����ջ���󣬱���·�������еĶ���
		Stack<Integer> path=new Stack<>();
		
		//ͨ��ѭ�����Ӷ���v��ʼ��һֱ��ǰ�ң����ҵ����Ϊֹ
		for(int x=v;x!=s;x=edgeTo[x]) {
			path.push(x);
		}
		
		//�����s���뵽ջ��
		path.push(s);
		return path;
	}
}
