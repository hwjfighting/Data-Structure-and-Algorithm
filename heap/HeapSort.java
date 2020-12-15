package heap;

public class HeapSort {
	//判断heap堆中索引i处的元素是否小于索引j处的元素
	private static boolean less(Comparable[] heap,int i,int j) {
		return heap[i].compareTo(heap[j])<0;
	}
	
	//交换heap堆中i索引和j索引处的值
	private static void exch(Comparable[] heap,int i,int j) {
		Comparable tmp=heap[i];
		heap[i]=heap[j];
		heap[j]=tmp;
	}
	
	//根据原数组sourse,构造处堆heap
	private static void createHeap(Comparable[] sourse,Comparable[] heap) {
		//把sourse中的元素拷贝到heap中，heap中的元素就形成一个无序堆
		System.arraycopy(sourse, 0, heap, 1, sourse.length);
		//对堆中的元素做下沉调整（从长度的一半处，往索引1处扫描）
		for(int i=(heap.length)/2;i>0;i--) {
			sink(heap,i,heap.length-1);
		}
	}
	
	//对sourse数组中的数据从小到大排序
	public static void sort(Comparable[] sourse) {
		//构建堆
		Comparable[] heap=new Comparable[sourse.length+1]; 
		createHeap(sourse,heap);
		//记录一个变量，记录未排序的元素中最大的索引
		int N=heap.length-1;
		//通过循环，交换1索引处的元素和排序的元素中最大的索引处的元素
		while(N!=1) {
			//交换元素
			exch(heap,N,1);
			//排除交换后的最大元素所在的索引，让它不要参与堆的下沉调整
			N--;	
			//需要对索引1处的元素进行堆的下沉调整
			sink(heap,1,N);
		}
		//把heap中的数据复制到原数组sourse中
		System.arraycopy(heap, 1, sourse, 0, sourse.length);
	}
	
	//在heap堆中，堆target处的元素最下沉，范围是0~range
	private static void sink(Comparable[] heap,int target,int range) {
		while(2*target<=range) {
			//1.找出当前节点的较大的子节点
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
			
			//2.比较当前节点的值和较大子节点的值
			if(!less(heap,target,max)) {
				break;
			}
			exch(heap,target,max);
			
			target=max;
		}
	}

}
