package graph;

import linear.Queue;

public class EdgeWeightedDiagraph {
	//��¼��������
	private final int V;
	//��¼������
	private int E;
	//�ڽӱ�
	private Queue<DirectedEdge>[] adj;
	
	public EdgeWeightedDiagraph(int V) {
		//��ʼ������
		this.V = V;
		//��ʼ����
		this.E = 0;
		//��ʼ���ڽӱ�
		this.adj = new Queue[V];
		
		for(int i = 0;i<adj.length;i++) {
			adj[i] = new Queue<DirectedEdge>();
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
	
	//���Ȩ��������һ����e
	public void addEdge(DirectedEdge e) {
		//��e���з���ģ�����ֻ��Ҫ��e�����������ڽӱ��м���
		int v = e.from();
		adj[v].enqueue(e);
		E++;
	}
	
	//��ȡ�ɶ���vָ�������еı�
	public Queue<DirectedEdge> adj(int v){
		return adj[v];
	}
	
	//��ȡ��Ȩ����ͼ�����б�
	public Queue<DirectedEdge> edges(){
		//����ͼ�е�ÿһ�����㣬�õ��ö�����ڽӱ������õ�ÿһ���ߣ���ӵ������з��ؼ���
		Queue<DirectedEdge> allEdges = new Queue<>();
		for(int v = 0;v<V;v++) {
			for(DirectedEdge edge : adj[v]) {
				allEdges.enqueue(edge);
			}
		}
		return allEdges;
	}
	

}
