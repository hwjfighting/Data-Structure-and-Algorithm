package uf;

public class UF_Tree_Weighted {
	//��¼���Ԫ�غ͸�Ԫ�����ڷ���ı�ʶ
		private int[] eleAndGroup;
		//��¼���鼯������ķ������
		private int count;
		//�����洢ÿһ�����ڵ��Ӧ�����б���ĸ��ڵ�ĸ���
		private int[] sz;
		
		//��ʼ�����鼯
		public UF_Tree_Weighted(int N) {
			//��ʼ�������������Ĭ������£���N������
			this.count=N;
			
			//��ʼ��eleAndGroup����
			this.eleAndGroup = new int[N];
			
			//��ʼ��eleAndGroup�е�Ԫ�ؼ������ڵ���ı�ʶ������eleAndGroup�����е�������Ϊ���鼯��ÿ������Ԫ�أ�������ÿ����������ֵ����Ԫ��������ı�ʶ�������Ǹ�����
			for(int i=0;i<eleAndGroup.length;i++) {
				eleAndGroup[i]=i;
			}
			
			this.sz=new int[N];
			
			//Ĭ������£�sz��ÿ����������ֵ����1
			for(int i=0;i<sz.length;i++) {
				sz[i]=1;
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
			
			//�ж�proot��Ӧ��������qroot��Ӧ������������Ҫ�ѽ�С�����ϲ����ϴ������
			if(sz[pRoot]<sz[qRoot]) {
				eleAndGroup[pRoot]=qRoot;
				sz[qRoot]+=pRoot;
			}else {
				eleAndGroup[qRoot]=pRoot;
				sz[pRoot]+=qRoot;
			}
			
			
			//�������-1
			this.count--;
			
			

	}


}
