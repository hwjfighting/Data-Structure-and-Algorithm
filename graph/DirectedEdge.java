package graph;

public class DirectedEdge {
	//���
	private final int v;
	//�յ�
	private final int w;
	//��ǰ�ߵ�Ȩ��
	private final double weight;
	
	//ͨ������v��w���Լ�Ȩ��weightֵ����һ���߶���
	public DirectedEdge(int v,int w,double weight) {
		this.v = v;
		this.w = w;
		this.weight = weight;
	}
	
	//��ȡ�ߵ�Ȩ��ֵ
	public double weight() {
		return weight;
	}
	
	//��ȡ����ߵ����
	public int from() {
		return v;
	}
	
	//��ȡ����ߵ��յ�
	public int to() {
		return w;
	}
	
	
}

