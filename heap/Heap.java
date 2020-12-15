package heap;

public class Heap<T extends Comparable<T>> {
	//��¼���е�Ԫ��
	private T[] items;
	//��¼����Ԫ�صĸ���
	private int N;
	
	public Heap(int capacity) {
		this.items=(T[])new Comparable[capacity+1];
		this.N=0;
	}
	
	//�ж϶�������i����Ԫ���Ƿ�С������j����Ԫ��
	private boolean less(int i,int j) {
		return items[i].compareTo(items[j])<0;
	}

	//�����Զ�������i��������j����ֵ
	private void exch(int i,int j) {
		T temp=items[i];
		items[i]=items[j];
		items[j]=temp;
	}
	
	//�����в���һ��Ԫ��
	public void insert(T t) {
		items[++N]=t;
		swim(N);
	}
	
	//ʹ���ϸ��㷨��ʹ����k����Ԫ�����ڶ��д���һ����ȷ��λ��
	private void swim (int k) {
		//ͨ��ѭ�������ϵıȽϵ�ǰ����ֵ���丸�ڵ��ֵ��������ָ��ڵ��ֵ�ȵ�ǰ����ֵС���򽻻�λ��
		while(k>1 ) {
			//�ȼ۵�ǰ���͸��ڵ�
			if(less(k/2,k)) {
				exch(k/2,k);
			}else {
				break;
			}
			k=k/2;
		}	
	}
	
	//ɾ����������Ԫ�أ�������������Ԫ��
	public T delMax() {
		T max=items[1];
		//��������i����Ԫ�غ������������Ԫ�أ�����ȫ�����������Ҳ��Ԫ�ر�Ϊ��ʱ���ڵ�
		exch(1,N);
		//�����������Ԫ��ɾ��
		items[N]=null;
		//Ԫ�ظ���-1
		N--;
		//ͨ���³������ѣ��ö���������
		sink(1);
		return max;
	}
	
	//ʹ���³��㷨��ʹ����k����Ԫ�����ڶ��д���һ����ȷ��λ��
	private void sink (int k) {
		//ͨ��ѭ�����ϵضԱȵ�ǰk�������ӽ��2*k�Լ����ӽ��2*k+1�еĽϴ�ֵ��Ԫ�ش�С�������ǰ�ڵ�С������Ҫ����λ��
		while(2*k<=N) {
			//��ȡ��ǰ�����ӽ���еĽϴ�ֵ
			int max;//��¼�ϴ������ڵ�����
			if(2*k+1<=N) {
				if(less(2*k,2*k+1)) {
					max=2*k+1;
				}else {
					max=2*k;
				}
			}else {
				max=2*k;
			}
			
			//�Ƚϵ�ǰ���ͽϴ����ֵ
			if(!less(k,max)) {
				break;
			}
			
			//����k��������ֵ��max��������ֵ
			exch(k,max);
			
			//����k��ֵ
			k=max;
			
		}
	}
	
	
}
