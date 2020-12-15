package heimaSort;

public class Shell {
	/*
	 * ������a�е�Ԫ�ؽ�������
	 */
	public static void sort(Comparable[] a) {
		//1.����a�е�Ԫ�ؽ�������
		int h=1;
		while(h<a.length/2) {
			h=2*h+1;
		}
		//2.ϣ������
		while(h>=1) {
			//����
			//2.1 �ҵ��������Ԫ��
			for(int i=h;i<a.length;i++) {
				//2.2�Ѵ������Ԫ�ز��뵽����������
				for(int j=i;j>=h;j-=h) {
					//�������Ԫ��Ϊa[j],�Ƚ�a[j]��a[j-h]
					if(greater(a[j-h],a[j])) {
						//����Ԫ��
						exch(a,j-h,j);
					}else {
						//������Ԫ���Ѿ��ҵ��˺��ʵ�λ�ã�����ѭ��
						break;
					}
				}
			}
		
			//��Сh��ֵ
			h=h/2;
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
