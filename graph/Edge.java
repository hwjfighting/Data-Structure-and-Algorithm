package graph;

public class Edge implements Comparable<Edge>{
	private final int v; //����һ
	private final int w; //�����
	private final double weight;//��ǰ�ߵ�Ȩ��
	
	//ͨ������v��w���Լ�Ȩ��weightֵ����һ���߶���
	public Edge(int v,int w,double weight) {
		this.v = v;
		this.w = w;
		this.weight = weight;
	}
	
	//��ȡ���ϵ�Ȩ��ֵ
	public double weight() {
		return weight;
	}
	
	//��ȡ���ϵ�һ����
	public int either() {
		return v;
	}
	
	//��ȡ���ϳ��˶���vertex�������һ������
	public int other(int vertex) {
		if(vertex == v) {
			return w;
		}else {
			return v;
		}
	}

	@Override
	public int compareTo(Edge that) {
		//ʹ��һ��������¼�ȽϵĽ��
		int cmp;
		if(this.weight()>that.weight()) {
			//�����ǰ�ߵ�Ȩ��ֵ������cmp=1
			cmp=1;
		}else if(this.weight()<that.weight()) {
			//�����ǰ�ߵ�Ȩ��ֵС������cmp=-1
			cmp=-1;
		}else {
			//�����ǰ�ߵ�Ȩ��ֵ��that�ߵ�Ȩ��ֵһ��������cmp=0
			cmp=0;
		}
		return cmp;
		
	}

}
