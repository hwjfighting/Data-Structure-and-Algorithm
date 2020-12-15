package linear;

import java.util.Iterator;

public class Stack<T> implements Iterable<T>{
	//��¼�׽��
	private Node head;
	//ջ��Ԫ�صĸ���
	private int N;
	
	private class Node{
		public T item;
		public Node next;
		
		public Node(T item,Node next) {
			this.item=item;
			this.next=next;
		}
	}
	
	public Stack() {
		this.head=new Node(null,null);
		this.N=0;
	}
	
	//�жϵ�ǰջ�е�Ԫ�ظ����Ƿ�Ϊ0
	public boolean isEmpty() {
		return false;
	}
	
	//��ȡջ��Ԫ�صĸ���
	public int size() {
		return N;
	}
	
	//��Ԫ��tѹ��ջ��
	public void push(T t) {
		//�ҵ��׽��ָ��ĵ�һ�����
		Node oldFirst=head.next;
		//�����½��
		Node newNode=new Node(t,null);
		//���׽��ָ���½��
		head.next=newNode;
		//���½��ָ��ԭ���ĵ�һ�����
		newNode.next=oldFirst;
		//Ԫ�ظ���+1
		N++;
	}
	
	//����ջ��Ԫ��
	public T pop() {
		//�ҵ��׽��ָ��ĵ�һ�����
		Node firstNode=head.next;
		if(firstNode==null) {
			return null;
		}
		//���׽��ָ��ԭ����һ��������һ�����
		head.next=firstNode.next;
		//Ԫ�ظ���-1
		N--;
		return firstNode.item;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new SIterator();
	}
	private class SIterator implements Iterator{
		private Node n;
		
		public SIterator() {
			this.n=head;
		}

		@Override
		public boolean hasNext() {
			
			return n.next!=null;
		}

		@Override
		public Object next() {
			n=n.next;
			return n.item;
		}
		
	} 
	
	
	
}
