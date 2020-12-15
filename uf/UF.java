package uf;

public class UF {
	//��¼���Ԫ�غ͸�Ԫ�����ڷ���ı�ʶ
	private int[] eleAndGroup;
	//��¼���鼯������ķ������
	private int count;
	//��ʼ�����鼯
	public UF(int N) {
		//��ʼ�������������Ĭ������£���N������
		this.count=N;
		
		//��ʼ��eleAndGroup����
		this.eleAndGroup = new int[N];
		
		//��ʼ��eleAndGroup�е�Ԫ�ؼ������ڵ���ı�ʶ������eleAndGroup�����е�������Ϊ���鼯��ÿ������Ԫ�أ�������ÿ����������ֵ����Ԫ��������ı�ʶ�������Ǹ�����
		for(int i=0;i<eleAndGroup.length;i++) {
			eleAndGroup[i]=i;
		}
	}
	
	//��ȡ��ǰ���鼯�������ж��ٸ�����
	public int count() {
		return count;
	}
	
	//Ԫ��p���ڷ���ı�ʶ��
	public int find(int p) {
		return eleAndGroup[p];
	}
	
	//�жϲ��鼯��Ԫ��p��Ԫ��q�Ƿ���ͬһ������
	public boolean connected(int p,int q) {
		return find(p)==find(q);
	}
	
	//��pԪ�����ڷ����qԪ�����ڷ���ϲ�
	public void union(int p,int q) {
		//�ж�Ԫ��q��p�Ƿ��Ѿ���ͬһ�������У�����Ѿ���ͬһ�������У�����������Ϳ�����
		if(connected(p,q)) {
			return;
		}
		//�ҵ�p���ڷ���ı�ʶ��
		int pGroup=find(p);
		
		//�ҵ�q���ڷ���ı�ʶ��
		int qGroup=find(q);
		
		//�ϲ���:��p�����������Ԫ�ص����ʶ����Ϊq���ڷ���ı�ʶ��
		for(int i=0;i<eleAndGroup.length;i++) {
			if(eleAndGroup[i]==pGroup) {
				eleAndGroup[i]=qGroup;
			}
		}
		
		//����Ԫ�ظ���-1
		this.count--;
	}

}
