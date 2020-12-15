package linear;

import java.util.Iterator;

public class SequenceList<T> implements Iterable<T> {
	//�洢Ԫ�ص�����
	private T[] eles;
	//��¼��ǰ˳�����Ԫ�صĸ���
	private int N;
	
	//���캯��
	public SequenceList(int capacity) {
		//��ʼ������
		this.eles=(T[])new Object[capacity];
		//��ʼ������
		this.N=0;
	}
	
	//��һ�����Ա���Ϊ�ձ�
	public void clear() {
		this.N=0;
	}
	
	//�жϵ�ǰ���Ա��Ƿ�Ϊ�ձ�
	public boolean isEmpty() {
		return N==0;
	}
	
	//��ȡ���Ա�ĳ���
	public int length() {
		return N;
	}
	
	//��ȡָ��λ�õ�Ԫ��
	public T get(int i) {
		return eles[i];
	}
	
	//�����Ա������Ԫ��
	public void insert(T t) {
		if(N==eles.length) {
			resize(2*eles.length);
		}
		eles[N++]=t;
	}
	
	//��iԪ�ش�����Ԫ��t
	public void insert(int i,T t) {
		if(N==eles.length) {
			resize(2*eles.length);
		}
		//�Ȱ�i��������Ԫ�ؼ�������Ԫ����������ƶ�һλ
		for(int index=N;index>i;index--) {
			eles[index]=eles[index-1];
		}
		//�ٰ�tԪ�طŵ�i����������
		eles[i]=t;
		
		N++;
		
	}
	
	//ɾ��ָ��λ��i����Ԫ�أ������ظ�Ԫ��
	public T remove(int i) {
		
		//��¼����i����ֵ
		T current = eles[i];
		//����i�����Ԫ��������ǰ�ƶ�һλ����
		for(int index=i;index<N-1;index++) {
			eles[index]=eles[index+1];
		}
		//Ԫ�ظ���-1
		N--;
		if(N<eles.length/4) {
			resize(eles.length/2);
		}
		
		return current;
	}
	
	//����tԪ�ص�һ�γ��ֵ�λ��
	public int indexOf(T t) {
		for(int i=0;i<N;i++) {
			if(eles[i].equals(t)) {
				return i;
			}
		}
		return -1;
	}
	
	//���ݲ���newSize,����eles�Ĵ�С
	public void resize(int newSize) {
		//����һ����ʱ���飬ָ��ԭ����
		T[] temp=eles;
		//����������
		eles=(T[])new Object[newSize];
		//��ԭ��������ݿ����������鼴��
		for(int i=0;i<N;i++) {
			eles[i]=temp[i];
		}
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new SIterator();
	}
	
	private class SIterator implements Iterator {
		private int cursor;
		public SIterator() {
			this.cursor=0;
		}

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return cursor<N;
		}

		@Override
		public Object next() {
			
			return eles[cursor++];
		}
		
	}

}
