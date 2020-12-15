package heap;

public class HeapSort {
	//�ж�heap��������i����Ԫ���Ƿ�С������j����Ԫ��
	private static boolean less(Comparable[] heap,int i,int j) {
		return heap[i].compareTo(heap[j])<0;
	}
	
	//����heap����i������j��������ֵ
	private static void exch(Comparable[] heap,int i,int j) {
		Comparable tmp=heap[i];
		heap[i]=heap[j];
		heap[j]=tmp;
	}
	
	//����ԭ����sourse,���촦��heap
	private static void createHeap(Comparable[] sourse,Comparable[] heap) {
		//��sourse�е�Ԫ�ؿ�����heap�У�heap�е�Ԫ�ؾ��γ�һ�������
		System.arraycopy(sourse, 0, heap, 1, sourse.length);
		//�Զ��е�Ԫ�����³��������ӳ��ȵ�һ�봦��������1��ɨ�裩
		for(int i=(heap.length)/2;i>0;i--) {
			sink(heap,i,heap.length-1);
		}
	}
	
	//��sourse�����е����ݴ�С��������
	public static void sort(Comparable[] sourse) {
		//������
		Comparable[] heap=new Comparable[sourse.length+1]; 
		createHeap(sourse,heap);
		//��¼һ����������¼δ�����Ԫ������������
		int N=heap.length-1;
		//ͨ��ѭ��������1��������Ԫ�غ������Ԫ����������������Ԫ��
		while(N!=1) {
			//����Ԫ��
			exch(heap,N,1);
			//�ų�����������Ԫ�����ڵ�������������Ҫ����ѵ��³�����
			N--;	
			//��Ҫ������1����Ԫ�ؽ��жѵ��³�����
			sink(heap,1,N);
		}
		//��heap�е����ݸ��Ƶ�ԭ����sourse��
		System.arraycopy(heap, 1, sourse, 0, sourse.length);
	}
	
	//��heap���У���target����Ԫ�����³�����Χ��0~range
	private static void sink(Comparable[] heap,int target,int range) {
		while(2*target<=range) {
			//1.�ҳ���ǰ�ڵ�Ľϴ���ӽڵ�
			int max;
			if(2*target+1<=range) {
				if(less(heap,2*target,2*target+1)) {
					max=2*target+1;
				}else {
					max=2*target;
				}
				
			}else {
				max=2*target;
			}
			
			//2.�Ƚϵ�ǰ�ڵ��ֵ�ͽϴ��ӽڵ��ֵ
			if(!less(heap,target,max)) {
				break;
			}
			exch(heap,target,max);
			
			target=max;
		}
	}

}
