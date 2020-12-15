package graph;

import linear.Queue;

public class EdgeWeightedGraph {
	//��������
	private final int V;
	//�ߵ�����
	private int E;
	//�ڽӱ�
	private Queue<Edge>[] adj;
	
	//����һ������V������Ŀռ�Ȩ����ͼ
	public EdgeWeightedGraph(int V) {
		//��ʼ����������
		this.V = V;
		//��ʼ���ߵ�����
		this.E = 0;
		//��ʼ���ڽӱ�
		this.adj = new Queue[V];
		for(int i = 0;i<adj.length;i++) {
			adj[i] = new Queue<Edge>();
		}
	}
	
	//��ȡͼ�ж��������
	public int V() {
		return V;
	}
	
	//��ȡͼ�бߵ�����
	public int E() {
		return E;
	}
	
	//���Ȩ����ͼ�����һ����e
	public void addEdge(Edge e) {
		//��Ҫ�ñ�eͬʱ������e����ߵ������ڽӱ���
		int v = e.either();
		int w = e.other(v);
		
		adj[v].enqueue(e);
		adj[w].enqueue(e);
		
		//�ߵ�����+1
		E++;
	}
	
	//��ȡ�Ͷ���v���������б�
	public Queue<Edge> adj(int v){
		return adj[v];
	}
	
	//��ȡ��Ȩ����ͼ�����б�
	public Queue<Edge> edges(){
		//����һ�����ж��󣬴洢���еı�
		Queue<Edge> allEdges = new Queue<>();
		//����ͼ�е�ÿһ�����㣬�ҵ��ö�����ڽӱ��ڽӱ��д洢�˸ö��������ÿһ����
		//��Ϊ��������ͼ������ͬһ����ͬʱ��������������������������ڽӱ���Ҫ��һ����ֻ��¼һ��
		for(int v=0;v<V;v++) {
			for (Edge e : adj[v]) {
				if(e.other(v)<v) {
					allEdges.enqueue(e);
				}
			}
		}
		return allEdges;
	}
	

}
