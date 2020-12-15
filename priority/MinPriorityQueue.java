package priority;

public class MinPriorityQueue<T extends Comparable<T>> {
	//�洢���е�Ԫ��
	private T[] items;
	//��¼����Ԫ�صĸ���
	private int N;
	
	public MinPriorityQueue(int capacity) {
		this.items=(T[])new Comparable[capacity+1];
		this.N=0;
	}
	
	//��ȡ������Ԫ�صĸ���
	public int size() {
		return N;
	}
	
	//�ж϶����Ƿ�Ϊ��
	public boolean isEmpty() {
		return N==0;
	}
	
	//�ж϶�������i����Ԫ���Ƿ�С������j����Ԫ��
	private boolean less(int i,int j) {
		return items[i].compareTo(items[j])<0; 
	}
	
	//��������i������j�������Ķ�
	private void exch(int i,int j) {
		T tmp=items[i];
		items[i]=items[j];
		items[j]=tmp;
	}
	
	//�����в���һ��Ԫ��
	public void insert(T t) {
		items[++N]=t;
		swim(N);
	}
	//ɾ��������С��Ԫ�أ������������СԪ��
	public T delMin() {
		T min=items[1];
		exch(1,N);
		N--;
		sink(1);
		return min;
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
