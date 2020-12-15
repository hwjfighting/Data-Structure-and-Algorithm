package graph;

import linear.Queue;

public class Graph {
	//������Ŀ
	private final int V;	
	//�ߵ���Ŀ
	private int E;
	//�ڽӱ�
	private Queue<Integer>[] adj;
	
	public Graph(int V) {
		//��ʼ����������
		this.V=V;
		//��ʼ���ߵ�����
		this.E=0;
		//��ʼ���ڽӱ�
		this.adj=new Queue[V];
		
		for(int i=0;i<adj.length;i++) {
			adj[i]=new Queue<Integer>();
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
	
	//��ͼ�����һ����v-w
	public void addEdge(int v,int w) {
		//������ͼ�У�����û�з���ģ����Ըñ߼ȿ���˵�Ǵ�v��w�ıߣ��ֿ���˵�Ǵ� w��v�ıߣ���ˣ���Ҫ��w������v���ڽӱ��У����һ�Ҫ��v������w���ڽӱ���
		adj[v].enqueue(w);
		adj[w].enqueue(v);
		//�ߵ�����+1
		E++;
	}
	
	//��ȡ�Ͷ���v���ڵ����ж���
	public Queue<Integer> adj(int v){
		return adj[v];
	}
	

}
