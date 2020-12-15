package graph;

import linear.Queue;

public class Digraph {
	//������Ŀ
	private final int V;
	//�ߵ���Ŀ
	private int E;
	//�ڽӱ�
	private Queue<Integer>[] adj;
	
	public Digraph(int V) {
		//��ʼ����������
		this.V = V;
		//��ʼ���ߵ�����
		this.E = 0;
		//��ʼ���ڽӱ�
		this.adj = new Queue[V];
		for(int i = 0; i<adj.length;i++) {
			adj[i] = new Queue<Integer>();
		}
	}
	
	//��ȡ������Ŀ
	public int V() {
		return V;
	}
	
	//��ȡ�ߵ���Ŀ
	public int E() {
		return E;
	}
	
	//������ͼ�����һ���� v->W
	public void addEdge(int v,int w) {
		//ֻ��Ҫ�ö���w�����ڶ���v���ڽӱ��У���Ϊ�����з���ģ����գ�����v���ڽӱ��д洢�����ڶ���ĺ����ǣ�v->��������
		adj[v].enqueue(w);
		E++;
	}
	
	//��ȡ��vָ���ı������ӵ����ж���
	public Queue<Integer> adj(int v){
		return adj[v];
	}
	
	//��ͼ�ķ���ͼ
	private Digraph reverse() {
		//��������ͼ����
		Digraph r = new Digraph(V);
		for(int v=0;v<V;v++) {
			//��ȡ�ɶ���vָ�������б�
			for(Integer w : adj[v]) {// ԭͼ�б�ʾ�����ɶ���v->w�ı�
				
				r.addEdge(w, v);//w->v
			}
		}
		
		return r;
	}
	
	
	
	

}
