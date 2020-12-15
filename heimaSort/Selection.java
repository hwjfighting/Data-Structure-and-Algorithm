package heimaSort;

public class Selection {
	/*
	 * ������a�е�Ԫ�ؽ�������
	 */
	public static void sort(Comparable[] a) {
		for(int i=0;i<a.length-1;i++) {
			//����һ����������¼��СԪ�����ڵ�������Ĭ��Ϊ����ѡ������ĵ�һ��Ԫ�����ڵ�λ��
			int minIndex=i;
			for(int j=i+1;j<a.length;j++) {
				//��Ҫ�Ƚ���С����minIndex����ֵ��j��������λ��
				if(greater(a[minIndex],a[j])) {
					minIndex=j;
				}				
			}
			//������СԪ��������������ֵ��Ԫ��i����ֵ
			exch(a,i,minIndex);
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
