package graph;

import linear.Queue;
import priority.IndexMinPriorityQueue;

public class PrimMST {
	//���� �����㣬ֵ��ʾ��ǰ����� ��С������֮�����̱�
	private Edge[] edgeTo;
	//���������㣬ֵ��ʾ��ǰ�������С������֮�����̱ߵ�Ȩ��
	private double[] distTo;
	//���������� �������ǰ�����Ѿ��������У���ֵΪtrue������Ϊfalse
	private boolean[] marked;
	//������ж���������ж���֮�����Ч���б�
	private IndexMinPriorityQueue<Double> pq;
	
	//����һ����Ȩ����ͼ��������С�������������
	public PrimMST(EdgeWeightedGraph G) {
		//��ʼ��edgeTo
		this.edgeTo = new Edge[G.V()];
		//��ʼ��distTo
		this.distTo = new double[G.V()];
		for(int i = 0;i<distTo.length;i++) {
			distTo[i] = Double.POSITIVE_INFINITY; //double��ֵ�� ���ֵ
		}
		//��ʼ��marked
		this.marked = new boolean[G.V()];
		//��ʼ��pq
		pq = new IndexMinPriorityQueue<Double>(G.V());
		
		//Ĭ���ö���0���� �����У���������ֻ��һ������0�����0����Ĭ��û�к������Ķ�������������distTo��Ӧλ�ô���ֵ�洢����0.0
		distTo[0] = 0.0;
		pq.insert(0,0.0);
		
		//����������С���ȶ��У��õ���СN�б߶�Ӧ�Ķ��㣬�Ѹö�����뵽��С��������
		while(!pq.isEmpty()) {
			visit(G,pq.delMin());
		}
		
	}
	
	//������v��ӵ���С�������У����Ҹ�������
	private void visit(EdgeWeightedGraph G,int v) {
		//�Ѷ���v��ӵ���С��������
		marked[v] = true;
		//��������
		for(Edge e : G.adj(v)) {
			//��ȡe�ߵ�����һ�����㣨��ǰ������v��
			int w = e.other(v);
			//�ж���һ�������ǲ����Ѿ������У�����������У��򣬲����κδ�������������У����������
			if(marked[w]) {
				continue;
			}
			
			//�жϱ�e��Ȩ���Ƿ�С�ڴ�w���� �������Ѿ����ڵ���С�ߵ�Ȩ��
			if(e.weight()<distTo[w]) {
				//��������
				edgeTo[w] = e;
				distTo[w] = e.weight();
				if(pq.contains(w)) {
					pq.changeItem(w, e.weight());
				}else {
					pq.insert(w, e.weight());
				}
			}
		}
	}
	
	//��ȡ��С�����������б�
	public Queue<Edge> edges(){
		//�������ж���
		Queue<Edge> allEdges = new Queue<>();
		//����edgeTo���飬�õ�ÿһ���ߣ������Ϊnull������ӵ�������
		for(int i = 0;i<edgeTo.length;i++) {
			if(edgeTo[i] != null) {
				allEdges.enqueue(edgeTo[i]);
			}
		}
		return allEdges;
	}

}
