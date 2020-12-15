package heimaSort;

public class Insertion {
	/*
	 * ������a�е�Ԫ�ؽ�������
	 */
	public static void sort(Comparable[] a) {
		for(int i=1;i<a.length;i++) {
			for(int j=i;j>0;j--) {
				//�Ƚ�����j����ֵ������j-1����ֵ������j����ֵ���򽻻����ݣ����������ô���ҵ����ʵ�λ�ã��˳�ѭ������
				if(greater(a[j-1],a[j])) {
					exch(a,j-1,j);
				}else {
					break;
				}
			}
		}
		
	}
	/*
	 * �Ƚ�vԪ���Ƿ����wԪ��
	 */
	private static boolean greater(Comparable v,Comparable w) {
		return v.compareTo(w)>0;
	}
	/*
	 * ����Ԫ��i��j����λ��
	 */
	private static void exch(Comparable[] a,int i,int j) {
		Comparable temp;
		temp=a[i];
		a[i]=a[j];
		a[j]=temp;
	}
}
