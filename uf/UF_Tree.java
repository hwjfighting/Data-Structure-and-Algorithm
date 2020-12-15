package uf;

public class UF_Tree {
	//��¼���Ԫ�غ͸�Ԫ�����ڷ���ı�ʶ
		private int[] eleAndGroup;
		//��¼���鼯������ķ������
		private int count;
		//��ʼ�����鼯
		public UF_Tree(int N) {
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
		
		
		//�жϲ��鼯Ԫ��p��Ԫ��q�Ƿ�Ϊ��ͬһ������
		public boolean connected(int p,int q) {
			return find(p)==find(q);
		} 
		
		//Ԫ��p���ڷ���ı�ʶ��
		public int find(int p) {
			while(true) {
				if(p==eleAndGroup[p]) {
					return p;
				}
				
				p=eleAndGroup[p];
			}
		}
		
		//��pԪ�����ڷ����qԪ�����ڷ���ϲ�
		public void union(int p,int q) {
			//�ҵ�pԪ�غ�qԪ�����ڶ�Ӧ�����ĸ��ڵ�
			int pRoot=find(p);
			int qRoot=find(q);
			
			//���p��q�Ѿ���ͬһ�����ˣ�����Ҫ�ϲ�
			if(pRoot==qRoot) {
				return;
			}
			
			// ��p�������ĸ��ڵ�ĸ��ڵ�Ϊq���ڵ����ĸ��ڵ㼴��
			eleAndGroup[pRoot]=qRoot;
			
			//�������-1
			this.count--;
			
			

	}


}
