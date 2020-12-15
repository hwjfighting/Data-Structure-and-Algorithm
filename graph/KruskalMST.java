package graph;

import linear.Queue;
import priority.MinPriorityQueue;
import uf.UF_Tree_Weighted;

public class KruskalMST {
	//������С�����������б�
	private Queue<Edge> mst;
	//���������㣬ʹ��uf.connect(v,w)�����ж϶���v�Ͷ���w�Ƿ���ͬһ�����У�
	//ʹ��uf.union(v,w)���԰Ѷ���v���ڵ����Ͷ���w���ڵ����ϲ�
	private UF_Tree_Weighted uf;
	//�洢ͼ�����еıߣ�ʹ����С���ȶ��У����հ���Ȩ�ؽ�������
	private MinPriorityQueue<Edge> pq;
	
	//����һ����Ȩ����ͼ��������С�������������
	public KruskalMST(EdgeWeightedGraph G){
		//��ʼ��MST
		this.mst = new Queue<Edge>();
		//��ʼ��uf
		this.uf = new UF_Tree_Weighted(G.V());
		//��ʼ��pq
		this.pq = new MinPriorityQueue<>(G.E()+1);
		//��ͼ�����еıߴ洢��pq��
		for(Edge e : G.edges()) {
			pq.insert(e);
		}
		
		//����pq���У��õ���СȨ�صıߣ����д���
		while(!pq.isEmpty() && mst.size()<G.V()) {
			//�ҵ�Ȩ����С�ı�
			Edge e =pq.delMin();
			//�ҵ��ñߵ���������
			int v = e.either();
			int w = e.other(v);
			
			//�ж������������Ƿ���ͬһ�����У������ͬһ�����У��򲻶Ըñ��������������ͬһ�����С����������������ڵ����ϲ�Ϊһ����
			if(uf.connected(v,w)) {
				continue;
			}
			uf.union(v, w);
			
			//�ñ�e���� ��mst������
			mst.enqueue(e);
		}
		
	
	}
	
	//��ȡ��С�����������б�
	public Queue<Edge> edges(){
		return mst;
	}
}
