package graph;

import linear.Queue;
import priority.IndexMinPriorityQueue;

public class DijkstraSP {
	//���������㣬ֵ��ʾ�Ӷ���s����ǰ��������·���ϵ����һ����
	private DirectedEdge[] edgeTo;
	//���������㣬ֵ�Ӷ���s����ǰ��������·������Ȩ��
	private double[] distTo;
	//������ж���������ж���֮�����Ч���б�
	private IndexMinPriorityQueue<Double> pq;
	
	//����һ����Ȩ����ͼG�Ͷ���s������һ�����㶥��Ϊs�����·��������
	public DijkstraSP(EdgeWeightedDiagraph G,int s) {
		//��ʼ��edgeTo
		this.edgeTo = new DirectedEdge[G.V()];
		//��ʼ��distTo
		this.distTo = new double[G.V()];
		for(int i = 0;i<distTo.length;i++) {
			distTo[i] = Double.POSITIVE_INFINITY;
		}
		//��ʼ��pq
		this.pq = new IndexMinPriorityQueue<>(G.V());
		
		//�ҵ�ͼG���Զ���sΪ�������·����
		//Ĭ���ö���s���뵽���·������
		distTo[s] = 0.0;
		pq.insert(s,0.0);
		
		//����pq
		while(!pq.isEmpty()) {
			relax(G,pq.delMin());
		}
	}
	
	
	//�ɳ�ͼG�еĶ���v
	private void relax(EdgeWeightedDiagraph G,int v) {
		for(DirectedEdge edge : G.adj(v)) {
			//��ȡ���ñߵ��յ�w
			int w = edge.to();
			
			//ͨ���ɳڼ������жϴ����s������w�����·���Ƿ���Ҫ�ȴӶ���s������v��Ȼ�����ɶ���v������w
			if(distTo(v)+edge.weight()<distTo(w)) {
				distTo[w] = distTo[v]+edge.weight();
				edgeTo[w] = edge;
				
				//�ж�pq���Ƿ��Ѿ����ڶ���w��������ڣ������Ȩ�أ���������ڣ���ֱ�����
				if(pq.contains(w)) {
					pq.changeItem(w, distTo(w));
				}else {
					pq.insert(w, distTo(w));
				}
			}
		}
	}
	//��ȡ�Ӷ���s������v�����·������Ȩ��
	public double distTo(int v) {
		return distTo[v];
	}
	//�жϴӶ���s������v�Ƿ�ɴ�
	public boolean hasPathTo(int v) {
		return distTo[v]<Double.POSITIVE_INFINITY;
	}
	//��ѯ�����s������v�����·�������еı�
	public Queue<DirectedEdge> pathTo(int v){
		//�жϴӶ���s������v�Ƿ�ɴ������ɴ��ֱ�ӷ���null
		if(!hasPathTo(v)) {
			return null;
		}
		//�������ж���
		Queue<DirectedEdge> allEdges = new Queue<>();
		while(true) {
			DirectedEdge e = edgeTo[v];
			if(e == null) {
				break;
			}
			allEdges.enqueue(e);
			v = e.from();
		}
		return allEdges;
	}
	
	
}
