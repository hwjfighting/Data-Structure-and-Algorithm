package priority;

public class IndexMinPriorityQueue<T extends Comparable<T>> {
	//�洢���е�Ԫ��
	private T[] items;
	//����ÿ��Ԫ����items�����е�������pq������Ҫ������
	private int[] pq;
	//����qp������pq��ֵ��Ϊ������pq��������Ϊֵ
	private int[] qp;
	//��¼����Ԫ�صĸ���
	private int N;
	
	public IndexMinPriorityQueue(int capacity) {
		this.items=(T[])new Comparable[capacity+1];
		this.pq=new int[capacity+1];
		this.qp=new int[capacity+1];
		this.N=0;
		
		//Ĭ������£�������û�д洢�κ����ݣ���qp�е�Ԫ�ض�Ϊ-1
		for(int i=0;i<qp.length;i++) {
			qp[i]=-1;
		}
	}
	
	//��ȡ������Ԫ�صĸ���
	public int size() {
		return N;
	}
	
	//�ж϶����Ƿ�Ϊ��
	public boolean isEmpty() {
		return N==0; 
	}
	
	//�ж϶�������i����Ԫ���Ƿ�С������j����ֵ
	public boolean less(int i,int j) {
		return items[pq[i]].compareTo(items[pq[j]])<0;
	}
	
	//��������i������j��������ֵ
	public void exch(int i,int j) {
		//���Qpq�е�����
		int tmp=pq[i];
		pq[i]=pq[j];
		pq[j]=tmp;
		
		//����qp�е�����
		qp[pq[i]]=i;
		qp[pq[j]]=j;		
	}
	
	//�ж�k��Ӧ��Ԫ���Ƿ����
	public boolean contains(int k) {
		return qp[k]!=-1;
	}
	
	//�������в���һ��Ԫ�أ�����������i
	public void insert(int i,T t) {
		  //�ж�i�Ƿ��Ѿ�������������Ѿ������������ý���
		if(contains(i)) {
			return;
		}
		//Ԫ�ظ���+1
		N++;
		//�����ݴ洢��items��Ӧ��iλ�ô�
		items[i]=t;
		//��i�洢��pq��
		pq[N]=i;
		//ͨ��qp����¼pq�е�i
		qp[i]=N;
		
		//ͨ�����ϸ���ɶѵĵ���
		swim(N);
		
	}
	
	//ɾ����������С��Ԫ�أ������ظ�Ԫ�ع���������
	public int delMin() {
		//��ȡ��СԪ�ع���������
		int minIndex=pq[1];
		//����pq������1����������Դ���Ԫ��
		exch(1,N);
		//ɾ��qp�ж�Ӧ������
		qp[pq[N]]=-1;
		//ɾ��pq���������������
		pq[N]=-1;
		//ɾ��items�ж�Ӧ������
		items[minIndex]=null;
		//Ԫ�ظ���-1
		N--;
		//�³�����
		sink(1);
		return minIndex;
	}
	
	//ɾ������i������Ԫ��
	public void delete(int i) {
		//�ҵ�i��pq�е�����
		int k=qp[i];
		//����pq������k����ֵ������N����ֵ
		exch(k,N);
		//ɾ��qp�е�����
		qp[pq[N]]=-1;
		//ɾ��pq�е�����
		pq[N]=-1;
		//ɾ��items�е�����
		items[k]=null;
		//Ԫ�ظ���-1
		N--;
		//�ѵĵ���
		sink(k);
		swim(k);
	}
	
	//��������i������Ԫ���޸�Ϊt
	public void changeItem(int i,T t) {
		//�޸�items������iλ�õ�Ԫ��Ϊt
		items[i]=t;
		//�ҵ�i��pq�г��ֵ�λ��
		int k=qp[i];
		//������
		sink(k);
		swim(k);
	}
	
	//ʹ���ϸ��㷨��ʹ����k����Ԫ�����ڶ��д���һ����ȷ��λ��
	private void swim(int k) {
		while(k>1) {
			if(less(k,k/2)) {
				exch(k,k/2);
			}else {
				break;
			}
			k=k/2;						
		}
	}
	
	//ʹ���³��㷨��ʹ����k����Ԫ�����ڶ��д���һ����ȷ��λ��
	private void sink(int k) {
		while(2*k<=N) {
			int min;
			if(2*k+1<=N) {
				if(less(2*k,2*k+1)) {
					min=2*k;
				}else {
					min=2*k+1;
				}				
			}else {
				min=2*k;
			}
			if(!less(min,k)) {
				break;
			}
			exch(min,k);
			k=min;
		}
	}
}
